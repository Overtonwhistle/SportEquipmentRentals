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
	
	
	DONE!!!

</body>
</html>