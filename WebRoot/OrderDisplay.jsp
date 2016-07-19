<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'FaultDisplay.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
	
  </head>
  
  <body>
  	<s:action name="getOrderForDisplay" executeResult="false"></s:action>
  	
    <table class="tablelist">
		<thead>
		<tr>
				<th>报障用户</th>
				<th>用户电话</th>
				<th>故障名</th>
				<th>维修人</th>
				<th>维修状态</th>
				<th>维修人电话</th>
				<th></th>
				
		</tr>
		</thead>
		<tbody>
			<s:iterator value="#request.orders" id="orders">
			  <tr>
				<td><s:property value="#orders.faultowner"></s:property></td>
				<td><s:property value="#orders.faultphone"></s:property></td>
				<td><s:property value="#orders.faultname"></s:property></td>
				<td><s:property value="#orders.orderrepairer"></s:property></td>
				<td><s:property value="#orders.orderstate"></s:property></td>
				<td><s:property value="#orders.orderrepairphone"></s:property></td>
				<td>
				<a href="BgetFaultByFaultId.action?faultid=<s:property value="#orders.faultid"></s:property>" target="_self">配置维修人员</a>
				</td>
				<td>
				</td>
			 </tr>
			</s:iterator>
			
		</tbody>
	</table>
  </body>
</html>
