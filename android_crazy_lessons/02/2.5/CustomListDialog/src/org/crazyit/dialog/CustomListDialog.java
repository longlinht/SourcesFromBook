package org.crazyit.dialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleAdapter;
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
public class CustomListDialog extends Activity
{
	final int LIST_DIALOG = 0x113;
	//����3���б��������
	private String[] names = new String[]
	{ "����", "����", "����"};
	//����3���б����Ӧ��ͼ��
	private int[] imageIds = new int[]
	{ R.drawable.p , R.drawable.z
		, R.drawable.t
	};
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
				showDialog(LIST_DIALOG);
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
			case LIST_DIALOG:
				Builder b = new AlertDialog.Builder(this);
				// ���öԻ����ͼ��
				b.setIcon(R.drawable.tools);
				// ���öԻ���ı���
				b.setTitle("��ѡ�б�Ի���");
				//����һ��List����List�����Ԫ����Map
				List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
				for (int i = 0; i < names.length; i++)
				{
					Map<String, Object> listItem = new HashMap<String, Object>();
					listItem.put("header", imageIds[i]);
					listItem.put("personName", names[i]);
					listItems.add(listItem);
				}
				//����һ��SimpleAdapter
				SimpleAdapter simpleAdapter = new SimpleAdapter(this
					, listItems 
					, R.layout.row
					, new String[]{ "personName", "header" }
					, new int[]{R.id.name , R.id.header});
				
				// Ϊ�Ի������ö���б�
				b.setAdapter(simpleAdapter				
					//Ϊ�б���ĵ����¼����ü�����
					, new DialogInterface.OnClickListener()
					{
						@Override
						public void onClick(DialogInterface dialog,
							int which)
						{
							TextView show = (TextView) findViewById(R.id.show);
							// which�����ĸ��б��������
							show.setText("�����ó�������Ϊ��" + names[which]);

						}
					});
				// �����Ի���
				return b.create();
		}
		return null;
	}
}
