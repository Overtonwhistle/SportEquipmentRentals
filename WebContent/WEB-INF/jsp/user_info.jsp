<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="by.htp.shop.bean.User"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users Info Page</title>

<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.locbutton.name.ru"
	var="ru_button" />
<fmt:message bundle="${loc}" key="local.locbutton.name.en"
	var="en_button" />

<fmt:message bundle="${loc}" key="local.user_descr" var="personal_data" />



<fmt:message bundle="${loc}" key="local.user_id" var="id" />
<fmt:message bundle="${loc}" key="local.user_role" var="role" />
<fmt:message bundle="${loc}" key="local.user_name" var="name" />
<fmt:message bundle="${loc}" key="local.user_surname" var="surname" />
<fmt:message bundle="${loc}" key="local.user_address" var="address" />
<fmt:message bundle="${loc}" key="local.user_phone" var="phone" />
<fmt:message bundle="${loc}" key="local.user_email" var="email" />
<fmt:message bundle="${loc}" key="local.user_login" var="login" />
<fmt:message bundle="${loc}" key="local.user_password" var="password" />







</head>

<body>
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
		<c:out value="${personal_data}" />
		<table>
			<tr>
				<td><c:out value="${id}" /></td>
				<td><c:out value="${role}" /></td>
				<td><c:out value="${name}" /></td>
				<td><c:out value="${surname}" /></td>
				<td><c:out value="${address}" /></td>
				<td><c:out value="${phone}" /></td>
				<td><c:out value="${email}" /></td>
			</tr>
			<tr>
				<td><c:out value="${user.id}" /></td>
				<td><c:out value="${user.role}" /></td>
				<td><c:out value="${user.name}" /></td>
				<td><c:out value="${user.surname}" /></td>
				<td><c:out value="${user.address}" /></td>
				<td><c:out value="${user.phone}" /></td>
				<td><c:out value="${user.email}" /></td>
			</tr>
		</table>
	</div>

	
</body>
</html>