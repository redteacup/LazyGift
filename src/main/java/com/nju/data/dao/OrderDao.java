package com.nju.data.dao;

import java.util.List;

import com.nju.data.dataobject.OrderDO;

public interface OrderDao {

	public boolean addOrder(OrderDO orderDO);
	
	public List<OrderDO> getOrderByStaffIdandState(long staffId, int[] states);

	public void save(OrderDO order);
}
