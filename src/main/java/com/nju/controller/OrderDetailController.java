package com.nju.controller;

import java.io.DataOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nju.service.OrderManagerService;
import com.nju.service.impl.OrderManagerServiceImpl;


@Controller
public class OrderDetailController {
		
	@Autowired
	private OrderManagerService orderService;		
	@RequestMapping(value = "/orderDetail",method = RequestMethod.POST)
	public void getOrder(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws IOException {		
		String order_id = request.getParameter("order_id");		
		String str = orderService.findOrder(Integer.valueOf(order_id));		
		DataOutputStream output=new DataOutputStream(response.getOutputStream());
		output.writeUTF(str);		
		output.close();
	}
		
}
