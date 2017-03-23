package org.crazyit.menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
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
public class CheckableMenu extends Activity
{
	// �����Ա�˵���ı�ʶ
	final int MALE = 0x111;
	final int FEMALE = 0x112;
	// ������ɫ�˵���ı�ʶ
	final int RED = 0x113;
	final int GREEN = 0x114;
	final int BLUE = 0x115;
	//����3����ɫ�˵���
	MenuItem[] items = new MenuItem[3];
	String[] colorNames = new String[]{"��ɫ", "��ɫ" , "��ɫ"};
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
		// -------------��menu�����ѡ���Ա���Ӳ˵�-------------
		SubMenu genderMenu = menu.addSubMenu("�����Ա�");
		// ���ò˵���ͼ��
		genderMenu.setIcon(R.drawable.gender);
		// ���ò˵�ͷ��ͼ��
		genderMenu.setHeaderIcon(R.drawable.gender);
		// ���ò˵�ͷ�ı���
		genderMenu.setHeaderTitle("ѡ�������Ա�");	
		genderMenu.add(0, MALE,  0, "����");
		genderMenu.add(0, FEMALE, 0, "Ů��");
		//����genderMenu�˵���0��˵���Ϊ��ѡ�˵���
		genderMenu.setGroupCheckable(0 , true , true);
		// -------------��menu�������ɫ���Ӳ˵�-------------
		SubMenu colorMenu = menu.addSubMenu("ϲ������ɫ");
		colorMenu.setIcon(R.drawable.color);
		// ���ò˵�ͷ��ͼ��
		colorMenu.setHeaderIcon(R.drawable.color);
		// ���ò˵�ͷ�ı���
		colorMenu.setHeaderTitle("ѡ������ϲ������ɫ");
		//��Ӳ˵����������Ϊ�ɹ�ѡ�Ĳ˵���
		items[0] = colorMenu.add(0, RED, 0, colorNames[0])
			.setCheckable(true);
		//��Ӳ˵����������Ϊ�ɹ�ѡ�Ĳ˵���
		items[1] = colorMenu.add(0, BLUE, 0, colorNames[1])
			.setCheckable(true);		
		//��Ӳ˵����������Ϊ�ɹ�ѡ�Ĳ˵���
		items[2] = colorMenu.add(0, GREEN, 0, colorNames[2])
			.setCheckable(true);
		//���ÿ�ݼ�
		items[2].setAlphabeticShortcut('u');
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	// �˵��������Ļص�����
	public boolean onOptionsItemSelected(MenuItem mi)
	{
		//�жϵ��������ĸ��˵��������Ե�������Ӧ��
		switch (mi.getItemId())
		{
			case MALE:
				edit.setText("�����Ա�Ϊ����");
				//����ͨ���������ı乴ѡ״̬
				mi.setChecked(true);
				break;
			case FEMALE:
				edit.setText("�����Ա�Ϊ��Ů");
				//����ͨ���������ı乴ѡ״̬
				mi.setChecked(true);
				break;
			case RED:
				//����ͨ���������ı乴ѡ״̬
				if(mi.isChecked())
				{
					mi.setChecked(false);
				}
				else
				{
					mi.setChecked(true);
				}				
				showColor();
				break;
			case GREEN:
				//����ͨ���������ı乴ѡ״̬
				if(mi.isChecked())
				{
					mi.setChecked(false);
				}
				else
				{
					mi.setChecked(true);
				}
				showColor();
				break;
			case BLUE:
				//����ͨ���������ı乴ѡ״̬
				if(mi.isChecked())
				{
					mi.setChecked(false);
				}
				else
				{
					mi.setChecked(true);
				}
				showColor();
				break;
		}
		return true;
	}
	private void showColor()
	{
		String result = "��ϲ������ɫ�У�";
		for (int i = 0 ; i < items.length ; i++)
		{
			if(items[i].isChecked())
			{
				result += colorNames[i] + "��";
			}
		}
		edit.setText(result);
	}
}
