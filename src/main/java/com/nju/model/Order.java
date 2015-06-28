package com.nju.model;

public class Order {

	private long id;
	private String context;
	private Double price;
	private String createTime;
	private String state;
	
	public Order(long id, String context, Double price, String createTime,
			String state) {
		super();
		this.id = id;
		this.context = context;
		this.price = price;
		this.createTime = createTime;
		this.state = state;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}

}
