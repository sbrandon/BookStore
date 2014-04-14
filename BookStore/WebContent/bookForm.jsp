<%@ include file="header.jsp" %>
	<h1>Book Form</h1>
	<s:form action="submitBook" method="post" enctype="multipart/form-data">
		<input type="file" name="myFile" />
		<s:textfield name="title" placeholder="Book Title" value="%{book.title}"></s:textfield>
		<s:textfield name="author" placeholder="Author" value="%{book.author}"></s:textfield>
		<s:textfield name="price" placeholder="Price" value="%{book.price}"></s:textfield>
		<s:textfield name="isbn" placeholder="ISBN" value="%{book.isbn}"></s:textfield>
		<s:textfield name="description" placeholder="Description" value="%{book.description}"></s:textfield>
		<s:textfield name="stockQuantity" placeholder="Stock Quantity" value="%{book.stockQuantity}"></s:textfield>
	    <s:select list="categories" listValue="categoryTitle" listKey="id" name="category"/>
	    <s:hidden name="bookId" value="%{book.id}"/>
		<s:submit type="button"><span class="glyphicon glyphicon-log-in"></span>&nbsp;Add Book</s:submit>
	</s:form>
<%@ include file="footer.jsp" %>