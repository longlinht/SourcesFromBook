package org.crazyit.tabhost;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

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
public class TabHostTest extends TabActivity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		TabHost tabHost = getTabHost();
		//����ʹ��TabHost����
		LayoutInflater.from(this).inflate(R.layout.main,
				tabHost.getTabContentView(), true);
		//��ӵ�һ����ǩҳ
		tabHost.addTab(tabHost.newTabSpec("tab1")
			.setIndicator("�ѽӵ绰")
			.setContent(R.id.tab01)); 
		//��ӵڶ�����ǩҳ
		tabHost.addTab(tabHost.newTabSpec("tab2")
			//�ڱ�ǩ�����Ϸ���ͼ��
			.setIndicator("�����绰" 
				, getResources().getDrawable(R.drawable.icon))
			.setContent(R.id.tab02)); 
		//��ӵ�������ǩҳ
		tabHost.addTab(tabHost.newTabSpec("tab3")
			.setIndicator("δ�ӵ绰")
			.setContent(R.id.tab03)); 		
	}
}