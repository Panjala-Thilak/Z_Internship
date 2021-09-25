<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Customer Confirmation</title>
</head>
<body>

<h1>Welcome :${customer.firstName} ${customer.lastName } </h1>
<br><br>
free Passes : ${customer.freePasses}
<br><br>
postal code : ${customer.postalCode}
<br><br>
Course code : ${customer.courseCode}
</body>

</html>