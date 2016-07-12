package com.fix.model;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */

public class Order implements java.io.Serializable {

	// Fields

	private String orderid;
	private String orderstate;
	private String orderrepairer;
	private String orderrepairphone;
	private String faultid;
	private String orderfrom;
	private String faultphone;
	private String faultname;

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** full constructor */
	public Order(String orderstate, String orderrepairer,
			String orderrepairphone, String faultid, String orderfrom,
			String faultphone, String faultname) {
		this.orderstate = orderstate;
		this.orderrepairer = orderrepairer;
		this.orderrepairphone = orderrepairphone;
		this.faultid = faultid;
		this.orderfrom = orderfrom;
		this.faultphone = faultphone;
		this.faultname = faultname;
	}

	// Property accessors

	public String getOrderid() {
		return this.orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getOrderstate() {
		return this.orderstate;
	}

	public void setOrderstate(String orderstate) {
		this.orderstate = orderstate;
	}

	public String getOrderrepairer() {
		return this.orderrepairer;
	}

	public void setOrderrepairer(String orderrepairer) {
		this.orderrepairer = orderrepairer;
	}

	public String getOrderrepairphone() {
		return this.orderrepairphone;
	}

	public void setOrderrepairphone(String orderrepairphone) {
		this.orderrepairphone = orderrepairphone;
	}

	public String getFaultid() {
		return this.faultid;
	}

	public void setFaultid(String faultid) {
		this.faultid = faultid;
	}

	public String getOrderfrom() {
		return this.orderfrom;
	}

	public void setOrderfrom(String orderfrom) {
		this.orderfrom = orderfrom;
	}

	public String getFaultphone() {
		return this.faultphone;
	}

	public void setFaultphone(String faultphone) {
		this.faultphone = faultphone;
	}

	public String getFaultname() {
		return this.faultname;
	}

	public void setFaultname(String faultname) {
		this.faultname = faultname;
	}

}