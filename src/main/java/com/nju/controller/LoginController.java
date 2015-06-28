package com.nju.controller;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nju.data.dataobject.UserDO;
import com.nju.service.UserService;
import com.nju.util.ResponseBuilder;
/**
 * 用户登录Controller
 * @author Wangy
 *
 */
@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login",method = RequestMethod.GET) 
	public void teamLogin(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		ResponseBuilder rb = new ResponseBuilder();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		boolean isSuccess = this.userService.login(username, password);
		
		
		try {
			rb.writeJsonResponse(response, isSuccess);//第二位参数不能为字符串
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
	}
}
