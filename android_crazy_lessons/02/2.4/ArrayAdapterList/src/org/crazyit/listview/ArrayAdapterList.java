package org.crazyit.listview;

import org.crazyit.listview.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
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
public class ArrayAdapterList extends Activity
{ 
	@Override   
	protected void onCreate(Bundle savedInstanceState)
	{   
		super.onCreate(savedInstanceState);   
		setContentView(R.layout.main);   
		ListView list2 = (ListView)findViewById(R.id.list2);
		//����һ������
		String[] arr ={"�����" , "��˽�" , "ţħ��"};
		//�������װArrayAdapter
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
			this , android.R.layout.simple_list_item_1 , arr);
		//ΪListView����Adapter
		list2.setAdapter(arrayAdapter);	
	}  
}