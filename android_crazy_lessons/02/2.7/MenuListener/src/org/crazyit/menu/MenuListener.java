package org.crazyit.menu;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.Toast;

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
public class MenuListener extends Activity
{
	private EditText edit;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		edit = (EditText) findViewById(R.id.txt);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// -------------��menu����������С���Ӳ˵�-------------
		SubMenu fontMenu = menu.addSubMenu("�����С");
		// ���ò˵���ͼ��
		fontMenu.setIcon(R.drawable.font);
		// ���ò˵�ͷ��ͼ��
		fontMenu.setHeaderIcon(R.drawable.font);
		// ���ò˵�ͷ�ı���
		fontMenu.setHeaderTitle("ѡ�������С");		
		MenuItem font10 = fontMenu.add("10������");
		MenuItem font12 = fontMenu.add("12������");
		MenuItem font14 = fontMenu.add("14������");
		MenuItem font16 = fontMenu.add("16������");
		MenuItem font18 = fontMenu.add("18������");
		//����Ϊÿ���˵���󶨼�����
		font10.setOnMenuItemClickListener(new OnMenuItemClickListener()
		{
			@Override
			public boolean onMenuItemClick(MenuItem item)
			{
				edit.setTextSize(10 * 2);
				return false;
			}
		});
		font12.setOnMenuItemClickListener(new OnMenuItemClickListener()
		{
			@Override
			public boolean onMenuItemClick(MenuItem item)
			{
				edit.setTextSize(12 * 2);
				return false;
			}
		});
		font14.setOnMenuItemClickListener(new OnMenuItemClickListener()
		{
			@Override
			public boolean onMenuItemClick(MenuItem item)
			{
				edit.setTextSize(14 * 2);
				return false;
			}
		});
		font16.setOnMenuItemClickListener(new OnMenuItemClickListener()
		{
			@Override
			public boolean onMenuItemClick(MenuItem item)
			{
				edit.setTextSize(16 * 2);
				return false;
			}
		});
		font18.setOnMenuItemClickListener(new OnMenuItemClickListener()
		{
			@Override
			public boolean onMenuItemClick(MenuItem item)
			{
				edit.setTextSize(18 * 2);
				return false;
			}
		});	
		// -------------��menu�������ͨ�˵���-------------
		MenuItem plain = menu.add("��ͨ�˵���");
		plain.setOnMenuItemClickListener(new OnMenuItemClickListener()
		{
			@Override
			public boolean onMenuItemClick(MenuItem item)
			{
				Toast toast = Toast.makeText(MenuListener.this
					, "��������ͨ�˵���", Toast.LENGTH_SHORT);
				toast.show();
				return false;
			}
		});	
		// -------------��menu�����������ɫ���Ӳ˵�-------------
		SubMenu colorMenu = menu.addSubMenu("������ɫ");
		colorMenu.setIcon(R.drawable.color);
		// ���ò˵�ͷ��ͼ��
		colorMenu.setHeaderIcon(R.drawable.color);
		// ���ò˵�ͷ�ı���
		colorMenu.setHeaderTitle("ѡ��������ɫ");	
		MenuItem redItem = colorMenu.add("��ɫ");
		MenuItem greenItem = colorMenu.add("��ɫ");
		MenuItem blueItem = colorMenu.add("��ɫ");
		//����Ϊÿ���˵���Ŀ�󶨼�����
		redItem.setOnMenuItemClickListener(new OnMenuItemClickListener()
		{
			@Override
			public boolean onMenuItemClick(MenuItem item)
			{
				edit.setTextColor(Color.RED);
				return false;
			}
		});	
		greenItem.setOnMenuItemClickListener(new OnMenuItemClickListener()
		{
			@Override
			public boolean onMenuItemClick(MenuItem item)
			{
				edit.setTextColor(Color.GREEN);
				return false;
			}
		});	
		blueItem.setOnMenuItemClickListener(new OnMenuItemClickListener()
		{
			@Override
			public boolean onMenuItemClick(MenuItem item)
			{
				edit.setTextColor(Color.BLUE);
				return false;
			}
		});		
		return super.onCreateOptionsMenu(menu);
	}
}