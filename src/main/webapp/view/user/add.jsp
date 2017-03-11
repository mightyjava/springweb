<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="label.new.user"/></title>
</head>
<body>
	<spring:message code="placeholder.user.id" var="userIdPlaceholder"/>
	<spring:message code="placeholder.password" var="passwordPlaceholder"/>
	<spring:message code="placeholder.user.name" var="userNamePlaceholder"/>
	<fieldset>
		<legend><spring:message code="label.new.user"/></legend>
		<form:form action="/springweb/user/save" commandName="userForm">
			<form:hidden path="id" id="id" />
			<table>
				<tr> 
					<td><spring:message code="label.user.id"/></td>
					<td><form:input path="userId" placeholder="${userIdPlaceholder}"/></td>
				</tr>
				<tr> 
					<td><spring:message code="label.user.name"/></td>
					<td><form:input path="userName" placeholder="${userNamePlaceholder}"/></td>
				</tr>
				<tr>
					<td><spring:message code="label.password"/></td>
					<td><form:password path="password" placeholder="${passwordPlaceholder}"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="submit"><spring:message code="label.btn.save"/></button>
					</td>
				</tr>
			</table>
		</form:form>
	</fieldset>
</body>
</html>