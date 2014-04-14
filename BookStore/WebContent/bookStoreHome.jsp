<%@ include file="header.jsp" %>
	<h1>Home Page of Book Shop</h1>
	<h2>Select A Category</h2>
	<ul>
		<s:iterator value="categories">
			<s:url action="getBooksByCategory" includeParams="get" var="catId">
				<s:param name="catId" value="%{id}"/>
			</s:url>
			<li><a href="<s:property value="#catId"/>"><s:property value="categoryTitle"/></a>
		</s:iterator>
	</ul>
	<h2>Search For Books</h2>
	<s:form action="searchBooks">
		<label for="searchObject" class="control-label">Search Subject</label>
		<select name="searchObject" class="form-control">
			<option value="author">Author</option>
			<option value="title">Title</option>
			<option value="category">Category</option>
		</select>
		<label for="address">Search String:</label>
		<s:textfield name="searchString" type="text" value="" placeholder="John Steinbeck..."></s:textfield>
		<s:submit type="button">Search</s:submit>
	</s:form>
<%@ include file="footer.jsp" %>