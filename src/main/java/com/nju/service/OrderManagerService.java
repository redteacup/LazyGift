package com.nju.service;

import java.util.List;

import com.nju.data.dataobject.OrderDO;
import com.nju.model.Order;
import com.nju.util.data.Position;

public interface OrderManagerService {

	/**
	 * 根据工作人员id和订单状态获得属于该员工特定状态的订单
	 * @param staffId
	 * @param states
	 * @return
	 */
	public List<Order> getOrdersByStaffId(long staffId, int[] states);
	
	/**
	 * 购买商品操作
	 * @param orderId
	 * @param pos
	 * @return
	 */
	public boolean BuyGoods(long orderId, Position pos);

	public boolean saveOrder(OrderDO order);
}
