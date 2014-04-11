<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>BookStore</title>
	</head>
	<body>
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
		<p><a href="<s:url action="forgotPassword"/>">Forgotten your password?</a></p>
	</body>
</html>