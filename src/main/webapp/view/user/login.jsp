<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="label.login"/></title>
</head>
<body>
	<spring:message code="placeholder.user.id" var="userIdPlaceholder"/>
	<spring:message code="placeholder.password" var="passwordPlaceholder"/>
	<fieldset>
		<legend><spring:message code="label.login"/></legend>
		<form:form action="/springweb/user/authenticate" commandName="userForm">
			<table>
				<tr> 
					<td><spring:message code="label.user.id"/></td>
					<td><form:input path="userId" placeholder="${userIdPlaceholder}"/></td>
				</tr>
				<tr>
					<td><spring:message code="label.password"/></td>
					<td><form:password path="password" placeholder="${passwordPlaceholder}"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="submit"><spring:message code="label.btn.login"/></button>
					</td>
				</tr>
			</table>
		</form:form>
	</fieldset>
</body>
</html>