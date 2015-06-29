package com.nju.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nju.model.Order;
import com.nju.service.OrderManagerService;
import com.nju.util.ResponseBuilder;
import com.nju.util.data.Position;

@Controller
public class OrderManagerController {
	
	@Autowired
	private OrderManagerService orderManagerService;
	
//	private List<Order> list = null;
	
	@RequestMapping(value = "/getorderlist",method = RequestMethod.GET)
	public void getOrderList(HttpServletRequest request, HttpServletResponse response, ModelMap model){		
		ResponseBuilder rb = new ResponseBuilder();
		
		long staffId = -1;
		
		List<Order> re = orderManagerService.getUntreatedOrder(staffId);
		
		try {
			rb.writeJsonResponse(response, re);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/buyorder",method = RequestMethod.GET)
	public void buyOrder(HttpServletRequest request, HttpServletResponse response, ModelMap model){		
		ResponseBuilder rb = new ResponseBuilder();
		
		boolean re = true;
		
		String id = request.getParameter("id");
		
		int i = Integer.parseInt(id);
		orderManagerService.purchaseGoods(i, new Position());
		
		try {
			rb.writeJsonResponse(response, re);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
/*	private void intialize(){
		list = new ArrayList<Order>();
		
		list.add(new Order(1,"����",5.0,"6.1 15:24","������"));
		list.add(new Order(2,"С��ܸɴ���",3.0,"6.1 15:32","������"));
		list.add(new Order(3,"ѩ��",6.0,"6.1 15:34","������"));
		list.add(new Order(4,"ɳ��С�� ±�ⷹ",16.0,"6.1 15:35","������"));
		list.add(new Order(5,"5�ŵ��",6.0, "9:26","������"));
	}*/
}
