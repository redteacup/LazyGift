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
	public void confirmOrderSubmit(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
//		long id, int level, long parentId, String name, String pos, String remark,int num
		GoodsDO goods = new GoodsDO();
		goods.setLevel(1);
		goods.setParentId(0);
		goods.setName("ABC");
		goods.setPos("好又多");
		goods.setRemark("货物Goods,root，无父类");
		goods.setNum(12);
		goodsService.saveGoods(goods);
		ResponseBuilder rb = new ResponseBuilder();
		long userId = 0 ;
		String totalPrice = request.getParameter("totalPrice");
 		double total_price = Double.parseDouble((totalPrice==null||totalPrice=="")?"12":totalPrice);
//		double total_price = 12;
 		String deliveryTimeStr = request.getParameter("deliveryTime");
 		System.out.println("货物需要送达时间为："+deliveryTimeStr);
 		Timestamp deliveryTime = DateUtil.getTime(deliveryTimeStr);//"2015-06-01 15:50"
		String orderDestiantion = request.getParameter("destination");
		String orderGoodsName = request.getParameter("goodsName");
		System.out.println("需要购买的货物名称为："+orderGoodsName);
		GoodsDO orderGoods = goodsService.getGoodsByName(orderGoodsName);
		long goods_id = orderGoods.getId();
//		long goods_id = 1;
		int state = 1;//代表订单生成
		Timestamp orderStartTime = new Timestamp(new Date().getTime());
		String remark = request.getParameter("remarks");
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
