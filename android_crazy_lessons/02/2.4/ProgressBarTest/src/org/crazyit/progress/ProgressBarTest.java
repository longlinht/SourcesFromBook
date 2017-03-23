package org.crazyit.progress;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

/**
 * Description:
 * <br/>site: <a href="http://www.crazyit.org">crazyit.org</a> 
 * <br/>Copyright (C), 2001-2012, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class ProgressBarTest extends Activity
{
	//�ó���ģ����䳤��Ϊ100������
	private int[] data = new int[100];
	int hasData = 0;
	//��¼ProgressBar����ɽ���
	int status = 0;	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		final ProgressBar bar = (ProgressBar) findViewById(R.id.bar);
		final ProgressBar bar2 = (ProgressBar) findViewById(R.id.bar2);
		//����һ��������µĽ��ȵ�Handler
		final Handler mHandler = new Handler()
		{
			@Override
			public void handleMessage(Message msg)
			{
				//������Ϣ���ɸó����͵ġ�
				if (msg.what == 0x111)
				{
					bar.setProgress(status);
					bar2.setProgress(status);
				}
			}
		};
		//�����߳���ִ������
		new Thread()
		{
			public void run()
			{
				while (status < 100)
				{
					// ��ȡ��ʱ��������ɰٷֱ�
					status = doWork();
					// ������Ϣ��Handler
					Message m = new Message();
					m.what = 0x111;
					// ������Ϣ
					mHandler.sendMessage(m);
				}
			}
		}.start();
	}
	//ģ��һ����ʱ�Ĳ�����
	public int doWork()
	{
		//Ϊ����Ԫ�ظ�ֵ
		data[hasData++] = (int)(Math.random() * 100);
		try
		{
			Thread.sleep(100);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		return hasData;
	}
}