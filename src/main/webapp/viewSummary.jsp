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
	<h1 align="center">Welcome to the Transaction Summary page! </h1>
	<div="info" align="right">
		<p>Hi, <strong><s:property value="#session.un"/></strong></p>
		<p>AccountNo: <s:property value="#session.acno"/> </p>
		<p>Balance: <s:property value="#session.balance"/> </p>
	</div>
	
	<center>
	<table border="1" align="center">
	<tr>
	<th>From</th>
	<th>To</th>
	<th>Amount</th>
	<th>Credit/Debit</th>
	<th>Transaction Date</th>
	</tr>
		<s:iterator var="list" value="#session.alltrans"  status="stat">
		<tr>
    	<td align="center"><s:property value="un" /></td> 
        <td align="center"><s:property value="targetun" /></td>
        <td align="center"><s:property value="amount" /></td>
         <td align="center"><s:property value="transfertype" /></td>
        <td align="center"><s:property value="trandate" /></td>
   		</tr>

		</s:iterator>
	</table>
	
	<br/>
	<s:form action="userhomepage.jsp" method="post">
		 <s:submit value="Click here"></s:submit>Click the button below to go back to the home page.
		</s:form>
	
	</center>
<s:a href="login.jsp">Click Here</s:a> to log out!
</body>
</html>