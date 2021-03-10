<%--
    Document   : homeConseiller
    Created on : 3 mars 2021, 21:04:16
    Author     : Nathan Ghozlan
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="menuConseiller.jsp" %>
        
        <div class="container">
            <h1>Bonjour ${user.person.nom} !</h1>

           
        </div>
    </body>
</html>
