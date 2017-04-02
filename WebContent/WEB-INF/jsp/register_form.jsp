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


<fmt:message bundle="${loc}" key="local.new_user_register"
	var="reg_description" />
<fmt:message bundle="${loc}" key="local.new_user_reqfields"
	var="fields_hint" />

<fmt:message bundle="${loc}" key="local.user_name" var="name" />
<fmt:message bundle="${loc}" key="local.user_surname" var="surname" />
<fmt:message bundle="${loc}" key="local.user_address" var="address" />
<fmt:message bundle="${loc}" key="local.user_phone" var="phone" />
<fmt:message bundle="${loc}" key="local.user_email" var="email" />
<fmt:message bundle="${loc}" key="local.user_login" var="login" />
<fmt:message bundle="${loc}" key="local.user_password" var="password" />

<fmt:message bundle="${loc}" key="local.new_user_emp_name"
	var="err_name" />
<fmt:message bundle="${loc}" key="local.new_user_emp_surname"
	var="err_surname" />
<fmt:message bundle="${loc}" key="local.new_user_inc_email"
	var="err_email" />
<fmt:message bundle="${loc}" key="local.new_user_inc_phone"
	var="err_phone" />
<fmt:message bundle="${loc}" key="local.new_user_inc_login"
	var="err_login" />
<fmt:message bundle="${loc}" key="local.new_user_inc_password"
	var="err_password" />
<fmt:message bundle="${loc}" key="local.new_user_login_exist"
	var="ex_login" />



<fmt:message bundle="${loc}" key="local.new_user_loginspec"
	var="login_spec" />

<fmt:message bundle="${loc}" key="local.new_user_passwordspec"
	var="password_spec" />

<fmt:message bundle="${loc}" key="local.new_user_phonespec"
	var="ph_spec" />

<fmt:message bundle="${loc}" key="local.new_user_reg_name" var="do_reg" />





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



		<c:out value="${reg_description}" />
		<br />
		<c:out value="${fields_hint}" />
		<br />

		<form action="Controller" method="post">


			<c:out value="${name}*" />
			<input type="text" name="name" value="${user.name}" /> <br />

			<c:out value="${surname}*" />
			<input type="text" name="surname" value="${user.surname}" /> <br />

			<c:out value="${address}" />
			<input type="text" name="address" value="${user.address}" /> <br />

			<c:out value="${phone}" />
			<input type="text" name="phone" value="${user.phone}" />
			<c:out value="${ph_spec}" />
			<br />

			<c:out value="${email}" />
			<input type="text" name="email" value="${user.email}" /> <br />

			<c:out value="${login}*" />
			<input type="text" name="login" value="${user.login}" />
			<c:out value="${login_spec}" />
			<br />

			<c:out value="${password}*" />
			<input type="text" name="password" value="${user.password}" />
			<c:out value="${password_spec}" />
			<br /> <input type="hidden" name="command" value="reg_process" /> <br />
			<input type="submit" value="${do_reg}" /><br />
		</form>


		<c:if test="${requestScope.err_name eq true}">
			<c:out value="${err_name}*" />
			<br />
		</c:if>

		<c:if test="${requestScope.err_surname eq true}">
			<c:out value="${err_surname}*" />
			<br />
		</c:if>

		<c:if test="${requestScope.err_login eq true}">
			<c:out value="${err_login}*" />
			<br />
		</c:if>

		<c:if test="${requestScope.err_password eq true}">
			<c:out value="${err_password}*" />
			<br />
		</c:if>

		<c:if test="${requestScope.err_phone eq true}">
			<c:out value="${err_phone}*" />
			<br />
		</c:if>
		
		<c:if test="${requestScope.err_email eq true}">
			<c:out value="${err_email}*" />
			<br />
		</c:if>
		
		<c:if test="${requestScope.ex_login eq true}">
			<c:out value="${ex_login}*" />
			<br />
		</c:if>
		
		




	</div>

</body>
</html>