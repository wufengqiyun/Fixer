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
	private String orderrepairid;
	private String faultid;
	private String faultowner;
	private String faultphone;
	private String faultname;
	private String faultownerid;

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** full constructor */
	public Order(String orderstate, String orderrepairer,
			String orderrepairphone, String orderrepairid, String faultid,
			String faultowner, String faultphone, String faultname,
			String faultownerid) {
		this.orderstate = orderstate;
		this.orderrepairer = orderrepairer;
		this.orderrepairphone = orderrepairphone;
		this.orderrepairid = orderrepairid;
		this.faultid = faultid;
		this.faultowner = faultowner;
		this.faultphone = faultphone;
		this.faultname = faultname;
		this.faultownerid = faultownerid;
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

	public String getOrderrepairid() {
		return this.orderrepairid;
	}

	public void setOrderrepairid(String orderrepairid) {
		this.orderrepairid = orderrepairid;
	}

	public String getFaultid() {
		return this.faultid;
	}

	public void setFaultid(String faultid) {
		this.faultid = faultid;
	}

	public String getFaultowner() {
		return this.faultowner;
	}

	public void setFaultowner(String faultowner) {
		this.faultowner = faultowner;
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

	public String getFaultownerid() {
		return this.faultownerid;
	}

	public void setFaultownerid(String faultownerid) {
		this.faultownerid = faultownerid;
	}

}