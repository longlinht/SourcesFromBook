package org.crazyit.auction.client;


import org.crazyit.auction.client.util.DialogUtil;
import org.crazyit.auction.client.util.HttpUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

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
public class ManageItem extends Activity
{
	Button bnHome, bnAdd;
	ListView itemList;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.manage_item);
		bnHome = (Button) findViewById(R.id.bn_home);
		bnAdd = (Button) findViewById(R.id.bnAdd);
		itemList = (ListView) findViewById(R.id.itemList);
		// Ϊ���ذ�ť�ĵ����¼����¼�������
		bnHome.setOnClickListener(new FinishListener(this));
		bnAdd.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View source)
			{
				// ����AddItem Activity��
				Intent intent = new Intent(ManageItem.this, AddItem.class);
				startActivity(intent);
			}
		});
		// ���巢�������URL
		String url = HttpUtil.BASE_URL + "viewOwnerItem.jsp";
		try
		{
			// ��ָ��URL��������
			JSONArray jsonArray = new JSONArray(HttpUtil.getRequest(url));
			// ����������Ӧ��װ��Adapter
			JSONArrayAdapter adapter = new JSONArrayAdapter(this, jsonArray,
				"name", true);
			itemList.setAdapter(adapter);
		}
		catch (Exception e)
		{
			DialogUtil.showDialog(this, "��������Ӧ�쳣�����Ժ����ԣ�", false);
			e.printStackTrace();
		}
		itemList.setOnItemClickListener(new OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
				int position, long id)
			{
				viewItemInBid(position);
			}
		});
	}

	private void viewItemInBid(int position)
	{
		// ����detail_in_bid.xml���沼�ִ������ͼ
		View detailView = getLayoutInflater().inflate(R.layout.detail_in_bid,
			null);
		// ��ȡdetail_in_bid.xml�����е��ı���
		EditText itemName = (EditText) detailView.findViewById(R.id.itemName);
		EditText itemKind = (EditText) detailView.findViewById(R.id.itemKind);
		EditText maxPrice = (EditText) detailView.findViewById(R.id.maxPrice);
		EditText initPrice = (EditText) detailView.findViewById(R.id.initPrice);
		EditText endTime = (EditText) detailView.findViewById(R.id.endTime);
		EditText itemRemark = (EditText) detailView
			.findViewById(R.id.itemRemark);
		// ��ȡ�������б�������װ��JSONObject
		JSONObject jsonObj = (JSONObject) itemList.getAdapter().getItem(
			position);
		try
		{
			// ͨ���ı�����ʾ��Ʒ����
			itemName.setText(jsonObj.getString("name"));
			itemKind.setText(jsonObj.getString("kind"));
			maxPrice.setText(jsonObj.getString("maxPrice"));
			itemRemark.setText(jsonObj.getString("desc"));
			initPrice.setText(jsonObj.getString("initPrice"));
			endTime.setText(jsonObj.getString("endTime"));
		}
		catch (JSONException e)
		{
			e.printStackTrace();
		}
		DialogUtil.showDialog(ManageItem.this, detailView);
	}
}