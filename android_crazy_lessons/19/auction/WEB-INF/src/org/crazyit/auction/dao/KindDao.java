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
public interface KindDao  
{
	/**
	 * ����id��������
	 * @param id ��Ҫ���ҵ������id
	 */
	Kind get(Integer id);

	/**
	 * ��������
	 * @param kind ��Ҫ���ӵ�����
	 */
	void save(Kind kind);

	/**
	 * �޸�����
	 * @param kind ��Ҫ�޸ĵ�����
	 */
	void update(Kind kind);

	/**
	 * ɾ������
	 * @param id ��Ҫɾ��������id
	 */
	void delete(Integer id);

	/**
	 * ɾ������
	 * @param kind ��Ҫɾ��������
	 */
	void delete(Kind kind);

	/**
	 * ��ѯȫ������
	 * @return ���ȫ������
	 */
	List<Kind> findAll();
}
