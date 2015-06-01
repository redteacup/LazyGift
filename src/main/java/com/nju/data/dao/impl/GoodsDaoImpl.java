package com.nju.data.dao.impl;

import java.util.List;

import com.nju.data.dao.GoodsDao;
import com.nju.data.dataobject.GoodsDO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public class GoodsDaoImpl extends HibernateDaoSupport implements GoodsDao{

	@Override
	public List<String> getGoodsList() {
		
		String sql = "from Goods";
		Session se = this.currentSession();
		Query qu = se.createQuery(sql);
		List<GoodsDO> list = (List<GoodsDO>)qu.list();
		List<String> namelist = null;
		for(GoodsDO g:list){
			namelist.add(g.getName());
		}
		return namelist;
	}

	@SuppressWarnings("unchecked")
	@Override
	public GoodsDO findGoodsByGoodsName(String goodsName) {
		// TODO Auto-generated method stub
		String sql = "from GoodsDO where name = '"+goodsName+"'";
		Session se = this.currentSession();
		Query qu = se.createQuery(sql);
 		List<GoodsDO> list = qu.list();
		return list.get(0);
	}

}
