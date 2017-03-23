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
public interface ItemDao  
{
	/**
	 * ��������������Ʒ
	 * @param itemId ����ҵ���Ʒ��id;
	 * @return id��Ӧ����Ʒ
	 */
	Item get(Integer itemId);

	/**
	 * ������Ʒ
	 * @param item ��Ҫ�������Ʒ
	 */
	void save(Item item);

	/**
	 * �޸���Ʒ
	 * @param item ��Ҫ�޸ĵ���Ʒ
	 */
	void update(Item item);

	/**
	 * ɾ����Ʒ
	 * @param id ��Ҫɾ������Ʒid
	 */
	void delete(Integer id);

	/**
	 * ɾ����Ʒ
	 * @param item ��Ҫɾ������Ʒ
	 */
	void delete(Item item);

	/**
	 * ���ݲ�Ʒ���࣬��ȡ��ǰ������ȫ����Ʒ
	 * @param kindId ����id;
	 * @return �����ȫ����Ʒ
	 */
	List<Item> findItemByKind(Integer kindId);

	/**
	 * ���������߲��Ҵ��������е���Ʒ
	 * @param useId ������Id;
	 * @return ָ���û����������е�ȫ����Ʒ
	 */
	List<Item> findItemByOwner(Integer userId);

	/**
	 * ����Ӯȡ�߲�����Ʒ
	 * @param userId Ӯȡ��Id;
	 * @return ָ���û�Ӯȡ��ȫ����Ʒ
	 */
	List<Item> findItemByWiner(Integer userId);

	/**
	 * ������Ʒ״̬������Ʒ
	 * @param stateId ״̬Id;
	 * @return ��״̬�µ�ȫ����Ʒ
	 */
	List<Item> findItemByState(Integer stateId);
}