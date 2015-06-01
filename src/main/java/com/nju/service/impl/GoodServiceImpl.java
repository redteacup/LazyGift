package com.nju.service.impl;

import java.util.List;

import com.nju.service.GoodService;
import com.nju.data.dao.GoodsDao;
import com.nju.data.dataobject.GoodsDO;

public class GoodServiceImpl implements GoodService{

	private GoodsDao goodsDao;

	@Override
	public List<String> matchName(String name) {
		List<String> namelist = goodsDao.getGoodsList();
		List<String> result = null;
		if(namelist==null){
			return null;
		}
		for(String s:result){
			if(s.indexOf(name)>0){
				result.add(s);
			}
		}
		return result;
	}

	@Override
	public GoodsDO getGoodsByName(String orderGoodsName) {
		// TODO Auto-generated method stub
		return goodsDao.findGoodsByGoodsName(orderGoodsName);
 	}
	
}
