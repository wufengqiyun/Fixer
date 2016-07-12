package com.fix.model;

/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */

public class UserInfo implements java.io.Serializable {

	// Fields

	private String userid;
	private String username;
	private String shoplogo;
	private String shopname;
	private String shoptype;
	private String address;
	private String phone;
	private Integer status;
	private User user;

	// Constructors

	/** default constructor */
	public UserInfo() {
	}

	/** minimal constructor */
	public UserInfo(String userid) {
		this.userid = userid;
	}

	/** full constructor */
	public UserInfo(String userid, String username, String shoplogo,
			String shopname, String shoptype, String address, String phone,
			Integer status) {
		this.userid = userid;
		this.username = username;
		this.shoplogo = shoplogo;
		this.shopname = shopname;
		this.shoptype = shoptype;
		this.address = address;
		this.phone = phone;
		this.status = status;
	}

	// Property accessors

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getShoplogo() {
		return this.shoplogo;
	}

	public void setShoplogo(String shoplogo) {
		this.shoplogo = shoplogo;
	}

	public String getShopname() {
		return this.shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	public String getShoptype() {
		return this.shoptype;
	}

	public void setShoptype(String shoptype) {
		this.shoptype = shoptype;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}