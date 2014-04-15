<%@ include file="header.jsp" %>
	<h1>Show Book</h1>
	<table>
		<tr>
			<th>Image:</th>
			<th>Title:</th>
			<th>Author:</th>
			<th>ISBN:</th>
			<th>Stock Quantity:</th>
			<th>Price:</th>
		</tr>
		<tr>
			<td><img src="images/<s:property value="book.image"/>"/></td>
			<td><s:property value="book.title"/></td>
			<td><s:property value="book.author"/></td>
			<td><s:property value="book.isbn"/></td>
			<td><s:property value="book.stockQuantity"/></td>
			<td><s:property value="book.price"/></td>
		</tr>
	</table>
	<s:form action="addToCart">
		<label>Order Quantity</label>
		<select name="quantity">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
		</select>
		<s:hidden name="bookId" value="%{book.id}"/>
		<s:submit type="button">Add To Cart</s:submit>
	</s:form>
	<s:form action="addReview">
		<s:hidden name="bookId" value="%{book.id}"/>
		<label>Rating</label>
		<select name="rating">
			<option value="1">1*</option>
			<option value="2">2*</option>
			<option value="3">3*</option>
			<option value="4">4*</option>
			<option value="5">5*</option>
		</select>
		<s:textfield name="review" placeholder="Good or Bad ?"></s:textfield>
		<s:submit type="button">Leave Review</s:submit>
	</s:form>
	<h2>Reviews</h2>
	<ul>
		<s:iterator value="reviews">
			<li>
				<ul>
					<li><s:property value="customer.firstName"/>&nbsp;<s:property value="customer.lastName"/></li>
					<li>Rating:&nbsp;<s:property value="rating"/></li>
					<li>Review:&nbsp;<s:property value="review"/></li>
					<li>Left at:&nbsp;<s:property value="date"/></li>
				</ul>
			</li>	
		</s:iterator>
	</ul>
<%@ include file="footer.jsp" %>