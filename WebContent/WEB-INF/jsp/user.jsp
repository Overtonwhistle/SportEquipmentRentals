<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="by.htp.shop.bean.User"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Page</title>

<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />

<fmt:message bundle="${loc}" key="local.locbutton.name.ru"
	var="ru_button" />
<fmt:message bundle="${loc}" key="local.locbutton.name.en"
	var="en_button" />


<fmt:message bundle="${loc}" key="local.welcome_user"
	var="welcome_message" />
<fmt:message bundle="${loc}" key="local.account_info.name" var="account" />
<fmt:message bundle="${loc}" key="local.user_rented_list.name" var="my_units" />
<fmt:message bundle="${loc}" key="local.user_rent_unit.name" var="take_unit" />
<fmt:message bundle="${loc}" key="local.user_return_unit.name" var="return_unit" />
<fmt:message bundle="${loc}" key="local.user_return_all.name" var="return_all" />





</head>
<body>
	<c:out value="${welcome_message}" />
	<!-- <input type="hidden" name="page" value="/WEB-INF/jsp/user.jsp" /> -->
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="localization" /> <input
			type="hidden" name="local" value="ru" /> <input type="submit"
			value="${ru_button}" /><br />
	</form>
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="localization" /> <input
			type="hidden" name="local" value="en" /> <input type="submit"
			value="${en_button}" /><br />
	</form>

	<div>
		<c:out value="${user.name}" />
		<c:out value="${user.surname}" />
	</div>


	<form action="Controller" method="post">
		<input type="hidden" name="command" value="goto_user_info" /> <br /> <input
			type="submit" value="${account}" /><br />
	</form>
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="my_units" /> <br /> <input
			type="submit" value="${my_units}" /><br />
	</form>
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="take_unit" /> <br /> <input
			type="submit" value="${take_unit}" /><br />
	</form>
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="return_unit" /> <br /> <input
			type="submit" value="${return_unit}" /><br />
	</form>
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="return_all" /> <br /> <input
			type="submit" value="${return_all}" /><br />
	</form>

</body>
</html>