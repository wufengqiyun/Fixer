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
    
    <title>My JSP 'OrderEdit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<!-- 	<link href="css/style.css" rel="stylesheet" type="text/css" /> -->
	<!-- <script type="text/javascript" src="js/jquery.js"></script> -->

  </head>
  
  <body>
  	<s:set value="#request.faultdisplay" id="fault"></s:set>
  	<s:action name="getallRepairer" executeResult="false"></s:action>
    <s:form method="post" name="giverepairer" enctype="multipart/form-data" action="chooseRepairer.action">
    	<s:label>故障标题:<s:property value="#fault.faulttitle"></s:property></s:label> <br>
    	<s:label>故障内容:<s:property value="#fault.faultcontent"></s:property></s:label> <br>
    	<s:label>故障时间:<s:property value="#fault.faulttime"></s:property></s:label> <br>
    	<s:label>故障地址:<s:property value="#fault.faultlocation"></s:property></s:label> <br>
    	<s:label>报修人电话:<s:property value="#fault.faultphone"></s:property></s:label> <br>
    	<s:label>备注:<s:property value="#fault.faultdesc"></s:property></s:label> <br>
    	<s:label>报修人:<s:property value="#fault.faultowner"></s:property></s:label> <br>
    	<input type="hidden" name="faultid" value='<s:property value="#fault.faultid"/>'>
    	配置维修人员:<select class="input-large"  name="repairid">					
			<s:iterator value="#request.repairers" id="repairers">
				<option value='<s:property value="#repairers.userid"/>'><s:property value="#repairers.username"></s:property></option>
			</s:iterator>
		</select>	 
		<s:submit label="tijioa" value="配置完成"></s:submit>
    </s:form>
  </body>
</html>
