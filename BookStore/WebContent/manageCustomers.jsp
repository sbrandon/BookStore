<%@ include file="header.jsp" %>
<h1>Manage Customers</h1>
<table>
	<tr>
		<th>ID</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Email</th>
		<th>Phone</th>
		<th>Address Line 1</th>
		<th>Address Line 2</th>
		<th>Address Line 3</th>
		<th>Town</th>
		<th>County</th>
	</tr>
	<s:iterator value="customers">
		<tr>
			<td><s:property value="id"/></td>
			<td><s:property value="firstName"/></td>
			<td><s:property value="lastName"/></td>
			<td><s:property value="email"/></td>
			<td><s:property value="phone"/></td>
			<td><s:property value="addressLine1"/></td>
			<td><s:property value="addressLine2"/></td>
			<td><s:property value="addressLine3"/></td>
			<td><s:property value="town"/></td>
			<td><s:property value="county"/></td>
		</tr>
	</s:iterator>
</table>
<%@ include file="footer.jsp" %>