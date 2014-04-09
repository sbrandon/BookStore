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
	<h1>Shopping Cart</h1>
	<table border="1">
		<tr>
			<th>Title:</th>
			<th>Price:</th>
			<th>Quantity:</th>
		</tr>
		<s:iterator value="lineItems">
			<tr>
				<td><s:property value="book.title"/></td>
				<td><s:property value="book.price"/></td>
				<td><s:property value="quantity"/></td>
			</tr>
		</s:iterator>
	</table>
	<s:form action="confirmOrder">
		<s:hidden name="cartId" value="%{cart.id}"/>
		<s:submit type="button">Confirm Order</s:submit>
	</s:form>
</body>
</html>