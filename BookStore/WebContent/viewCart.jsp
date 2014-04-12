<%@ include file="header.jsp" %>
	<h1>Shopping Cart</h1>
	<table border="1">
		<tr>
			<th>Title:</th>
			<th>Price:</th>
			<th>Quantity:</th>
			<th>Line Total:</th>
			<th></th>
		</tr>
		<s:iterator value="lineItems">
			<tr>
				<td><s:property value="book.title"/></td>
				<td><s:property value="book.price"/></td>
				<td><s:property value="quantity"/></td>
				<td><s:property value="lineTotal"/></td>
				<td>
					<s:form action="removeCartItem">
						<s:hidden name="lineItemId" value="%{id}"/>
						<s:submit type="button">Remove From Cart</s:submit>
					</s:form>
				</td>
			</tr>
		</s:iterator>
	</table>
	<h2><s:property value="total"/></h2>
	<s:form action="confirmOrder">
		<s:hidden name="cartId" value="%{cart.id}"/>
		<s:submit type="button">Confirm Order</s:submit>
	</s:form>
<%@ include file="footer.jsp" %>