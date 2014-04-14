<%@ include file="header.jsp" %>
<h1>Manage Orders</h1>
<table>
	<tr>
		<th>ID</th>
		<th>Customer</th>
		<th></th>
	</tr>
	<s:iterator value="orders">
		<tr>
			<td><s:property value="id"/></td>
			<td><s:property value="customer.firstName"/><s:property value="customer.lastName"/></td>
			<td>
				<s:form action="viewOrder">
					<s:hidden name="orderId" value="%{id}"/>
					<s:submit type="button">Open Order</s:submit>
				</s:form>
			</td>
		</tr>
	</s:iterator>
</table>
<%@ include file="footer.jsp" %>