package org.crazyit.auction.model;

import java.util.*;
/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a> 
 * <br/>Copyright (C), 2001-2010, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class State
{
	//��ʶ����
	private Integer id;
	//��Ʒ��״̬��
	private String stateName;
	//��״̬�µ�������Ʒ
	private Set<Item> items = new HashSet<Item>();

	//�޲����Ĺ�����
	public State()
	{
	}
	//��ʼ��ȫ���������ԵĹ�����
	public State(Integer id , String stateName)
	{
		this.id = id;
		this.stateName = stateName;
	}

	//id���Ե�setter��getter����
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getId()
	{
		return this.id;
	}

	//stateName���Ե�setter��getter����
	public void setStateName(String stateName)
	{
		this.stateName = stateName;
	}
	public String getStateName()
	{
		return this.stateName;
	}

	//items���Ե�setter��getter����
	public void setItems(Set<Item> items)
	{
		this.items = items;
	}
	public Set<Item> getItems()
	{
		return this.items;
	}
}