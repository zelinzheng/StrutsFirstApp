<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<sx:head></sx:head>
<body>
	<sx:datetimepicker name="deliverydate" label="Delivery Date"
         displayFormat="MM/dd/yyyy"></sx:datetimepicker>
         http://www.mkyong.com/struts2/struts-2-file-upload-example/
    <sx:div></sx:div>
    
    <s:form action="SubmitAction" namespace="/"  method="POST" enctype="multipart/form-data">
 
	<s:file name="fileUpload" label="Select a File to upload" size="40" />
 
	<s:submit value="submit" name="submit" />
 
	</s:form>
    
    
</body>
</html>