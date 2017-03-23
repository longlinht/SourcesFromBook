/**
 * 
 */
package org.crazyit.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import android.os.Handler;
import android.os.Message;

/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a> 
 * <br/>Copyright (C), 2001-2012, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class ClientThread implements Runnable
{
	//���̸߳������Socket
	private Socket s;
	private Handler handler;
	//���߳��������Socket����Ӧ��������
	BufferedReader br = null;
	public ClientThread(Socket s , Handler handler)
		throws IOException
	{
		this.s = s;
		this.handler = handler;
		br = new BufferedReader(
			new InputStreamReader(s.getInputStream()));
	}
	public void run()
	{
		try
		{
			String content = null;
			//���϶�ȡSocket�������е����ݡ�
			while ((content = br.readLine()) != null)
			{
				// ÿ���������Է�����������֮�󣬷�����Ϣ֪ͨ���������ʾ������
				Message msg = new Message();
				msg.what = 0x123;
				msg.obj = content;
				handler.sendMessage(msg);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

