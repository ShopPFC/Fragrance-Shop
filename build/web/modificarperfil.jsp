<%-- 
    Document   : modificarperfil
    Created on : 03-jun-2020, 12:01:09
    Author     : Javier
--%>

<%@page import="Entidades.Usuario"%>
<%@page contentType="text/html; charset=UTF-8" %>
<%
    Usuario usuarioConectado = (Usuario) request.getSession().getAttribute("usuarioSesion");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <meta http-equiv=”Content-Type” content=”text/html; charset=ISO-8859-1″ />
    </head>
    <body>
        <div id="dialogoverlay"></div>
        <div id="dialogbox">
            <div>
                <div id="dialogboxhead"></div>
                <div id="dialogboxbody"></div>
                <div id="dialogboxfoot"></div>
            </div>
        </div> 

        <div class="login-page">
            <div class="form">
                <form class="register-form" action="" method="Post" id="search-theme-form4" name="formulario4">
                    <h4>DNI: </h4><input type="text" name="dni" id="nick3" required="" autofocus="" placeholder="DNI" value="<%=usuarioConectado.getDni()%>" readonly/>
                    <h4>Nombre: </h4><input type="text" name="nombre" id="nombre2" required="" autofocus="" placeholder="Nombre" value="<%=usuarioConectado.getNombre()%>" />
                    <h4>Apellidos: </h4><input type="text" name="apellidos" id="apellidos2" required="" autofocus="" placeholder="Apellidos" value="<%=usuarioConectado.getApellidos()%>" />
                    <h4>Email: </h4><input type="email" name="email" id="email2" required="" autofocus="" placeholder="Email" value="<%=usuarioConectado.getEmail()%>"/>
                    <h4>Contraseña: </h4><input type="password" name="contrasenya" id="contraseña3" required="" autofocus="" placeholder="Contraseña" value="<%=usuarioConectado.getContrasenya()%>"/>
                    <div class="input-group-append">
                        <button id="show_password" class="btn btn-primary" type="button" onclick="mostrarPassword2()"> <span class="fa fa-eye-slash icon2"></span> </button>
                    </div>
                    <%--<button type="button" id="enviarPerfil">Guardar</button> --%>
                    <button type="button" id="guardarPerfil">Guardar</button>
                    <button type="button" id="cancelarPerfil">Cancelar</button>
                </form>
            </div>
        </div>

        <script type="text/javascript" src="./js/perfil.js"></script>
    </body>
</html>
