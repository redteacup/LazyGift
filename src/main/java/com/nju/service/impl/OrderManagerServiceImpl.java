package com.nju.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nju.data.dao.GoodsDao;
import com.nju.data.dataobject.OrderDO;
import com.nju.model.Order;
import com.nju.service.OrderManagerService;
import com.nju.util.data.Position;
import com.nju.data.dao.OrderDao;

public class OrderManagerServiceImpl implements OrderManagerService{
	
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private GoodsDao goodsDao;
	@Autowired
	private GoodsDao StaffDao;
	@Autowired
	private GoodsDao OrderDao;
	

	

	@Override
	public boolean BuyGoods(long orderId, Position pos) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Order> getOrdersByStaffId(long staffId, int[] states) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveOrder(OrderDO order) {
		// TODO Auto-generated method stub
		orderDao.save(order);
		return false;
	}

}
