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
	<h1 align="center">Welcome to the Transfer page! </h1>
	<div="info" align="right">
		<p>Hi, <strong><s:property value="#session.un"/></strong></p>
		<p>AccountNo: <s:property value="#session.acno"/> </p>
		<p>Balance: <s:property value="#session.balance"/> </p>
	</div>
	
	<center>
		<s:form action="TransferDetail" method="post">
			<s:select list="#session.accounts" name="targetun" label="Please select the account you want to transfer:">
			</s:select>
			<s:submit value="Get details."></s:submit>
		</s:form>
	</center>
</body>
</html>