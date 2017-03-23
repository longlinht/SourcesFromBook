package org.crazyit.auction.client;

import org.crazyit.auction.client.util.DialogUtil;
import org.crazyit.auction.client.util.HttpUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
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
public class ViewItem extends Activity
{
	Button bnHome;
	ListView succList;
	TextView viewTitle;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_item);
		// ��ȡ�����ϵķ��ذ�ť
		bnHome = (Button) findViewById(R.id.bn_home);
		succList = (ListView) findViewById(R.id.succList);
		viewTitle = (TextView) findViewById(R.id.view_titile);
		// Ϊ���ذ�ť�ĵ����¼����¼�������
		bnHome.setOnClickListener(new FinishListener(this));
		String action = getIntent().getStringExtra("action");
		// ���巢�������URL
		String url = HttpUtil.BASE_URL + action;
		// ����ǲ鿴������Ʒ���޸ı���
		if (action.equals("viewFail.jsp"))
		{
			viewTitle.setText(R.string.view_fail);
		}
		try
		{
			// ��ָ��URL�������󣬲��ѷ�������Ӧת����JSONArray����
			JSONArray jsonArray = new JSONArray(HttpUtil.getRequest(url));
			// ��JSONArray��װ��Adapter
			JSONArrayAdapter adapter = new JSONArrayAdapter(this
				, jsonArray, "name", true);
			succList.setAdapter(adapter);
		}
		catch (Exception e)
		{
			DialogUtil.showDialog(this, "��������Ӧ�쳣�����Ժ����ԣ�", false);
			e.printStackTrace();
		}
		succList.setOnItemClickListener(new OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
				int position, long id)
			{
				// �鿴ָ����Ʒ����ϸ�����
				viewItemDetail(position);
			}
		});
	}

	private void viewItemDetail(int position)
	{
		// ����detail.xml���沼�ִ������ͼ
		View detailView = getLayoutInflater().inflate(R.layout.detail, null);
		// ��ȡdetail.xml���沼���е��ı���
		EditText itemName = (EditText) detailView
			.findViewById(R.id.itemName);
		EditText itemKind = (EditText) detailView
			.findViewById(R.id.itemKind);
		EditText maxPrice = (EditText) detailView
			.findViewById(R.id.maxPrice);
		EditText itemRemark = (EditText) detailView
			.findViewById(R.id.itemRemark);
		// ��ȡ���������б���
		JSONObject jsonObj = (JSONObject) succList.getAdapter().getItem(
			position);
		try
		{
			// ͨ���ı�����ʾ��Ʒ����
			itemName.setText(jsonObj.getString("name"));
			itemKind.setText(jsonObj.getString("kind"));
			maxPrice.setText(jsonObj.getString("maxPrice"));
			itemRemark.setText(jsonObj.getString("desc"));
		}
		catch (JSONException e)
		{
			e.printStackTrace();
		}
		DialogUtil.showDialog(ViewItem.this, detailView);
	}
}