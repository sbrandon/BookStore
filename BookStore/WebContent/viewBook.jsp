<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TITLE</title>
</head>
<body>
	<h1>Show Book</h1>
	<table border="1">
		<tr>
			<th>Title:</th>
			<th>Author:</th>
			<th>ISBN:</th>
			<th>Stock Quantity:</th>
			<th>Price:</th>
		</tr>
		<tr>
			<td><s:property value="book.title"/></td>
			<td><s:property value="book.author"/></td>
			<td><s:property value="book.isbn"/></td>
			<td><s:property value="book.stockQuantity"/></td>
			<td><s:property value="book.price"/></td>
		</tr>
	</table>
	<s:form action="addToCart">
		<s:textfield name="quantity" placeholder="Enter Quantity"></s:textfield>
		<s:hidden name="bookId" value="%{book.id}"/>
		<s:submit type="button">Add To Cart</s:submit>
	</s:form>
	<s:form action="addReview">
		<s:hidden name="bookId" value="%{book.id}"/>
		<s:textfield name="rating" placeholder="Rating 1 - 5 *"></s:textfield>
		<s:textfield name="review" placeholder="Good or Bad ?"></s:textfield>
		<s:submit type="button">Leave Review</s:submit>
	</s:form>
	<h2>Reviews</h2>
	<ul>
		<s:iterator value="reviews">
			<li>
				<ul>
					<li><s:property value="customer.firstName"/>&nbsp;<s:property value="customer.lastName"/></li>
					<li><s:property value="rating"/></li>
					<li><s:property value="review"/></li>
				</ul>
			</li>	
		</s:iterator>
	</ul>
</body>
</html>