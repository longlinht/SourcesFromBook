package org.crazyit.auction.dao;

import java.util.List;

import org.crazyit.auction.model.*;
import org.crazyit.auction.business.*;
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
public interface StateDao  
{
	/**
	 * ����id����״̬
	 * @param id ��Ҫ���ҵ�״̬id
	 */ 
	State get(Integer id);

	/**
	 * ����״̬
	 * @param state ��Ҫ���ӵ�״̬
	 */      
	void save(State state);

	/**
	 * �޸�״̬
	 * @param state ��Ҫ�޸ĵ�״̬
	 */
	void update(State state);

	/**
	 * ɾ��״̬
	 * @param id ��Ҫɾ����״̬id
	 */ 
	void delete(Integer id);

	/**
	 * ɾ��״̬
	 * @param state ��Ҫɾ����״̬
	 */
	void delete(State state);

	/**
	 * ��ѯȫ��״̬
	 * @return ���ȫ��״̬
	 */ 
	List<State> findAll();
}
