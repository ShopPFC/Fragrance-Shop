<%-- 
    Document   : inicio
    Created on : 10-may-2020, 10:26:00
    Author     : Javier
--%>

<%@page import="Entidades.Usuario"%>
<%@page import="Entidades.Usuario"%>
<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <script>
        function myFunction() {
            var x = document.getElementById("myTopnav");
            if (x.className === "topnav") {
                x.className += " responsive";
            } else {
                x.className = "topnav";
            }
        }
    </script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta http-equiv=”Content-Type” content=”text/html; charset=ISO-8859-1″ />

        <%if ((String) request.getAttribute("paginaprincipal") == "/insertarticulo.jsp") {%>
        <title>Añadir un artículo nuevo</title>
        <%} else if ((String) request.getAttribute("paginaprincipal") == "/login.jsp") {%>
        <title>Inicia Sesión</title>
        <%} else if ((String) request.getAttribute("paginaprincipal") == "/mostrarcarrito.jsp") {%>
        <title>Carrito</title>
        <%} else if ((String) request.getAttribute("paginaprincipal") == "/registro.jsp") {%>
        <title>Registro</title>
        <%} else if ((String) request.getAttribute("paginaprincipal") == "/visualizapagina.jsp") {%>
        <title>Catálogo</title>
        <%} else if ((String) request.getAttribute("paginaprincipal") == "/enblanco.jsp") {%>
        <title>Inicio</title>
        <%} else if (request.getAttribute("paginaprincipal") == "/visualizapaginaSinLogin.jsp") {%>
        <title>Catálogo</title>
        <%} else if (request.getAttribute("paginaprincipal") == null) {%>
        <title>Inicio</title>
        <%}%>

        <link rel="icon" type="image/png" href="./img/favicon.png">
        <link rel="stylesheet" type="text/css" href="./css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="./css/bootstrap-grid.css">
        <link rel="stylesheet" type="text/css" href="./css/bootstrap-grid.min.css">
        <link rel="stylesheet" type="text/css" href="./css/bootstrap-reboot.css">
        <link rel="stylesheet" type="text/css" href="./css/bootstrap-reboot.min.css">
        <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">    
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="./css/estilo.css">

    </head>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript" src="./js/javascript.js"></script>

    <body>
        <header class="header">
            <img src="img/logo.png" class="logo"/>
            <div class="header-right">
                <% Usuario UsuarioConectado = (Usuario) request.getSession().getAttribute("usuarioSesion");
                    if (UsuarioConectado != null) {%>
                <span><img src="img/usuario.png" alt="Usuario">   Usuario:<%=UsuarioConectado.getNombre()%></span>
                    <%--<a href="controller?opID=Perfil"><span>Usuario: <%=UsuarioConectado.getNombre()%></span></a>--%>
                <a href="controller?opID=Logout"><img src="img/apagar.png" alt="Logout">   Desconectar</a>
                    <%} else {%>
                <a href="controller?opID=Login"><img src="img/sesion.png" alt="Sesion">   Iniciar Sesión</a>
                <a href="controller?opID=Registro"><img src="img/anadir.png" alt="Resgistro">   Registrarse</a><%}%>
            </div> 
        </header>

        <div class="topnav" id="myTopnav"><jsp:include page="menu.jsp"/></div>

        <div class="contenido">
            <%String paginaprincipal = (String) request.getAttribute("paginaprincipal");
                if (paginaprincipal != null) {%>
            <jsp:include page='<%=(String) request.getAttribute("paginaprincipal")%>'/>
            <%} else {%>
            <jsp:include page='enblanco.jsp'/>
            <%}%>

            <% String mensajeError = (String) request.getAttribute("mensajeError");
                if (mensajeError != null) {%>
            <jsp:include page='mensajeError.jsp'/>
            <%}%>
        </div>
        <footer>
            <a href="mailto:proyectopfc2020@hotmail.com"><img src="img/email.png" class="redes"/></a>
            <a href="https://www.instagram.com/fragrance_shoppfc/"><img src="img/instagram.png" class="redes"/></a>
        </footer>
    </body>
</html>
