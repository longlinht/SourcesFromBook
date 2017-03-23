package org.crazyit.dialog;

import org.crazyit.dialog.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
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
public class MultiChoiceDialog extends Activity
{
	final int SINGLE_DIALOG = 0x113;
	String[] colorNames = new String[]
	{ "��ɫ", "��ɫ", "��ɫ" };
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button bn = (Button) findViewById(R.id.bn);
		// Ϊ��ť���¼�������
		bn.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View source)
			{
				// ��ʾ�Ի���
				showDialog(SINGLE_DIALOG);
			}
		});
	}
	@Override
	public Dialog onCreateDialog(int id, Bundle state)
	{
		// �ж���Ҫ�����������͵ĶԻ���
		switch (id)
		{
			case SINGLE_DIALOG:
				Builder b = new AlertDialog.Builder(this);
				// ���öԻ����ͼ��
				b.setIcon(R.drawable.tools);
				// ���öԻ���ı���
				b.setTitle("��ѡ�б�Ի���");
				final boolean[] checkStatus = new boolean[] { true, false, true };
				// Ϊ�Ի������ö���б�
				b.setMultiChoiceItems(new String[] { "��ɫ", "��ɫ", "��ɫ" }
				// ����Ĭ�Ϲ�ѡ����Щ�б���
					, checkStatus
					// Ϊ�б���ĵ����¼����ü�����
					, new OnMultiChoiceClickListener()
					{
						@Override
						public void onClick(DialogInterface dialog, int which,
							boolean isChecked)
						{
							EditText show = (EditText) findViewById(R.id.show);
							String result = "��ϲ������ɫΪ��";
							for (int i = 0; i < checkStatus.length; i++)
							{
								// �����ѡ�ѡ��
								if (checkStatus[i])
								{
									result += colorNames[i] + "��";
								}
							}
							show.setText(result);
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