package org.crazyit.auction.client;

import org.crazyit.auction.client.util.DialogUtil;
import org.crazyit.auction.client.util.HttpUtil;
import org.json.JSONArray;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

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
public class ChooseKind extends Activity
{
	Button bnHome;
	ListView kindList;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.choose_kind);
		bnHome = (Button) findViewById(R.id.bn_home);
		kindList = (ListView) findViewById(R.id.kindList);
		// Ϊ���ذ�ť�ĵ����¼����¼�������
		bnHome.setOnClickListener(new FinishListener(this));
		// ���巢�������URL
		String url = HttpUtil.BASE_URL + "viewKind.jsp";
		try
		{
			// ��ָ��URL�������󣬲�����������Ӧ��װ��JSONArray����
			JSONArray jsonArray = new JSONArray(
				HttpUtil.getRequest(url));
			// ʹ��ListView��ʾ������Ʒ׼����
			kindList.setAdapter(new KindArrayAdapter(jsonArray
				, ChooseKind.this));	
		}
		catch (Exception e)
		{
			DialogUtil.showDialog(this , "��������Ӧ�쳣�����Ժ����ԣ�" , false);
			e.printStackTrace();
		}
		kindList.setOnItemClickListener(new OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
				int position, long id)
			{
				// ����ChooseItem Activity��
				Intent intent = new Intent(ChooseKind.this
					, ChooseItem.class);
				// ������ID��Ϊ�����������ȥ
				intent.putExtra("kindId" , id);
				startActivity(intent);
			}
		});
	}
}