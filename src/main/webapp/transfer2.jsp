<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.util.ValueStack,com.opensymphony.xwork2.ActionContext,com.dbutil.ORMDAccounts,java.util.Map" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%	
	
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User home page!</title>
</head>
<body>
<s:a href="userhomepage.jsp">User Home</s:a>
	<h1 align="center">Welcome to the Transfer Money detail page! </h1>
	<div="info" align="right">
		<p>Hi, <strong><s:property value="#session.un"/></strong></p>
		<p>AccountNo: <s:property value="#session.acno"/> </p>
		<p>Balance: <s:property value="#session.balance"/> </p>
	</div>
	
	<center>
		You have selected <s:property value="#session.targetAcno"/>. This is <s:property value="#session.targetun"/>'s account.<br/>
		<p>Kindly punch in the amount you want to tranfer below.</p><br/>
		<s:form action="TransferMoney" method="post">
		<s:textfield name="amount" label="Amount"></s:textfield> 
		<s:password name="tranpass" label="Transactin Pass"></s:password> <s:submit value="Transfer"></s:submit>
		</s:form>
	</center>
</body>
</html>