package com.nju.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
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
	
	@Override
	public String findOrder(int orderId) {		
		OrderDO orderDo = orderDao.findOrderById(orderId);
		Gson gson = new Gson();
		String str = gson.toJson(orderDo);
		return str;		
	}

}
