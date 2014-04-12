<%@ include file="header.jsp" %>
<h1>Welcome to the Bookstore</h1>
<h2>Register</h2>
<s:form id="register_form" action="register">
	<s:textfield name="firstName" id="" placeholder="First Name"></s:textfield>
	<s:textfield name="lastName" id="" placeholder="Last Name"></s:textfield>
	<s:textfield name="email" id="" placeholder="Email"></s:textfield>
	<s:password name="password" id="" placeholder="Password"></s:password>
	<s:submit type="button">Register</s:submit>
</s:form>
<h2>Login</h2>
<s:form action="login">
	<s:textfield name="email" placeholder="Email" cssClass="form-control"></s:textfield>
	<s:password name="password" placeholder="Password" cssClass="form-control"></s:password>
	<s:submit type="button" >Log In</s:submit>
</s:form>
<%@ include file="footer.jsp" %>