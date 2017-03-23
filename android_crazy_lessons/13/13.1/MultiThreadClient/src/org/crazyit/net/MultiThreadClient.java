package org.crazyit.net;

import java.io.OutputStream;
import java.net.Socket;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

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
public class MultiThreadClient extends Activity
{
	// ��������ϵ������ı���
	EditText input, show;
	// ��������ϵ�һ����ť
	Button send;
	OutputStream os;
	Handler handler;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		input = (EditText) findViewById(R.id.input);
		send = (Button) findViewById(R.id.send);
		show = (EditText) findViewById(R.id.show);
		Socket s;
		handler = new Handler()
		{
			@Override
			public void handleMessage(Message msg)
			{
				// �����Ϣ���������߳�
				if (msg.what == 0x123)
				{
					// ����ȡ������׷����ʾ���ı�����
					show.append("\n" + msg.obj.toString());
				}
			}
		};
		try
		{
			s = new Socket("192.168.1.88", 30000);
			// �ͻ�������ClientThread�̲߳��϶�ȡ���Է�����������
			new Thread(new ClientThread(s, handler)).start(); // ��
			os = s.getOutputStream();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		send.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				try
				{
					// ���û����ı��������������д������
					os.write((input.getText().toString() + "\r\n")
						.getBytes("utf-8"));
					// ���input�ı���
					input.setText("");
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
}