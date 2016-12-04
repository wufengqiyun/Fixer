package com.fix.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fix.model.Fault;
import com.fix.model.Order;
import com.fix.service.IFaultService;
import com.fix.service.IOrderService;
import com.fix.util.result;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FaultAction extends ActionSupport{
	private IFaultService faultService;
	private IOrderService orderService;
	public Map responseJson;
	private String faultid="";
	private String title="";
	private String content="";
	private String time="";
	private String location="";
	private String phonenumber="";
	private String desc="";
	private String name="";
	private String faultownerid="";
	private String pictures="";
	
	
	public Map getResponseJson() {
		return responseJson;
	}
	public void setResponseJson(Map responseJson) {
		this.responseJson = responseJson;
	}
	public IFaultService getFaultService() {
		return faultService;
	}
	public void setFaultService(IFaultService faultService) {
		this.faultService = faultService;
	}
	
	public IOrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}
	public String getFaultid() {
		return faultid;
	}
	public void setFaultid(String faultid) {
		this.faultid = faultid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getFaultownerid() {
		return faultownerid;
	}
	public void setFaultownerid(String faultownerid) {
		this.faultownerid = faultownerid;
	}
	
	public String getPictures() {
		return pictures;
	}
	public void setPictures(String pictures) {
		this.pictures = pictures;
	}
	
	//添加或者更新故障信息
	public String addorupdateFault(){
		Fault fault=new Fault();
		fault.setFaultcontent(content);
		fault.setFaultdesc(desc);
		fault.setFaultlocation(location);
		fault.setFaulttime(time);
		fault.setFaulttitle(title);
		fault.setFaultphone(phonenumber);
		fault.setFaultowner(name);
		fault.setFaultownerid(faultownerid);
		fault.setFaultpictures(pictures);
		Map<String, Object> map = new HashMap<String, Object>();  
		if (faultService.addorupdateFault(fault)) {
			//生成订单并插入订单表,返回订单号
			Order initialorder=new Order();
			initialorder.setFaultid(fault.getFaultid());
			initialorder.setFaultname(fault.getFaulttitle());
			initialorder.setOrderstate("0");
			initialorder.setFaultphone(fault.getFaultphone());
			initialorder.setFaultowner(fault.getFaultowner());
			initialorder.setFaultownerid(fault.getFaultownerid());
			orderService.addorupdateOrder(initialorder);
			map.put("orderid", initialorder.getOrderid());
			result successResult=new result("1", null, "报障成功");
			map.put("result", successResult);
			map.put("faultid", fault.getFaultid());
			this.setResponseJson(map);
			return SUCCESS;
		}
		else {
			result successResult=new result("0","报障失败", null);
			map.put("result", successResult);
			this.setResponseJson(map);
			return ERROR;
		}
	
	}
	
	//根据faultid查询故障详细信息
	public String getFaultByFaultId(){
		Fault fault=faultService.getFaultByFaultId(faultid);
		Map<String, Object> map = new HashMap<String, Object>();  
		result successResult=new result("1", null, "查询成功");
		map.put("result", successResult);
		map.put("fault", fault);
		this.setResponseJson(map);
		return SUCCESS;
	}
	
	public String BgetFaultByFaultId(){
		Fault fault=faultService.getFaultByFaultId(faultid);
		Map request=(Map) ActionContext.getContext().get("request");
		request.put("faultdisplay",fault);
		return SUCCESS;
	}
}
