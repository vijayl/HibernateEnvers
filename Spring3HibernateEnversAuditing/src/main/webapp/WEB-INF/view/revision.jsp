<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Revision</title>
</head>
<body>

<h2>Revisions of Employee</h2>


	<form:form method="post" action="getRevision" commandName="employee">
		<input type="hidden" value="${employeeId}" name="employeeId" />
		
		<c:if test="${!empty revisionList}">
			<table class="data">
				<tr>
					<th>Revision Num</th>
				</tr>
				<c:forEach items="${revisionList}" var="rev">
					<tr>
						<td><a href="${pageContext.request.contextPath}/getRevision/${rev}?employeeId=${employeeId}">Version ${rev}</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</form:form>
</body>
</html>