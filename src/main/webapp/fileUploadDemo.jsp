<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
 
<body>
<h1>Struts 2 &lt;s:file&gt; file upload example</h1>
 
<h4>
   File Name : <s:property value="fileUploadFileName"/> 
</h4> 
 
<h4>
   Content Type : <s:property value="fileUploadContentType"/> 
</h4> 
 
<h4>
   File : <s:property value="fileUpload"/> 
</h4> 
 
</body>
</html>