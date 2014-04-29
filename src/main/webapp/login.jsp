<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
	<s:form action="LoginAction" method="post">
		<s:textfield name="un" label="Username"></s:textfield><br/>
		<s:password name="pass" label="Password"></s:password><br/>
		<s:submit></s:submit>
	</s:form>
	<p>Not a member yet! Click to <s:a href="signup.jsp">sign up!</s:a></p>
</center>


	<%-- <sx:div delay="3000">
		<%=new java.util.Date()%>
		Delay display for 3 seconds
	</sx:div> --%>
	
	<%-- <sx:autocompleter	label="username" list="#session.accounts">
		
	</sx:autocompleter> --%>
</body>
</html>