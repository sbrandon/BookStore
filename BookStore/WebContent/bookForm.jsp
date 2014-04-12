<%@ include file="header.jsp" %>
	<h1>Book Form</h1>
	<s:form action="submitBook">
		<s:textfield name="title" placeholder="Book Title"></s:textfield>
		<s:textfield name="author" placeholder="Author"></s:textfield>
		<s:textfield name="price" placeholder="Price"></s:textfield>
		<s:textfield name="isbn" placeholder="ISBN"></s:textfield>
		<s:textfield name="description" placeholder="Description"></s:textfield>
		<s:textfield name="image" placeholder="image"></s:textfield>
		<s:textfield name="stockQuantity" placeholder="Stock Quantity"></s:textfield>
		<s:select list="categories" listValue="categoryTitle" listKey="id" name="category" />
		<s:submit type="button"><span class="glyphicon glyphicon-log-in"></span>&nbsp;Add Book</s:submit>
	</s:form>
<%@ include file="footer.jsp" %>