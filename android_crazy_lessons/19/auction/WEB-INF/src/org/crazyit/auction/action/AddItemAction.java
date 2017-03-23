package org.crazyit.auction.action;

import java.util.*;
import com.opensymphony.xwork2.ActionContext;

import org.crazyit.auction.service.AuctionManager;
import org.crazyit.auction.exception.AuctionException;
import org.crazyit.auction.action.base.BaseAction;

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
public class AddItemAction extends BaseAction
{
	private String name;
	private String desc;
	private String remark;
	private double initPrice;
	private int avail;
	private int kind;
	private String vercode;
	//�����û������execute����
	public String execute() throws Exception
	{
		Map session = ActionContext.getContext().getSession();
		String ver2 = (String)session.get("rand");
		//ǿ��ϵͳ�����ɵ������֤��ʧЧ
		session.put("rand" , null);
		Integer userId = (Integer)session.get("userId");
		//����û��������֤����ϵͳ�����������֤����ͬ
		if (vercode.equalsIgnoreCase(ver2))
		{
			//�����û�ѡ����Чʱ��ѡ�ָ��ʵ�ʵ���Чʱ��
			switch(avail)
			{
				case 6 :
					avail = 7;
					break;
				case 7 :
					avail = 30;
					break;
				case 8 :
					avail = 365;
					break;
			}
			//�����Ʒ
			mgr.addItem(name , desc , remark , initPrice ,avail , kind, userId);
			//���ռ��û�������Ϣ�ı������
			return SUCCESS;
		}
		else
		{
			addActionError("��֤�벻ƥ��,����������");
			return INPUT;
		}
	}

	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		 return this.name;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
	}
	public String getDesc()
	{
		 return this.desc;
	}

	public void setRemark(String remark)
	{
		this.remark = remark;
	}
	public String getRemark()
	{
		 return this.remark;
	}

	public void setInitPrice(double initPrice)
	{
		this.initPrice = initPrice;
	}
	public double getInitPrice()
	{
		 return this.initPrice;
	}

	public void setAvail(int avail)
	{
		this.avail = avail;
	}
	public int getAvail()
	{
		 return this.avail;
	}

	public void setKind(int kind)
	{
		this.kind = kind;
	}
	public int getKind()
	{
		 return this.kind;
	}

	public void setVercode(String vercode)
	{
		this.vercode = vercode;
	}
	public String getVercode()
	{
		 return this.vercode;
	}
}