<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="by.htp.shop.bean.User"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Page</title>

<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />

<fmt:message bundle="${loc}" key="local.locbutton.name.ru"
	var="ru_button" />
<fmt:message bundle="${loc}" key="local.locbutton.name.en"
	var="en_button" />
	
<fmt:message bundle="${loc}" key="local.welcome_admin"
	var="welcome_message" />	
<fmt:message bundle="${loc}" key="local.users_list_button.name"
	var="users_button" />



</head>

<body>
	<c:out value="${welcome_message}" />
	<!-- 	<input type="hidden" name="page" value="/WEB-INF/jsp/admin.jsp" /> -->
	
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="localization" /> <input
			type="hidden" name="local" value="ru" /> <input type="submit"
			value="${ru_button}" /><br />
	</form>
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="localization" /> 
		<input type="hidden" name="local" value="en" /> 
		<input type="submit" value="${en_button}" /><br />
	</form>

	<jsp:useBean id="user" class="by.htp.shop.bean.User" scope="request" />

	<div>
		<c:out value="${requestScope.user.name}" />
		<c:out value="${requestScope.user.surname}" />
	</div>

	<form action="Controller" method="post">
		<input type="hidden" name="command" value="goto_users_list" /> <br />
		<input type="submit" value="${users_button}" /><br />
	</form>

</body>
</html>