<%@ include file="header.jsp" %>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
	<h1>Search Results / Show Books</h1>
	<display:table name="books" pagesize="10" requestURI="" sort = "list">
		<display:column property="title" title="Title" sortable="true"/>
		<display:column property="author" title="Author" sortable="true"/>
		<display:column property="isbn" title="ISBN" sortable="true"/>
		<display:column property="stockQuantity" title="Available" sortable="true"/>
		<display:column property="price" title="Price" sortable="true"/>
	    <display:column property="id" title="View Book" href="viewBook.action" paramId="bookId" />
	    <s:if test="%{admin!=null}">
			<display:column property="id" title="Edit Book" href="editBook.action" paramId="bookId" />
		</s:if>
	</display:table>
<%@ include file="footer.jsp" %>