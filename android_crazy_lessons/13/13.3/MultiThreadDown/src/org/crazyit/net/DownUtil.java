/**
 * 
 */
package org.crazyit.net;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Description: <br/>
 * ��վ: <a href="http://www.crazyit.org">���Java����</a> <br/>
 * Copyright (C), 2001-2012, Yeeku.H.Lee <br/>
 * This program is protected by copyright laws. <br/>
 * Program Name: <br/>
 * Date:
 * 
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class DownUtil {
	// ����������Դ��·��
	private String path;
	// ָ�������ص��ļ��ı���λ��
	private String targetFile;
	// ������Ҫʹ�ö����߳�������Դ
	private int threadNum;
	// �������ص��̶߳���
	private DownloadThread[] threads;
	// �������ص��ļ����ܴ�С
	private int fileSize;

	public DownUtil(String path, String targetFile, int threadNum) {
		this.path = path;
		this.threadNum = threadNum;
		// ��ʼ��threads����
		threads = new DownloadThread[threadNum];
		this.targetFile = targetFile;
	}

	public void download() throws Exception {
		URL url = new URL(path);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setConnectTimeout(5 * 1000);
		conn.setRequestMethod("GET");
		conn
				.setRequestProperty(
						"Accept",
						"image/gif, image/jpeg, image/pjpeg, image/pjpeg, application/x-shockwave-flash, application/xaml+xml, application/vnd.ms-xpsdocument, application/x-ms-xbap, application/x-ms-application, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, */*");
		conn.setRequestProperty("Accept-Language", "zh-CN");
		conn.setRequestProperty("Charset", "UTF-8");
		conn
				.setRequestProperty(
						"User-Agent",
						"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.2; Trident/4.0; .NET CLR 1.1.4322; .NET CLR 2.0.50727; .NET CLR 3.0.04506.30; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729)");
		conn.setRequestProperty("Connection", "Keep-Alive");
		// �õ��ļ���С
		fileSize = conn.getContentLength();
		conn.disconnect();
		int currentPartSize = fileSize / threadNum + 1;
		RandomAccessFile file = new RandomAccessFile(targetFile, "rw");
		// ���ñ����ļ��Ĵ�С
		file.setLength(fileSize);
		file.close();
		for (int i = 0; i < threadNum; i++) {
			// ����ÿ���̵߳����صĿ�ʼλ��
			int startPos = i * currentPartSize;
			// ÿ���߳�ʹ��һ��RandomAccessFile��������
			RandomAccessFile currentPart = new RandomAccessFile(targetFile,
					"rw");
			// ��λ���̵߳�����λ��
			currentPart.seek(startPos);
			// ���������߳�
			threads[i] = new DownloadThread(startPos, currentPartSize,
					currentPart);
			// ���������߳�
			threads[i].start();
		}
	}

	// ��ȡ���ص���ɰٷֱ�
	public double getCompleteRate() {
		// ͳ�ƶ����߳��Ѿ����ص��ܴ�С
		int sumSize = 0;
		for (int i = 0; i < threadNum; i++) {
			sumSize += threads[i].length;
		}
		// �����Ѿ���ɵİٷֱ�
		return sumSize * 1.0 / fileSize;
	}

	private class DownloadThread extends Thread {
		// ��ǰ�̵߳�����λ��
		private int startPos;
		// ���嵱ǰ�̸߳������ص��ļ���С
		private int currentPartSize;
		// ��ǰ�߳���Ҫ���ص��ļ���
		private RandomAccessFile currentPart;
		// �����Ѿ����߳������ص��ֽ���
		public int length;

		public DownloadThread(int startPos, int currentPartSize,
				RandomAccessFile currentPart) {
			this.startPos = startPos;
			this.currentPartSize = currentPartSize;
			this.currentPart = currentPart;
		}

		@Override
		public void run() {
			try {
				URL url = new URL(path);
				HttpURLConnection conn = (HttpURLConnection) url
						.openConnection();
				conn.setConnectTimeout(5 * 1000);
				conn.setRequestMethod("GET");
				conn.setRequestProperty(
								"Accept",
								"image/gif, image/jpeg, image/pjpeg, image/pjpeg, application/x-shockwave-flash, " +
								"application/xaml+xml, application/vnd.ms-xpsdocument, application/x-ms-xbap, " +
								"application/x-ms-application, application/vnd.ms-excel, application/vnd.ms-powerpoint, " +
								"application/msword, */*");
				conn.setRequestProperty("Accept-Language", "zh-CN");
				conn.setRequestProperty("Charset", "UTF-8");
				InputStream inStream = conn.getInputStream();
				// ����startPos���ֽڣ��������߳�ֻ�����Լ������Ĳ����ļ���
				inStream.skip(this.startPos);
				byte[] buffer = new byte[1024];
				int hasRead = 0;
				// ��ȡ�������ݣ���д�뱾���ļ�
				while (length < currentPartSize
						&& (hasRead = inStream.read(buffer)) != -1) {
					currentPart.write(buffer, 0, hasRead);
					// �ۼƸ��߳����ص��ܴ�С
					length += hasRead;
				}
				currentPart.close();
				inStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
