package org.crazyit.auction.dao.impl;

import java.util.*;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.Hibernate;

import org.crazyit.auction.model.*;
import org.crazyit.auction.business.*;
import org.crazyit.auction.dao.*;

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
public class StateDaoHibernate
	extends HibernateDaoSupport implements StateDao  
{
	/**
	 * ����id����״̬
	 * @param id ��Ҫ���ҵ�״̬id
	 */
	public State get(Integer id)
	{
		return (State)getHibernateTemplate().get(State.class , id);
	}
	/**
	 * ����״̬
	 * @param state ��Ҫ���ӵ�״̬
	 */  
	public void save(State state)
	{
		getHibernateTemplate().save(state);
	}

	/**
	 * �޸�״̬
	 * @param state ��Ҫ�޸ĵ�״̬
	 */
	public void update(State state)
	{
		getHibernateTemplate().saveOrUpdate(state);
	}

	/**
	 * ɾ��״̬
	 * @param id ��Ҫɾ����״̬id
	 */
	public void delete(Integer id)
	{
		getHibernateTemplate().delete(get(id));
	}

	/**
	 * ɾ��״̬
	 * @param state ��Ҫɾ����״̬
	 */
	public void delete(State state)
	{
		getHibernateTemplate().delete(state);
	}

	/**
	 * ��ѯȫ��״̬
	 * @return ���ȫ��״̬
	 */
	public List<State> findAll()
	{
		return (List<State>)getHibernateTemplate().find("from State");
	}
}