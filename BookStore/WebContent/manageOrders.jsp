<%@ include file="header.jsp" %>
<h1>Manage Orders</h1>
<table>
	<tr>
		<th>Amount</th>
		<th>First Name</th>
	</tr>
	<s:iterator value="orders">
		<tr>
			<td><s:property value="lineItem.lineTotal"/></td>
			<td><s:property value="customer.firstName"/></td>
		</tr>
	</s:iterator>
</table>
<%@ include file="footer.jsp" %>