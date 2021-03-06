<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Custom form</title>

        <style>
            .failed{
            color:red;
            }
        </style>
    </head>

    <body>
        <h1>My Custom Login Page</h1>
        <form:form action="${pageContext.request.contextPath}/authenticateTheUser"
                    method="POST">
        <c:if test="${param.error!=null}">
            <h2><i class="failed">Sorry! You entered invalid credentials</i></h2>
        </c:if>
                    <p>
                        User name:<input type="text" name="username"/>
                    </p>
                    <p>
                         Password:<input type="text" name="password"/>
                    </p>
                    <input type="submit" value="Login"/>
        </form:form>
    </body>
</html>