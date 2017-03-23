package org.crazyit.toast;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

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
public class ToastTest extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button simple = (Button)findViewById(R.id.simple);
		//Ϊ��ť�ĵ����¼����¼�������
		simple.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View source)
			{
				//����һ��Toast��ʾ��Ϣ
				Toast toast = Toast.makeText(ToastTest.this
					, "�򵥵���ʾ��Ϣ"
					// ���ø�Toast��ʾ��Ϣ�ĳ���ʱ��
					, Toast.LENGTH_SHORT);
				toast.show();
			}
		});
		Button bn = (Button)findViewById(R.id.bn);
		//Ϊ��ť�ĵ����¼����¼�������
		bn.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View source)
			{
				//����һ��Toast��ʾ��Ϣ
				Toast toast = Toast.makeText(ToastTest.this
					, "��ͼƬ�ĵ���ʾ��Ϣ"
					// ���ø�Toast��ʾ��Ϣ�ĳ���ʱ��
					, Toast.LENGTH_LONG);				
				toast.setGravity(Gravity.CENTER, 0, 0);
				//��ȡToast��ʾ��ԭ�е�View
				View toastView = toast.getView();
				//����һ��ImageView
				ImageView image = new ImageView(ToastTest.this);
				image.setImageResource(R.drawable.tools);
				//����һ��LinearLayout����
				LinearLayout ll = new LinearLayout(ToastTest.this);
				//��LinearLayout�����ͼƬ��ԭ�е�View
				ll.addView(image);
				ll.addView(toastView);
				toast.setView(ll);
				toast.show();				
			}
		});	
	}
}