package com.nju.data.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.nju.data.dao.OrderDao;
import com.nju.data.dataobject.OrderDO;

public class OrderDaoImpl extends HibernateDaoSupport implements OrderDao{

	protected static Logger log = LoggerFactory.getLogger(OrderDao.class);
	
	@Override
	public boolean addOrder(OrderDO orderDO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<OrderDO> getOrderByStaffIdandState(long staffId, int[] states) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(OrderDO order) {
		log.debug("saving Order instance");
		try {
			getHibernateTemplate().save(order);
			log.debug("save successful");
 		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

}
