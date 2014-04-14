<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BookStore</title>
</head>
<body>
<ul>
	<s:if test="%{customer!=null}">
		<li>Hi, ${customer.firstName}&nbsp;${customer.lastName}&nbsp;<a href="<s:url action="logout"/>">Logout</a></li>
		<li><a href="<s:url action="viewCart"/>">Shopping Cart</a></li>
	</s:if>
	<s:elseif test="%{admin!=null}">
		<li>Hi, ${admin.firstName}&nbsp;${admin.lastName}&nbsp;(Admin)&nbsp;<a href="<s:url action="logout"/>">Logout</a></li>
		<li><a href="<s:url action="dashboard"/>">Admin Dashboard</a></li>
	</s:elseif>
	<s:else>
		<li>Welcome Guest,&nbsp;<a href="<s:url action="signin"/>">Sign In</a></li>
	</s:else>
	<li><a href="<s:url action="shopHome"/>">Shop Home</a></li>
</ul>