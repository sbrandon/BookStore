<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TITLE</title>
</head>
<body>
	<h1>Book Form</h1>
	<s:form action="submitBook" theme="bootstrap">
		<div class="form-group">
			<s:textfield name="title" placeholder="" cssClass="form-control"></s:textfield>
		</div>
		<div class="form-group">
			<s:textfield name="author" placeholder="" cssClass="form-control"></s:textfield>
		</div>
		<div class="form-group">
			<s:textfield name="price" placeholder="" cssClass="form-control"></s:textfield>
		</div>
		<div class="form-group">
			<s:textfield name="isbn" placeholder="" cssClass="form-control"></s:textfield>
		</div>
		<div class="form-group">
			<s:textfield name="description" placeholder="" cssClass="form-control"></s:textfield>
		</div>
		<div class="form-group">
			<s:textfield name="image" placeholder="" cssClass="form-control"></s:textfield>
		</div>
		<div class="form-group">
			<s:textfield name="category" placeholder="" cssClass="form-control"></s:textfield>
		</div>
		<s:submit type="button" cssClass="btn btn-success"><span class="glyphicon glyphicon-log-in"></span>&nbsp;Add Book</s:submit>
	</s:form>
</body>
</html>