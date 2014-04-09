<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TITLE</title>
</head>
<body>
	<h1>Home Page of Book Shop</h1>
	<h2>Select A Category</h2>
	<table>
		<tr>
			<th>Category Name:</th>
		</tr>
		<s:iterator value="categories">
			<tr>
				<td><s:property value="categoryTitle"/></td>
			</tr>
		</s:iterator>
	</table>
	<h2>Search For Books</h2>
	<s:form action="searchBooks">
		<label for="searchObject" class="control-label">Search Subject</label>
		<select name="searchObject" class="form-control">
			<option value="author">Author</option>
			<option value="title">Title</option>
			<option value="category">Category</option>
		</select>
		<label for="address">Search String:</label>
		<s:textfield name="searchString" type="text" value="" placeholder="John Steinbeck..."></s:textfield>
		<s:submit type="button">Search</s:submit>
	</s:form>
</body>
</html>