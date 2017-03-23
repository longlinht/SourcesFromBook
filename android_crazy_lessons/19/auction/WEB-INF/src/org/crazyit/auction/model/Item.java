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
public class Item
{
	//��ʶ����
	private Integer id;
	//��ƷRemark
	private String itemRemark;
	//��Ʒ����
	private String itemName;
	//��Ʒ����
	private String itemDesc;
	//��Ʒ���ʱ��
	private Date addtime;
	//��Ʒ��������ʱ��
	private Date endtime;
	//��Ʒ�����ļ�
	private double initPrice;
	//��Ʒ����߼�
	private double maxPrice;
	//����Ʒ��������
	private AuctionUser owner;
	//����Ʒ����������
	private Kind kind;
	//����Ʒ��Ӯȡ��
	private AuctionUser winer;
	//����Ʒ������״̬
	private State itemState;
	//����Ʒ��Ӧ��ȫ�����ۼ�¼
	private Set<Bid> bids = new HashSet<Bid>();

	//�޲����Ĺ�����
	public Item()
	{
	}
	//��ʼ��ȫ���������ԵĹ�����
	public Item(Integer id , String itemRemark , String itemName , 
		String itemDesc , Date addtime , Date endtime , 
		double initPrice , double maxPrice , AuctionUser owner)
	{
		this.id = id;
		this.itemRemark = itemRemark;
		this.itemName = itemName;
		this.itemDesc = itemDesc;
		this.addtime = addtime;
		this.endtime = endtime;
		this.initPrice = initPrice;
		this.maxPrice = maxPrice;
		this.owner = owner;
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

	//itemRemark���Ե�setter��getter����
	public void setItemRemark(String itemRemark)
	{
		this.itemRemark = itemRemark;
	}
	public String getItemRemark()
	{
		return this.itemRemark;
	}

	//itemName���Ե�setter��getter����
	public void setItemName(String itemName)
	{
		this.itemName = itemName;
	}
	public String getItemName()
	{
		return this.itemName;
	}

	//itemDesc���Ե�setter��getter����
	public void setItemDesc(String itemDesc)
	{
		this.itemDesc = itemDesc;
	}
	public String getItemDesc()
	{
		return this.itemDesc;
	}

	//addtime���Ե�setter��getter����
	public void setAddtime(Date addtime)
	{
		this.addtime = addtime;
	}
	public Date getAddtime()
	{
		return this.addtime;
	}

	//endtime���Ե�setter��getter����
	public void setEndtime(Date endtime)
	{
		this.endtime = endtime;
	}
	public Date getEndtime()
	{
		return this.endtime;
	}

	//initPrice���Ե�setter��getter����
	public void setInitPrice(double initPrice)
	{
		this.initPrice = initPrice;
	}
	public double getInitPrice()
	{
		return this.initPrice;
	}

	//maxPrice���Ե�setter��getter����
	public void setMaxPrice(double maxPrice)
	{
		this.maxPrice = maxPrice;
	}
	public double getMaxPrice()
	{
		return this.maxPrice;
	}

	//owner���Ե�setter��getter����
	public void setOwner(AuctionUser owner)
	{
		this.owner = owner;
	}
	public AuctionUser getOwner()
	{
		return this.owner;
	}

	//kind���Ե�setter��getter����
	public void setKind(Kind kind)
	{
		this.kind = kind;
	}
	public Kind getKind()
	{
		return this.kind;
	}

	//winer���Ե�setter��getter����
	public void setWiner(AuctionUser winer)
	{
		this.winer = winer;
	}
	public AuctionUser getWiner()
	{
		return this.winer;
	}

	//itemState���Ե�setter��getter����
	public void setItemState(State itemState)
	{
		this.itemState = itemState;
	}
	public State getItemState()
	{
		return this.itemState;
	}

	//bids���Ե�setter��getter����
	public void setBids(Set<Bid> bids)
	{
		this.bids = bids;
	}
	public Set<Bid> getBids()
	{
		return this.bids;
	}
}