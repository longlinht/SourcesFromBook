package org.crazyit.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
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
public class NotificationTest extends Activity
{
	static final int NOTIFICATION_ID = 0x1123;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//��ȡӦ�ý����е�Button����
		Button bn = (Button) findViewById(R.id.bn);
		//Ϊ��ť�ĵ����¼����¼�������
		bn.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View source)
			{
				//����һ����������Activity��Intent
				Intent intent = new Intent(NotificationTest.this
					, OtherActivity.class);
				PendingIntent pi = PendingIntent.getActivity(NotificationTest.this
					, 0, intent , 0);
				//����һ��Notification
				Notification notify = new Notification();
				//ΪNotification����ͼ�꣬��ͼ����ʾ��״̬��
				notify.icon = R.drawable.notify;
				//ΪNotification�����ı����ݣ����ı�����ʾ��״̬��
				notify.tickerText = "��������Activity��֪ͨ";
				//ΪNotification���÷���ʱ��
				notify.when = System.currentTimeMillis();
				//ΪNotification��������
				notify.defaults = Notification.DEFAULT_SOUND;
				//ΪNotification����Ĭ��������Ĭ���񶯡�Ĭ�������
				notify.defaults = Notification.DEFAULT_ALL;
				//�����¼���Ϣ
				notify.setLatestEventInfo(NotificationTest.this, "��֪ͨͨ",
					"����鿴", pi);
				//��ȡϵͳ��NotificationManager����
				NotificationManager notificationManager = (NotificationManager) 
					getSystemService(NOTIFICATION_SERVICE);
				//����֪ͨ
				notificationManager.notify(NOTIFICATION_ID, notify);
			}
		});
		Button del = (Button)findViewById(R.id.del);
		del.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				//��ȡϵͳ��NotificationManager����
				NotificationManager notificationManager = (NotificationManager) 
					getSystemService(NOTIFICATION_SERVICE);
				//ȡ��֪ͨ
				notificationManager.cancel(NOTIFICATION_ID);
			}
		});
	}
}