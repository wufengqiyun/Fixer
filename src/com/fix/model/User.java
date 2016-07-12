package com.fix.model;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private String userid;
	private String username;
	private String userpassword;
	private String role;
	private UserInfo userInfo;
	private String phonenumber;
	private String token;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String userid) {
		this.userid = userid;
	}

	/** full constructor */
	public User(String userid, String username, String userpassword, String role,String phonenumber) {
		this.userid = userid;
		this.username = username;
		this.userpassword = userpassword;
		this.role = role;
		this.phonenumber = phonenumber;
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

	public String getUserpassword() {
		return this.userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}