<%@ include file="header.jsp" %>
<h1>View Order</h1>
<h2>Delivery Details</h2>
<table>
	<tr>
		<th>Customer Name</th>
		<th>Email</th>
		<th>Phone</th>
		<th>Address Line 1</th>
		<th>Address Line 2</th>
		<th>Address Line 3</th>
		<th>Town</th>
		<th>County</th>
	</tr>
	<tr>
		<td><s:property value="order.customer.firstName"/>&nbsp;<s:property value="order.customer.lastName"/></td>
		<td><s:property value="order.customer.email"/></td>
		<td><s:property value="order.customer.phone"/></td>
		<td><s:property value="order.customer.addressLine1"/></td>
		<td><s:property value="order.customer.addressLine2"/></td>
		<td><s:property value="order.customer.addressLine3"/></td>
		<td><s:property value="order.customer.town"/></td>
		<td><s:property value="order.customer.county"/></td>
	</tr>
</table>
<h2>Items Ordered</h2>
<h3>Total Order Value:&nbsp;<s:property value="totalOrder"/></h3>
<table>
	<tr>
		<th>Book ISBN</th>
		<th>Book Title</th>
		<th>Price</th>
		<th>Quantity</th>
		<th>Line Total</th>
	</tr>
	<s:iterator value="lineItems">
		<tr>
			<td><s:property value="book.isbn"/></td>
			<td><s:property value="book.title"/></td>
			<td><s:property value="book.price"/></td>
			<td><s:property value="quantity"/></td>
			<td><s:property value="lineTotal"/></td>
		</tr>
	</s:iterator>
</table>
<%@ include file="footer.jsp" %>