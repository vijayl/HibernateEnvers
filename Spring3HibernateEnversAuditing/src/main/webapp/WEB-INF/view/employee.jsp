<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Update Employee</h2>


<form:form method="post" action="update" commandName="employee">
	
	 <input type="hidden" value="${employee.id}" name="id" />

	 <table>
	    <tr>
	        <td><form:label path="firstname"><spring:message code="label.firstname"/></form:label></td>
	        <td><form:input path="firstname" /></td>
	    </tr>
	    <tr>
	        <td><form:label path="lastname"><spring:message code="label.lastname"/></form:label></td>
	        <td><form:input path="lastname" /></td>
	    </tr>
	    <tr>
	        <td><form:label path="email"><spring:message code="label.email"/></form:label></td>
	        <td><form:input path="email" /></td>
	    </tr>
	    <tr>
	        <td><form:label path="telephone"><spring:message code="label.telephone"/></form:label></td>
	        <td><form:input path="telephone" /></td>
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