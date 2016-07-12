package com.fix.action;

import java.util.ArrayList;
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
	private String faultid="";
	private String faultname=""; //故障名
	private String orderfrom=""; //提交故障人
	private String faultphone=""; //提交人电话
	
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
	public String getOrderfrom() {
		return orderfrom;
	}
	public void setOrderfrom(String orderfrom) {
		this.orderfrom = orderfrom;
	}
	public String getFaultphone() {
		return faultphone;
	}
	public void setFaultphone(String faultphone) {
		this.faultphone = faultphone;
	}

	public void setnull(){
		faultid="";
		repairer="";
		repairphone="";
		orderid="";
		state="";
		faultname="";
		orderfrom="";
		faultphone="";
	}
	
	public String addorupdateOrder() {
		Order order=new Order();
		order.setOrderstate(state);
		Map<String, Object> map = new HashMap<String, Object>();  
		if (orderService.addorupdateOrder(order)) {
			map.put("orderid", order.getOrderid());
			result successResult=new result("1", null, "dingdan成功");
			map.put("result", successResult);
			this.setResponseJson(map);
			setnull();
			return SUCCESS;
		}
		else {
			result successResult=new result("0","dingdan失败", null);
			map.put("result", successResult);
			this.setResponseJson(map);
			setnull();
			return ERROR;
		}
	}
	
	public String getallOrder(){
		List<Order> orderlisList=orderService.getallOrder();
		Map<String, Object> map = new HashMap<String, Object>();  
//        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();  
//        for(int i=0;i<3;i++){  
//            Map<String, Object> m = new HashMap<String, Object>();  
//            m.put("id", i);  
//            m.put("name", "Mic"+i);  
//            list.add(m);  
//        }  
		result successResult=new result("1", null, "查询成功");
		map.put("result", successResult);
		map.put("orderlist", orderlisList);
		this.setResponseJson(map);
		return SUCCESS;
	}
}
