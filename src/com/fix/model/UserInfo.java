package com.fix.model;

/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */

public class UserInfo implements java.io.Serializable {

	// Fields

	private String userid;
	private User user;
	private String username;
	private String shoplogo;
	private String shopname;
	private String shoptype;
	private String address;
	private String shopphone;

	// Constructors

	/** default constructor */
	public UserInfo() {
	}

	/** minimal constructor */
	public UserInfo(User user) {
		this.user = user;
	}

	/** full constructor */
	public UserInfo(User user, String username, String shoplogo,
			String shopname, String shoptype, String address, String shopphone) {
		this.user = user;
		this.username = username;
		this.shoplogo = shoplogo;
		this.shopname = shopname;
		this.shoptype = shoptype;
		this.address = address;
		this.shopphone = shopphone;
	}

	// Property accessors

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public String getShopphone() {
		return this.shopphone;
	}

	public void setShopphone(String shopphone) {
		this.shopphone = shopphone;
	}

}