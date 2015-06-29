package com.nju.data.dao;

import java.util.List;

import com.nju.data.dataobject.OrderDO;

public interface OrderDao {

	public boolean addOrder(OrderDO orderDO);
	
	/**
	 * ���ݹ�����Ա��״̬��ö���
	 * @param staffId
	 * @param states
	 * @return
	 */
	public List<OrderDO> getOrderByStaffIdandState(long staffId, int state);
	
	/**
	 * �ı䶩���ű�ʶ������״̬,���ظö�����goodsId
	 * @param orderId
	 * @param state
	 * @return
	 */
	public long changeState(long orderId, int state);

	public void save(OrderDO order);
	
	public OrderDO findOrderById(int orderId);
}
