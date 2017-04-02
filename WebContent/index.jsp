<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Sport Equipment Rental Shop</title>

<fmt:setLocale value="${sessionScope.local}" />

<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.locbutton.name.ru"
	var="ru_button" />
<fmt:message bundle="${loc}" key="local.locbutton.name.en"
	var="en_button" />

<fmt:message bundle="${loc}" key="local.welcome_message" var="welcome_message" />
<fmt:message bundle="${loc}" key="local.message_signin" var="sign_in" />
<fmt:message bundle="${loc}" key="local.message_name" var="name" />
<fmt:message bundle="${loc}" key="local.message_pass" var="pass" />
<fmt:message bundle="${loc}" key="local.signbutton.name"
	var="signin_button" />
<fmt:message bundle="${loc}" key="local.register.name" var="reg_button" />



</head>


<body>
	<c:out value="${welcome_message}" />

	<form action="Controller" method="post">

		<input type="hidden" name="page" value="index.jsp" /> <input
			type="hidden" name="command" value="localization" /> <input
			type="hidden" name="local" value="ru" /> <input type="submit"
			value="${ru_button}" /><br />
	</form>

	<form action="Controller" method="post">
		<input type="hidden" name="page" value="index.jsp" /> <input
			type="hidden" name="command" value="localization" /> <input
			type="hidden" name="local" value="en" /> <input type="submit"
			value="${en_button}" /><br />
	</form>

	<br />
	
	<form action="Controller" method="post">
		<c:out value="${sign_in}" />
		<input type="hidden" name="command" value="sign_in" /> <br />
		<c:out value="${name}" />
		<input type="text" name="login" value="" /> <br />
		<c:out value="${pass}" />
		<input type="password" name="password" value="" /> <br /> 
		<input type="submit" value="${signin_button}" /><br />
	</form>

	<form action="Controller" method="post">
		<input type="hidden" name="command" value="register_user" /> <br /> <input
			type="submit" value="${reg_button}" /><br />
	</form>

</body>

</html>