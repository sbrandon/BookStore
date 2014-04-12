<%@ include file="header.jsp" %>
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
<%@ include file="footer.jsp" %>