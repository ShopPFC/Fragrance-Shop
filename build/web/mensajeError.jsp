W<%-- 
    Document   : inicio
    Created on : 10-may-2020, 10:26:00
    Author     : Javier
--%>

<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta http-equiv=”Content-Type” content=”text/html; charset=ISO-8859-1″ />
        <title>JSP Page</title>
    </head>
    <link rel="stylesheet" type="text/css" href="./css/bootstrap.css">
    <body>
        <h1> <%=request.getAttribute("mensajeError")%></h1>
    </body>
</html>