package org.crazyit.auction.client;

import java.util.HashMap;
import java.util.Map;

import org.crazyit.auction.client.util.DialogUtil;
import org.crazyit.auction.client.util.HttpUtil;

import android.app.Activity;
import android.os.Bundle;
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
public class AddKind extends Activity
{
	// ��������������ı���
	EditText kindName, kindDesc;
	// ���������������ť
	Button bnAdd, bnCancel;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_kind);
		// ��ȡ�����������༭��
		kindName = (EditText) findViewById(R.id.kindName);
		kindDesc = (EditText) findViewById(R.id.kindDesc);
		// ��ȡ�����е�������ť
		bnAdd = (Button) findViewById(R.id.bnAdd);
		bnCancel = (Button) findViewById(R.id.bnCancel);
		// Ϊȡ����ť�ĵ����¼����¼�������
		bnCancel.setOnClickListener(new FinishListener(this));
		bnAdd.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// ����У��
				if (validate())
				{
					// ��ȡ�û����������������������
					String name = kindName.getText().toString();
					String desc = kindDesc.getText().toString();
					try
					{
						// �����Ʒ����
						String result =  addKind(name, desc);
						// ʹ�öԻ�������ʾ��ӽ��
						DialogUtil.showDialog(AddKind.this
							, result , true);
					}
					catch (Exception e)
					{
						DialogUtil.showDialog(AddKind.this
							, "��������Ӧ�쳣�����Ժ����ԣ�" , false);
						e.printStackTrace();
					}
				}
			}
		});
	}

	// ���û�������������ƽ���У��
	private boolean validate()
	{
		String name = kindName.getText().toString().trim();
		if (name.equals(""))
		{
			DialogUtil.showDialog(this , "���������Ǳ����" , false);
			return false;
		}
		return true;
	}

	private String addKind(String name, String desc)
		throws Exception
	{
		// ʹ��Map��װ�������
		Map<String , String> map = new HashMap<String, String>();
		map.put("kindName" , name);
		map.put("kindDesc" , desc);
		// ���巢�������URL
		String url = HttpUtil.BASE_URL + "addKind.jsp";
		// ��������
		return HttpUtil.postRequest(url , map);
	}
}