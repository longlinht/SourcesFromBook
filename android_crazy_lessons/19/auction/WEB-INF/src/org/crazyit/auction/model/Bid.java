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
public class Bid
{
	//��ʶ����
	private Integer id;
	//���۵ļ۸�
	private double bidPrice;
	//���۵�����
	private Date bidDate;
	//���ξ��������ĵ���Ʒ
	private Item bidItem;
	//���뾺�۵��û�
	private AuctionUser bidUser;


	//�޲����Ĺ�����
	public Bid()
	{
	}
	//��ʼ��ȫ���������ԵĹ�����
	public Bid(Integer id , double bidPrice , Date bidDate)
	{
		this.id = id;
		this.bidPrice = bidPrice;
		this.bidDate = bidDate;
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

	//bidPrice���Ե�setter��getter����
	public void setBidPrice(double bidPrice)
	{
		this.bidPrice = bidPrice;
	}
	public double getBidPrice()
	{
		return this.bidPrice;
	}

	//bidDate���Ե�setter��getter����
	public void setBidDate(Date bidDate)
	{
		this.bidDate = bidDate;
	}
	public Date getBidDate()
	{
		return this.bidDate;
	}

	//bidItem���Ե�setter��getter����
	public void setBidItem(Item bidItem)
	{
		this.bidItem = bidItem;
	}
	public Item getBidItem()
	{
		return this.bidItem;
	}

	//bidUser���Ե�setter��getter����
	public void setBidUser(AuctionUser bidUser)
	{
		this.bidUser = bidUser;
	}
	public AuctionUser getBidUser()
	{
		return this.bidUser;
	}

	public int hashCode()
	{
		return bidUser.getUsername().hashCode()
			+ bidItem.hashCode() * 13 + (int)bidPrice * 19;
	}

	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj != null && obj.getClass() == Bid.class)
		{
			Bid bid = (Bid)obj;
			if (bid.getBidUser().getUsername().equals(bidUser.getUsername())
				&& bid.getBidItem().equals(this.getBidItem()) 
				&& bid.getBidPrice() == this.getBidPrice())
			{
				return true;
			}
		}
		return false;
	}
}