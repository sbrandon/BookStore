<%@ include file="header.jsp" %>
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
<%@ include file="footer.jsp" %>