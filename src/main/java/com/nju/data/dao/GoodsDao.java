package com.nju.data.dao;

 import java.util.List;

import com.nju.data.dataobject.GoodsDO;
import com.nju.model.Good;

public interface GoodsDao {
	List<Good> getGoodsList();

	GoodsDO findGoodsByGoodsName(String orderGoodsName);

	List<GoodsDO> getGoodsBySearchName(String goodsName);

	void save(GoodsDO goods);

}
