<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="label.home"/></title>
</head>
<body>
	<spring:message code="label.home"/>
	<br />
	<a href="/springweb/user/list"><spring:message code="label.list"/></a>
	<br />
	<a href="/springweb/user/add"><spring:message code="label.action.add"/></a>
	<br /> 
	<a href="/springweb/job/launch/executeTasklet" target="_blank"><spring:message code="label.execute.manually"/></a>
</body>
</html>