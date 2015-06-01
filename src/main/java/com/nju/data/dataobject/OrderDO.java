package com.nju.data.dataobject;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lazy_order")
public class OrderDO {
	
	private long id;
	private long staffId;
	private int state;
	
	//Weih add attribute
	private long goodsId;
	private Timestamp createTime;
	private Timestamp deliveryTime;
	private double totalPrice;
	private long userId;
	private String des;
	private String remark;
	public OrderDO() {

	}
	
	public OrderDO(long staffId, int state) {
		super();
		this.staffId = staffId;
		this.state = state;
	}
	
	public OrderDO(long userId,double totalPrice,Timestamp deliveryTime,
			String orderDestiantion,long orderGoodsId,int orderState,Timestamp orderStartTime,String remark){
		super();
		this.userId = userId;
		this.goodsId = orderGoodsId;
		this.totalPrice = totalPrice;
		this.deliveryTime = deliveryTime;
		this.des = orderDestiantion;
		this.state = orderState;
 		this.createTime = orderStartTime;
 		this.remark = remark;
	}

	@Id 
	@Column(name="id", unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	@Column(name="staff_id")
	public long getStaffId() {
		return staffId;
	}
	
	@Column(name="state")
	public int getState() {
		return state;
	}
	@Column(name="goods_id")
	public long getGoodsId() {
		return goodsId;
	}

    @Column(name="create_time")
	public Timestamp getCreateTime() {
		return createTime;
	}
	
	@Column(name="delivery_time")
	public Timestamp getDeliveryTime() {
		return deliveryTime;
	}
	
    @Column(name="total_price",length = 11)
	public double getTotalPrice() {
		return totalPrice;
	}
	

    @Column(name="user_id")
	public long getUserId() {
		return userId;
	}

    @Column(name="destination")
	public String getDes() {
		return des;
	}

    @Column(name="remark")
	public String getRemark() {
		return remark;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public void setStaffId(long staffId) {
		this.staffId = staffId;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	public void setGoodsId(long goodsId) {
		this.goodsId = goodsId;
	}

	public void setDeliveryTime(Timestamp deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


}
