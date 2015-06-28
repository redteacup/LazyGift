package com.nju.service;

import java.util.List;

import com.nju.data.dataobject.GoodsDO;

public interface GoodService {
	
	List<String> matchName(String name);

	GoodsDO getGoodsByName(String orderGoodsName);

	List<GoodsDO> searchGoodsByName(String goodsName);

	void saveGoods(GoodsDO goods);
	
}
