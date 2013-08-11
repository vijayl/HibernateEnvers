<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project page</title>
</head>
<body>

<h2>Add Project to Employee</h2>


<form:form method="post" action="${pageContext.request.contextPath}/addProject" commandName="project">
	
	 <input type="hidden" value="${employeeId}" name="employeeId" />

	 <table>
	    <tr>
	        <td><form:label path="name"><spring:message code="label.name"/></form:label></td>
	        <td><form:input path="name" /></td>
	    </tr>
	    <tr>
	        <td><form:label path="desc"><spring:message code="label.desc"/></form:label></td>
	        <td><form:input path="desc" /></td>
	    </tr>

	    <tr>
	        <td colspan="2">
	            <input type="submit" value="<spring:message code="label.update"/>"/>
	        </td>
	    </tr>
	</table>
</form:form>


</body>
</html>