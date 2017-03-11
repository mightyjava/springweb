<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="label.users"/></title>
</head>
<body>
	<fieldset>
		<legend><spring:message code="label.users"/></legend>
		<table border="1">
			<thead>
				<tr>
					<td><spring:message code="label.user.id"/></td>
					<td><spring:message code="label.user.name"/></td>
					<td><spring:message code="label.action.edit"/></td>
					<td><spring:message code="label.action.delete"/></td>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${fn:length(users) > 0 }">
						<c:forEach items="${users}" var="user">
							<tr>
								<td>${user.userId}</td>
								<td>${user.userName}</td>
								<td>
									<a href="/springweb/user/edit/${user.id}">
										<spring:message code="label.action.edit"/>
									</a>
								</td>
								<td>
									<a href="/springweb/user/delete/${user.id}">
										<spring:message code="label.action.delete"/>
									</a>
								</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="4"><spring:message code="label.no.users" /></td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="4" align="right"><a href="/springweb/user/add">+ <spring:message code="label.user"/></a></td>
				</tr>
			</tfoot>
		</table>
	</fieldset>
</body>
</html>