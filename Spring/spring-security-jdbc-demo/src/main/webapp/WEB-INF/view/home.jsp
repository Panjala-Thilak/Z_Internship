<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<html>
<head>
    <title>Home Page</title>
<head>
<body>
    <h2>Home Page</h2>
    <hr>
    Welcome to the Home Page!!

    <p>
        User:<security:authentication property="principal.username"/>
        <br><br>
        Role(s):<security:authentication property="principal.authorities"/>

       <hr>
       <!--Link to leaders --Managers -->
       <security:authorize access="hasRole('MANAGER')">
       <p>
            <a href="${pageContext.request.contextPath}/leaders">Leadership App</a>
            (Only for Managers )

       </p>
       <hr>
       </security:authorize>

        <security:authorize access="hasRole('ADMIN')">
              <!--Link to ADMINS --Managers -->
              <p>
                   <a href="${pageContext.request.contextPath}/systems">Admins App</a>
                   (Only for Admins )

              </p>
        </security:authorize>
    </p>

    <form:form action="${pageContext.request.contextPath}/logout" method="POST">
        <input type="submit" value="Logout"/>
    </form:form>

</body>
</html>