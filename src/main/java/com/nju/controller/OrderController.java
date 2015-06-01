package com.nju.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nju.data.dataobject.GoodsDO;
import com.nju.data.dataobject.OrderDO;
import com.nju.service.GoodService;
import com.nju.service.OrderManagerService;
import com.nju.util.DateUtil;
import com.nju.util.ResponseBuilder;


@Controller
public class OrderController {
	
	@Autowired
	private OrderManagerService orderService;
	@Autowired
	private GoodService goodsService;
	
	@RequestMapping(value = "/confirmOrderSubmit",method = RequestMethod.POST) 
	public void teamLogin(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		ResponseBuilder rb = new ResponseBuilder();
		long userId = 0 ;
		String totalPrice = request.getParameter("orderPrice");
 		double total_price = Double.parseDouble(totalPrice);
 		Timestamp deliveryTime = DateUtil.getTime("2015-06-01 15:50");
		String orderDestiantion = request.getParameter("orderDestiantion");
		String orderGoodsName = request.getParameter("orderGoodsName");
//		GoodsDO orderGoods = goodsService.getGoodsByName(orderGoodsName);
//		long goods_id = orderGoods.getId();
		long goods_id = 1;
		int state = 1;//代表订单生成
		Timestamp orderStartTime = new Timestamp(new Date().getTime());
		String remark = "备注";
 		OrderDO order = new OrderDO(userId,total_price,deliveryTime,orderDestiantion,goods_id,state,orderStartTime,remark);
         try {
        	System.out.println("保存新的订单到数据库");
        	orderService.saveOrder(order);	
			rb.writeJsonResponse(response, order);//第二位参数不能为字符串
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
