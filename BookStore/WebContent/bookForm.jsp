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
	<s:form action="submitBook">
		<s:textfield name="title" placeholder="Book Title"></s:textfield>
		<s:textfield name="author" placeholder="Author"></s:textfield>
		<s:textfield name="price" placeholder="Price"></s:textfield>
		<s:textfield name="isbn" placeholder="ISBN"></s:textfield>
		<s:textfield name="description" placeholder="Description"></s:textfield>
		<s:textfield name="image" placeholder="image"></s:textfield>
		<s:textfield name="stockQuantity" placeholder="Stock Quantity"></s:textfield>
		<s:select list="categories" listValue="categoryTitle" listKey="id" name="category" />
		<s:submit type="button"><span class="glyphicon glyphicon-log-in"></span>&nbsp;Add Book</s:submit>
	</s:form>
</body>
</html>