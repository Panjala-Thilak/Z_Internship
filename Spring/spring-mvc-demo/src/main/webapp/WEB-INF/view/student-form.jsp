<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>Student Registration Form</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
	First Name: <form:input path="firstName"/>
	<br><br>
	Last Name: <form:input path="lastName"/>
	<br><br>
	
	<form:select path="country">
		<form:options items="${student.countryOptions}"/>
	</form:select>
	
	<br><br>
	
	Java <form:radiobutton path="favLang" value="Java"/>
	C#<form:radiobutton path="favLang" value="C#"/>
	python<form:radiobutton path="favLang" value="Python"/>
	<br><br>
	Linux<form:checkbox path="operatingSystems" value="Linux"/>
	Mac OS<form:checkbox path="operatingSystems" value="MAC OS"/>
	Windows<form:checkbox path="operatingSystems" value="Windows"/>
	
	<br><br>
	<input type="submit" value="Submit"/>
	</form:form>
</body>

</html>