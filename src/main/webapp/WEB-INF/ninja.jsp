<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>New Ninja</h1>
	<form:form action="/ninjas/create" method="post" modelAttribute="ninjas">
		<p>
			<form:select path="dojo">
				<c:forEach var="d" items="${dojos}">
					<option label ="${d.name}" value="${d.id}"/></option>
				</c:forEach>
			</form:select>
		</p>
		<p>
			<form:label path="firstName">First Name: </form:label>
			<form:input path="firstName"/>
			<form:errors path="firstName"/>
		</p>
		<p>
			<form:label path="lastName">Last Name: </form:label>
			<form:input path="lastName"/>
			<form:errors path="lastName"/>
		</p>
		<p>
			<form:label path="age">Age: </form:label>
			<form:input path="age"/>
			<form:errors path="age"/>
		</p>
		<input type="submit" value="Create">
	</form:form>
</body>
</html>