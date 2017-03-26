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

<fmt:message bundle="${loc}" key="local.users_list_descr"
	var="list_description" />
<fmt:message bundle="${loc}" key="local.add_user_name" var="add" />
<fmt:message bundle="${loc}" key="local.edit_user_name" var="edit" />
<fmt:message bundle="${loc}" key="local.delete_user_name" var="delete" />

<fmt:message bundle="${loc}" key="local.user_name" var="name" />
<fmt:message bundle="${loc}" key="local.user_surname" var="surname" />


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
		<c:out value="${list_description}" />
		<table>
			<tr>
				<td><c:out value="id." /></td>
				<td><c:out value="${name}" /></td>
				<td><c:out value="${surname}" /></td>
			</tr>
			<c:forEach items="${requestScope.list}" var="user">
				<tr>
					<td><c:out value="${user.id}" /></td>
					<td><c:out value="${user.name}" /></td>
					<td><c:out value="${user.surname}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div>
		<form action="Controller" method="post">
			<input type="hidden" name="command" value="add_user" /> <br /> <input
				type="submit" value="${add}" /><br />
		</form>
		<form action="Controller" method="post">
			<input type="hidden" name="command" value="edit_user" /> <br /> <input
				type="submit" value="${edit}" /><br />
		</form>
		<form action="Controller" method="post">
			<input type="hidden" name="command" value="delete_user" /> <br /> <input
				type="submit" value="${delete}" /><br />
		</form>
	</div>

</body>
</html>