package org.crazyit.autocomplete;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

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
public class AutoCompleteTextViewTest extends Activity
{
	//�����ַ������飬��Ϊ��ʾ���ı�
	String[] books = new String[]{
		"���Java����",
		"���Ajax����",
		"���XML����",
		"���Workflow����"
	};
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//����һ��ArrayAdapter����װ����
		ArrayAdapter<String> aa = new ArrayAdapter<String>(
			this,
			android.R.layout.simple_dropdown_item_1line,
			books);
		AutoCompleteTextView actv = (AutoCompleteTextView)
			findViewById(R.id.auto);
		//����Adapter
		actv.setAdapter(aa);
		
	}
}