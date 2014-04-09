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
	<h1>Search Results / Show Books</h1>
	<table border="1">
		<tr>
			<th>Title:</th>
			<th>Author:</th>
			<th>ISBN:</th>
			<th>Stock Quantity:</th>
			<th>Price:</th>
			<th></th>
		</tr>
		<s:iterator value="books">
			<tr>
				<td><s:property value="title"/></td>
				<td><s:property value="author"/></td>
				<td><s:property value="isbn"/></td>
				<td><s:property value="stockQuantity"/></td>
				<td><s:property value="price"/></td>
				<td>
					<s:form action="viewBook">
						<s:hidden name="bookId" value="%{id}"/>
						<s:submit type="button">View Book</s:submit>
					</s:form>
				</td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>