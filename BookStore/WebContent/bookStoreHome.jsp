<%@ include file="header.jsp" %>
	<h1>Home Page of Book Shop</h1>
	<h2>Select A Category</h2>
	<table>
		<tr>
			<th>Category Name:</th>
		</tr>
		<s:iterator value="categories">
			<tr>
				<td>
					<s:property value="categoryTitle"/>
				</td>
			</tr>
		</s:iterator>
	</table>
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