<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SignUp</title>
</head>
<body>
	<center>
	<s:form action="SignupAction" method="post" >
		<s:textfield name="un" label="Username"></s:textfield><br/>
		<s:password name="pass" label="Password"></s:password><br/>
		<s:password name="cofpass" label="Confirm Password"></s:password><br/>
		<s:password name="tranpass" label="Transaction Password"></s:password><br/>
		<s:password name="coftranpass" label="Confirm Tran Password"></s:password><br/>
		<s:textfield name="email" label="Email"></s:textfield>
		<s:submit></s:submit>
	</s:form>
	<p> <s:a href="login.jsp">Want to log in?</s:a></p>
	</center>
</body>
</html>