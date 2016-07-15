package com.fix.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fix.model.Order;
import com.fix.service.IOrderService;
import com.fix.util.result;
import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport{
	private IOrderService orderService;
	public Map responseJson;
	private String orderid="";
	private String state="";
	private String repairer="";
	private String repairphone="";
	private String repairid="";
	private String faultid="";
	private String faultname=""; //故障名
	private String faultowner=""; //提交故障人
	private String faultownerid="";//提交人id
	private String faultphone=""; //提交人电话
//	private String userid=""; 
	
	public IOrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}
	public Map getResponseJson() {
		return responseJson;
	}
	public void setResponseJson(Map responseJson) {
		this.responseJson = responseJson;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getRepairer() {
		return repairer;
	}
	public void setRepairer(String repairer) {
		this.repairer = repairer;
	}
	public String getRepairphone() {
		return repairphone;
	}
	public void setRepairphone(String repairphone) {
		this.repairphone = repairphone;
	}
	
	public String getRepairid() {
		return repairid;
	}
	public void setRepairid(String repairid) {
		this.repairid = repairid;
	}
	public String getFaultid() {
		return faultid;
	}
	public void setFaultid(String faultid) {
		this.faultid = faultid;
	}
	public String getFaultname() {
		return faultname;
	}
	public void setFaultname(String faultname) {
		this.faultname = faultname;
	}
	public String getFaultowner() {
		return faultowner;
	}
	public void setFaultowner(String faultowner) {
		this.faultowner = faultowner;
	}
	
	public String getFaultownerid() {
		return faultownerid;
	}
	public void setFaultownerid(String faultownerid) {
		this.faultownerid = faultownerid;
	}
	public String getFaultphone() {
		return faultphone;
	}
	public void setFaultphone(String faultphone) {
		this.faultphone = faultphone;
	}

	
//	public String getUserid() {
//		return userid;
//	}
//	public void setUserid(String userid) {
//		this.userid = userid;
//	}
	
	public void setnull(){
		faultid="";
		repairer="";
		repairphone="";
		repairid="";
		orderid="";
		state="";
		faultname="";
		faultowner="";
		faultphone="";
		faultownerid="";
	}
	//添加或修改订单
	public String addorupdateOrder() {
		Order order=new Order();
		order.setOrderstate(state);
		order.setOrderid(orderid);
		order.setOrderrepairer(repairer);
		order.setOrderrepairphone(repairphone);
		order.setOrderrepairid(repairid);
		Map<String, Object> map = new HashMap<String, Object>();  
		if (orderService.addorupdateOrder(order)) {
			map.put("orderid", order.getOrderid());
			result successResult=new result("1", null, "下订单成功");
			map.put("result", successResult);
			this.setResponseJson(map);
			setnull();
			return SUCCESS;
		}
		else {
			result successResult=new result("0","下订单失败", null);
			map.put("result", successResult);
			this.setResponseJson(map);
			setnull();
			return ERROR;
		}
	}
	//获取所有订单
	public String getallOrder(){
		List<Order> orderlisList=orderService.getallOrder();
		Map<String, Object> map = new HashMap<String, Object>();  
		result successResult=new result("1", null, "查询成功");
		map.put("result", successResult);
		map.put("orderlist", orderlisList);
		this.setResponseJson(map);
		return SUCCESS;
	}
	
	//通过故障提交人id进行查询
	public String getOrderByownerId(){
		List<Order> orderlisList=orderService.getOrderByownerId(faultownerid);
		Map<String, Object> map = new HashMap<String, Object>();  
		result successResult=new result("1", null, "查询成功");
		map.put("result", successResult);
		map.put("orderlist", orderlisList);
		this.setResponseJson(map);
		setnull();
		return SUCCESS;
	}
	//通过维修人id进行查询
		public String getOrderByrepairerId(){
			List<Order> orderlisList=orderService.getOrderByrepairerId(repairid);
			Map<String, Object> map = new HashMap<String, Object>();  
			result successResult=new result("1", null, "查询成功");
			map.put("result", successResult);
			map.put("orderlist", orderlisList);
			this.setResponseJson(map);
			setnull();
			return SUCCESS;
		}
	//修改订单的状态
		public String updateState(){
			Order orderupdate=orderService.getOrderByfaultId(faultid);
			orderupdate.setOrderstate(state);
			Map<String, Object> map = new HashMap<String, Object>();  
			if (orderService.addorupdateOrder(orderupdate)) {
				result successResult=new result("1", null, "修改状态成功");
				map.put("result", successResult);
				this.setResponseJson(map);
				setnull();
				return SUCCESS;
			}
			else {
				result successResult=new result("0","修改状态失败", null);
				map.put("result", successResult);
				this.setResponseJson(map);
				setnull();
				return ERROR;
			}
		}
}
