<%@ include file="header.jsp" %>
	<h1>Category Form</h1>
	<s:form action="submitCategory">
		<s:textfield name="categoryTitle" placeholder="Category Title"></s:textfield>
		<s:submit type="button">Add Category</s:submit>
	</s:form>
<%@ include file="footer.jsp" %>