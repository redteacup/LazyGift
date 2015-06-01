package com.nju.data.dataobject;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order_record")
public class OrderRecordDO {
	
	private long id;
	private long orderId;
	private String action;
	private String remark;
	private String pos;
	private Timestamp createTime;
	

	
	public OrderRecordDO() {
		super();
	}
	
	public OrderRecordDO(long id, long orderId, String action, String remark,String pos,
			Timestamp createTime) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.action = action;
		this.remark = remark;
		this.pos = pos;
		this.createTime = createTime;
	}

	@Id 
	@Column(name="id", unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
 
	@Column(name="order_id")
	public long getOrderId() {
		return orderId;
	}

	@Column(name="action", length=20)
	public String getAction() {
		return action;
	}

	@Column(name="remark", length=200)
	public String getRemark() {
		return remark;
	}

	@Column(name="pos",length = 100)
	public String getPos() {
		return pos;
	}
	
	@Column(name="create_time")
	public Date getCreateTime() {
		return createTime;
	}


	public void setId(long id) {
		this.id = id;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}


}
