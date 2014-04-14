<%@ include file="header.jsp" %>
	<h1>Administration Dashboard</h1>
	<h2>Menu:</h2>
	<ul>
		<li><a href="<s:url action="categoriesForm"/>">Add new Categories</a></li>
		<li><a href="<s:url action="booksForm"/>">Add new Books</a></li>
		<li><a href="<s:url action="manageOrders"/>">Manage Orders</a></li>
		<li><a href="<s:url action="manageCustomers"/>">Manage Customers</a></li>
		<li><a href="<s:url action="shopHome"/>">Shop Home</a></li>
	</ul>
<%@ include file="footer.jsp" %>