package com.nju.service;

import java.util.List;

import com.nju.data.dataobject.OrderDO;
import com.nju.model.Order;
import com.nju.util.data.Position;

public interface OrderManagerService {

	/**
	 * ���ݹ�����Աid���δ������
	 * @param staffId
	 * @return
	 */
	public List<Order> getUntreatedOrder(long staffId);
	
	/**
	 * ������Ʒ����
	 * @param orderId
	 * @param pos
	 * @return
	 */
	public boolean purchaseGoods(long orderId, Position pos);

	public boolean saveOrder(OrderDO order);
	
	public String findOrder(int OrderId);
}
