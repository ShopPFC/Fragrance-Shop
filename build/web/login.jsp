<%@page import="Entidades.Usuario"%>
<%@page contentType="text/html; charset=UTF-8" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <meta http-equiv=”Content-Type” content=”text/html; charset=ISO-8859-1″ />
    </head>
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
            <form class="login-form"  method="Post" id="search-theme-form" name="formulario1">
                <h4>DNI: </h4><input type="text" name="dni" id="nick" required="" autofocus="" placeholder="DNI"/>    
                <h4>Contraseña: </h4><input type="password" name="contrasenya" id="contraseña1" required="" autofocus="" placeholder="Contraseña"/>
                <div class="input-group-append">
                    <button id="show_password" class="btn btn-primary" type="button" onclick="mostrarPasswordLogin()"> <span class="fa fa-eye-slash icon2"></span> </button>
                </div>
                <button type="button" id="enviar">Acceder</button>
            </form>
        </div>
    </div>

    <script type="text/javascript" src="./js/login.js"></script>
</html>
