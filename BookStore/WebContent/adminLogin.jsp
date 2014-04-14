<%@ include file="header.jsp" %>
	<h1>Administrator Log In</h1>
	<s:form action="adminLogin">
		<s:textfield name="email" placeholder="Email"></s:textfield>
		<s:password name="password" placeholder="Password"></s:password>
		<s:submit type="button" >Log In</s:submit>
	</s:form>
	
	<!-- WE DONT WANT ADMIN TO SELF REGISTER
	<s:form action="adminRegister">
		<s:textfield name="firstName" placeholder="First Name"></s:textfield>
		<s:textfield name="lastName" placeholder="Last Name"></s:textfield>
		<s:textfield name="email" placeholder="Email"></s:textfield>
		<s:password name="password" placeholder="Password"></s:password>
		<s:submit type="button">Register</s:submit>
	</s:form>
	-->
<%@ include file="footer.jsp" %>