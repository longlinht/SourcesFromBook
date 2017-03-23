package org.crazyit.spinner;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
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
public class SpinnerTest2 extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		BaseAdapter ba = new BaseAdapter()
		{
			@Override
			public int getCount()
			{
				//ָ��һ������10��ѡ��
				return 10;
			}

			@Override
			public Object getItem(int position)
			{
				return null;
			}

			@Override
			public long getItemId(int position)
			{
				// TODO Auto-generated method stub
				return 0;
			}
//			//��д�÷������÷������ص�View����Ϊ�б���ÿ��
//			@Override
//			public View getView(int position, View convertView, ViewGroup parent) 
//			{
//				TextView text = new TextView(SpinnerTest2.this);
//				text.setText(position"");
//				text.setTextSize(20);
//				text.setTextColor(R.color.red);
//				return text;
//			}
			//��д�÷������÷������ص�View����Ϊ�б���ÿ��
			@Override
			public View getView(int position, View convertView, ViewGroup parent) 
			{
				//����һ��LinearLayout�������������2�����
				LinearLayout line = new LinearLayout(SpinnerTest2.this);
				line.setOrientation(0);
				ImageView image = new ImageView(SpinnerTest2.this);
				image.setImageResource(R.drawable.icon);
				TextView text = new TextView(SpinnerTest2.this);
				text.setText(position + "");
				text.setTextSize(20);
				text.setTextColor(R.color.red);
				line.addView(image);
				line.addView(text);
				//����LinearLayoutʵ��
				return line;
			}		
		};
		Spinner spinner = (Spinner)findViewById(R.id.test);
		spinner.setAdapter(ba);
	}
}