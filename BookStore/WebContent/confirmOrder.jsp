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
	<h1>Confirm Order</h1>
	<h2>Customer</h2>
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Email</th>
		</tr>
		<tr>
			<td><s:property value="customer.firstName"/>&nbsp;<s:property value="customer.lastName"/></td>
			<td><s:property value="customer.email"/></td>
		</tr>
	</table>
	<h2>Delivery Details</h2>
	<s:form action="placeOrder">
		<s:textfield name="address1" placeholder="Address Line 1"></s:textfield>
		<s:textfield name="address2" placeholder="Address Line 2"></s:textfield>
		<s:textfield name="address3" placeholder="Address Line 3"></s:textfield>
		<s:textfield name="town" placeholder="Town"></s:textfield>
		<s:textfield name="county" placeholder="County"></s:textfield>
		<s:textfield name="phoneNumber" placeholder="Phone Number"></s:textfield>
		<s:submit type="button">Place Order</s:submit>
	</s:form>
</body>
</html>