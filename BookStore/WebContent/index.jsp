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
		<s:form id="register_form" action="register" theme="bootstrap">
			<div class="form-group">
				<s:textfield name="firstName" id="firstName" placeholder="First Name" cssClass="form-control" data-toggle="tooltip" data-placement="left" title="Please enter your first name"></s:textfield>
			</div>
			<div class="form-group">
				<s:textfield name="lastName" id="lastName" placeholder="Last Name" cssClass="form-control" data-toggle="tooltip" data-placement="left" title="Please enter your last name"></s:textfield>
			</div>
			<div class="form-group">
				<s:textfield name="email" id="reg-email" placeholder="Email" cssClass="form-control" data-toggle="tooltip" data-placement="left" title="Please enter a valid email"></s:textfield>
			</div>
			<div class="form-group">
				<s:password name="password" id="reg-password" placeholder="Password" cssClass="form-control" data-toggle="tooltip" data-placement="left" title="Please enter a password"></s:password>
			</div>
			<s:submit type="button" cssClass="btn btn-success">Register</s:submit>
		</s:form>
		<h2>Login</h2>
		<s:form action="login" theme="bootstrap">
			<div class="form-group">
				<s:textfield name="email" placeholder="Email" cssClass="form-control"></s:textfield>
			</div>
			<div class="form-group">
				<s:password name="password" placeholder="Password" cssClass="form-control"></s:password>
			</div>
			<p><a href="<s:url action="forgotPassword"/>">Forgotten your password?</a></p>
			<s:submit type="button" cssClass="btn btn-success"><span class="glyphicon glyphicon-log-in"></span>&nbsp;Log In</s:submit>
		</s:form>
	</body>
</html>