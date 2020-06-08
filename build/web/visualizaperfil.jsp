<%-- 
    Document   : visualizaperfil
    Created on : 31-may-2020, 13:51:27
    Author     : Javier
--%>

<%@page import="Entidades.Usuario"%>
<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv=”Content-Type” content=”text/html; charset=ISO-8859-1″ />
        <link rel="stylesheet" type="text/css" href="css/fila.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div  class="contenido" >
            <%
                Usuario usuarioEncontrado = (Usuario) request.getAttribute("usuarioencontrado");
            %>
            <div class="fila">
                <div>Dni: <%=usuarioEncontrado.getDni()%></div>
                <div>Nombre: <%=usuarioEncontrado.getNombre()%></div>
                <div>Apellidos: <%=usuarioEncontrado.getApellidos()%></div>
                <div>Email: <%=usuarioEncontrado.getEmail()%></div>
                <br><br>
                <a href="controller?opID=UsuarioRedirect">Modificar perfil</a>
            </div>
        </div>
    </body>
</html>
