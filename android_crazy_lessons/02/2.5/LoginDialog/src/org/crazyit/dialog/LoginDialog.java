package org.crazyit.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;

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
public class LoginDialog extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button bn = (Button)findViewById(R.id.bn);
		//����һ��AlertDialog.Builder����
		final Builder builder = new AlertDialog.Builder(this);
		//Ϊ��ť���¼�������
		bn.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View source)
			{
				// ���öԻ����ͼ��
				builder.setIcon(R.drawable.tools);
				// ���öԻ���ı���
				builder.setTitle("�Զ�����ͨ�Ի���");
				//װ��/res/layout/login.xml���沼��
				TableLayout loginForm = (TableLayout)getLayoutInflater()
					.inflate( R.layout.login, null);
				// ���öԻ�����ʾ��View����
				builder.setView(loginForm);
				// Ϊ�Ի�������һ����ȷ������ť
				builder.setPositiveButton("��¼"
					// Ϊ��ť���ü�����
					, new OnClickListener()
					{
						@Override
						public void onClick(DialogInterface dialog, int which)
						{
							//�˴���ִ�е�¼����
						}
					});
				// Ϊ�Ի�������һ����ȡ������ť
				builder.setNegativeButton("ȡ��"
					,  new OnClickListener()
					{
						@Override
						public void onClick(DialogInterface dialog, int which)
						{
							//ȡ����¼�������κ����顣
						}
					});
				//����������ʾ�Ի���
				builder.create().show();
			}
		});
	}
}
