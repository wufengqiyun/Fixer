package com.fix.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.fix.dao.impl.UserDAO;
import com.fix.model.User;
import com.fix.model.UserInfo;
import com.fix.service.IUserService;
import com.fix.util.result;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qiniu.util.Auth;

public class UserAction extends ActionSupport{
	public static final String numberChar = "0123456789";
	private IUserService userService;
	public Map responseJson;
	
	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	public Map getResponseJson() {
		return responseJson;
	}
	public void setResponseJson(Map responseJson) {
		this.responseJson = responseJson;
	}
	
	
	private String userid="";
	private String username="";
	private String userpassword="";
	private String role="";
	private String phonenumber="";
	private String token="";
	private String shoplogo="";
	private String shopname="";
	private String shoptype="";
	private String address="";
	private String shopphone="";

	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getShoplogo() {
		return shoplogo;
	}
	public void setShoplogo(String shoplogo) {
		this.shoplogo = shoplogo;
	}
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public String getShoptype() {
		return shoptype;
	}
	public void setShoptype(String shoptype) {
		this.shoptype = shoptype;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	 
	public String getShopphone() {
		return shopphone;
	}
	public void setShopphone(String shopphone) {
		this.shopphone = shopphone;
	}
	
	//用户添加
	 public String addorupdateUser() throws Exception{
		 User user=new User();
		 UserInfo userInfo=new UserInfo();
		 //随机用户名
//		 UUID uuid = UUID.randomUUID();  
//		 String string=uuid.toString();
		 user.setToken(token);
		 user.setRole(role);
		 user.setUsername(username);
		 user.setUserpassword(userpassword);
		 user.setPhonenumber(phonenumber);
		 userInfo.setUsername(username);
		 userInfo.setAddress(address);
		 userInfo.setShopphone(shopphone);
		 userInfo.setShoplogo(shoplogo);
		 userInfo.setShopname(shopname);
		 userInfo.setShoptype(shoptype);
		 userInfo.setUser(user);
		 user.setUserInfo(userInfo);
		 user.setToken(getrandomtoken());
		 if (userService.addorupdateUser(user,userInfo)) {
			 Map<String, Object> map = new HashMap<String, Object>();  
//		        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();  
//		        for(int i=0;i<3;i++){  
//		            Map<String, Object> m = new HashMap<String, Object>();  
//		            m.put("id", i);  
//		            m.put("name", "Mic"+i);  
//		            list.add(m);  
//		        }  
			 result successResult=new result("1", null, "注册成功");
			 map.put("result", successResult);
			 map.put("userid", user.getUserid());
			 map.put("token", user.getToken());
			 this.setResponseJson(map);
			 return SUCCESS;
		}
		 else {
			 return ERROR;
		}
	 }
	 
	 //登录验证
	 public String checkUser(){
		 User usertest=new User();
//		 Map request=(Map) ActionContext.getContext().get("request");
//		 HttpServletRequest request = ServletActionContext.getRequest();
//		 JSONObject json=JSONObject.fromObject(request.getParameter("data"));
//		 System.out.println(json.getJSONArray("username"));
//		 if (!getjson.isEmpty()) {
//			 JSONObject jsondata=JSONObject.fromObject(getjson);
//			  usertest.setUsername(jsondata.getString("username"));
//			  usertest.setUserpassword(jsondata.getString("userpassword"));
//		}
//		usertest.setUsername(username);
		 usertest.setUserpassword(userpassword);
		 usertest.setPhonenumber(phonenumber);
//		 System.out.println(phonenumber);
//		 System.out.println(usertest.getPhonenumber());
		 User loginUser=userService.checkUser(usertest);
		 Map<String, Object> map=new HashMap<String, Object>();	
		 if (loginUser!=null) {
			 System.out.println("chengogng");
			//登录成功
			loginUser.setToken(getrandomtoken());
			userService.addToken(loginUser);
			result successResult=new result("1", null, "登录成功");
			map.put("result", successResult);
			map.put("token", loginUser.getToken());
			map.put("userid", loginUser.getUserid());
			this.setResponseJson(map);
			return SUCCESS;
		 }
		 else {
			result successResult=new result("0","登录失败", null);
			map.put("result", successResult);
			this.setResponseJson(map);
			return ERROR;
		 }
	 }
	 
	 public String getUserDetail(){
		 User usertest=new User();
		 usertest.setToken(token);
		 User loginUser=userService.checkUserByToken(usertest);
		 Map<String, Object> map=new HashMap<String, Object>();	
		 if (loginUser!=null) {
			//token验证成功返回
			result successResult=new result("1", null, "获取信息成功");
			map.put("result", successResult);
			UserInfo loginUserInfo=new UserInfo();
			loginUserInfo.setUserid(loginUser.getUserid());
			loginUserInfo.setUsername(loginUser.getUsername());
			loginUserInfo.setShoplogo(loginUser.getUserInfo().getShoplogo());
			loginUserInfo.setShopname(loginUser.getUserInfo().getShopname());
			loginUserInfo.setShoptype(loginUser.getUserInfo().getShoptype());
			loginUserInfo.setAddress(loginUser.getUserInfo().getAddress());
			loginUserInfo.setShopphone(loginUser.getUserInfo().getShopphone());
			map.put("userinfo", loginUserInfo);
			this.setResponseJson(map);
			return SUCCESS;
		 }
		 else {
			result successResult=new result("0","登录信息无效，无法获取", null);
			map.put("result", successResult);
			this.setResponseJson(map);
			return ERROR;
		 }
	 }
	 
	 public String getrandomtoken() {
		//添加token
			Long seed = System.currentTimeMillis();// 获得系统时间，作为生成随机数的种子
		    StringBuffer sb = new StringBuffer();// 装载生成的随机数
			Random random = new Random(seed);// 调用种子生成随机数
			for (int i = 0; i < 20; i++) {
				sb.append(numberChar.charAt(random.nextInt(numberChar.length())));
			}
			return sb.toString();
	}
	 
	 public String getallRepairer(){
		 List repairs=userService.getallRepairer();
		 Map request=(Map) ActionContext.getContext().get("request");
		 request.put("repairers", repairs);
		 return SUCCESS;
	 }
	 
	 public String getUserById(){
		 User user=userService.getUserById("1");
		 Map<String, Object> map=new HashMap<String, Object>();	
		 map.put("user", user);
		 this.setResponseJson(map);
		 return SUCCESS;
	 }
	 
	 public String uploadtoken(){
		 String ACCESS_KEY="Pvhjp0qiiAEIE3ocHngIIKR0ITN4l9ddNkBfNzOv";
		 String SECRET_KEY="NS9r4MTVoaUAziW85R4ZJ2TUMbjlMYzHVFPvDK1E";
		 Auth auth=Auth.create(ACCESS_KEY, SECRET_KEY);
		 String bucketname="fixer";
		 String uploadtoken=auth.uploadToken(bucketname);
		 Map<String, Object> map=new HashMap<String, Object>();	
		 map.put("uploadtoken", uploadtoken);
		 this.setResponseJson(map);
		 return SUCCESS;
	 }
}
