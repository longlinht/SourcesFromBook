package org.crazyit.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

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
public class ProgressDialogTest extends Activity
{
	// �ó���ģ����䳤��Ϊ100������
	private int[] data = new int[100];
	int hasData = 0;
	// ������ȶԻ���ı�ʶ
	final int PROGRESS_DIALOG = 0x112;
	// ��¼���ȶԻ������ɰٷֱ�
	int progressStatus = 0;
	ProgressDialog pd;
	// ����һ��������µĽ��ȵ�Handler
	Handler handler;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button execBn = (Button) findViewById(R.id.exec);
		execBn.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View source)
			{
				showDialog(PROGRESS_DIALOG);
			}
		});
		handler = new Handler()
		{
			@Override
			public void handleMessage(Message msg)
			{
				// ������Ϣ���ɸó����͵ġ�
				if (msg.what == 0x111)
				{
					pd.setProgress(progressStatus);
				}
			}
		};
	}

	@Override
	public Dialog onCreateDialog(int id, Bundle status)
	{
		System.out.println("------create------");
		switch (id)
		{
			case PROGRESS_DIALOG:
				// �������ȶԻ���
				pd = new ProgressDialog(this);
				pd.setMax(100);
				// ���öԻ���ı���
				pd.setTitle("������ɰٷֱ�");
				// ���öԻ��� ��ʾ������
				pd.setMessage("��ʱ�������ɰٷֱ�");
				// ���öԻ������á�ȡ������ť�ر�
				pd.setCancelable(false);
				// ���öԻ���Ľ��������
//				pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
				pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
				// ���öԻ���Ľ������Ƿ���ʾ����
				pd.setIndeterminate(false);
				break;
		}
		return pd;
	}

	// �÷�������onCreateDialog��������֮�󱻻ص�
	@Override
	public void onPrepareDialog(int id, Dialog dialog)
	{
		System.out.println("------prepare------");
		super.onPrepareDialog(id, dialog);
		switch (id)
		{
			case PROGRESS_DIALOG:
				// �Ի����������
				pd.incrementProgressBy(-pd.getProgress());
				new Thread()
				{
					public void run()
					{
						while (progressStatus < 100)
						{
							// ��ȡ��ʱ��������ɰٷֱ�
							progressStatus = doWork();
							// ������Ϣ��Handler
							Message m = new Message();
							m.what = 0x111;
							// ������Ϣ
							handler.sendMessage(m);
						}

						// ��������Ѿ����
						if (progressStatus >= 100)
						{
							// �رնԻ���
							pd.dismiss();
						}
					}
				}.start();
				break;
		}
	}

	// ģ��һ����ʱ�Ĳ�����
	public int doWork()
	{
		// Ϊ����Ԫ�ظ�ֵ
		data[hasData++] = (int) (Math.random() * 100);
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