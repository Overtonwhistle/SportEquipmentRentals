<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Authorisation Error page</title>


<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.locbutton.name.ru"
	var="ru_button" />
<fmt:message bundle="${loc}" key="local.locbutton.name.en"
	var="en_button" />

<fmt:message bundle="${loc}" key="local.error.sign_in_error" var="error" />
<fmt:message bundle="${loc}" key="local.error.bad_login" var="bad_login" />
<fmt:message bundle="${loc}" key="local.error.bad_password" var="bad_password" />
<fmt:message bundle="${loc}" key="local.error.no_user" var="no_user" />


</head>

<!-- +++++++++++++++++++++++++++++++++++++++++++++ -->


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
	
	<!-- <input type="hidden" name="page" value="/WEB-INF/jsp/sign_in_error.jsp" /> -->
	<%-- <fmt:setLocale value="${sessionScope.local}" /> --%>

	<c:out value="${error}" />
	
	<c:out value="Sign in error: ${sessionScope.error_reason}" />
	
	<c:out value="${sessionScope.error_reason}" />



</body>
</html>