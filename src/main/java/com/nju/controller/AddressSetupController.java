package com.nju.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nju.service.UserAddressService;
import com.nju.util.ResponseBuilder;

@Controller
public class AddressSetupController {
	@Autowired
	private UserAddressService userAddressService;
	
	@RequestMapping(value = "/MyAddrSet",method = RequestMethod.POST)
	public void addressSave(HttpServletRequest request, HttpServletResponse response, ModelMap model){
		ResponseBuilder rb = new ResponseBuilder();
		
		String username = request.getParameter("ID");
		String street = request.getParameter("STREET");
		String building = request.getParameter("BUILDING");
		String room = request.getParameter("ROOM");
			
		try {
			String street_uft8 = URLDecoder.decode(street, "UTF-8");
			String building_utf8 = URLDecoder.decode(building, "UTF-8");
			//System.out.println(username + ": " + street_uft8 + "," + building_utf8 + "," + room);
			
			userAddressService.setDefaultAddress(username, street_uft8, building_utf8, room);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			rb.writeJsonResponse(response, true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
	}
}
