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
	<h1 align="center">Welcome to the userhome page! </h1>
	<div="info" align="right">
		<p>Hi, <strong><s:property value="#session.un"/></strong></p>
		<p>AccountNo: <s:property value="#session.acno"/> </p>
		<p>Balance: <s:property value="#session.balance"/> </p>
	</div>
	
	<s:form action="TransferAction" method="post">
		<s:submit value="Transfer Money."></s:submit>
	</s:form>
	
	<s:form action="ViewSummary" method="post">
		<s:submit value="View Summary."></s:submit>
	</s:form>
	<s:a href="login.jsp">Click Here</s:a> to log out!
</body>
</html>