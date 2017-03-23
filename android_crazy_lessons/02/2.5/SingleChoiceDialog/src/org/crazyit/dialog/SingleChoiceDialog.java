package org.crazyit.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
public class SingleChoiceDialog extends Activity
{
	final int SINGLE_DIALOG = 0x113;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button bn = (Button)findViewById(R.id.bn);
		//Ϊ��ť���¼�������
		bn.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View source)
			{
				//��ʾ�Ի���
				showDialog(SINGLE_DIALOG);				
			}
		});
	}
	//��дonCreateDialog���������Ի���
	@Override
	public Dialog onCreateDialog(int id, Bundle state)
	{
		//�ж���Ҫ�����������͵ĶԻ���
		switch (id)
		{
			case SINGLE_DIALOG:
				Builder b = new AlertDialog.Builder(this);
				// ���öԻ����ͼ��
				b.setIcon(R.drawable.tools);
				// ���öԻ���ı���
				b.setTitle("��ѡ�б�Ի���");
				// Ϊ�Ի������ö���б�
				b.setSingleChoiceItems(new String[]
				{ "��ɫ", "��ɫ", "��ɫ" }
				// Ĭ��ѡ�еڶ���
					, 1
					//Ϊ�б���ĵ����¼����ü�����
					, new OnClickListener()
					{
						@Override
						public void onClick(DialogInterface dialog,
							int which)
						{
							TextView show = (TextView) findViewById(R.id.show);
							// which�����ĸ��б��������
							switch (which)
							{
								//�޸��ı���ı���ɫ
								case 0:
									show.setBackgroundColor(Color.RED);
									break;
								case 1:
									show.setBackgroundColor(Color.GREEN);
									break;
								case 2:
									show.setBackgroundColor(Color.BLUE);
									break;
							}
						}
					});
				// ���һ����ȷ������ť�����ڹرոöԻ���
				b.setPositiveButton("ȷ��", null);
				// �����Ի���
				return b.create();
		}
		return null;
	}
}