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
            <form class="register-form" action="" method="Post" id="search-theme-form2" name="formulario2">
                <h4>DNI: </h4><input type="text" name="dni" id="nick2" required="" autofocus="" placeholder="DNI"/>
                <h4>Nombre: </h4><input type="text" name="nombre" id="nombre" required="" autofocus="" placeholder="Nombre"/>
                <h4>Apellidos: </h4><input type="text" name="apellidos" id="apellidos" required="" autofocus="" placeholder="Apellidos"/>
                <h4>Email: </h4><input type="email" name="email" id="email" required="" autofocus="" placeholder="Email"/>
                <h4>Contraseña:</h4><input type="password" name="contrasenya" id="contraseña2" required="" autofocus="" placeholder="Contraseña"/>
                <div class="input-group-append">
                    <button id="show_password" class="btn btn-primary" type="button" onclick="mostrarPassword()"> <span class="fa fa-eye-slash icon2"></span> </button>
                </div>
                <button type="button" id="enviarReg">Registrarse</button>
            </form>
        </div>
    </div>

    <script type="text/javascript" src="./js/registro.js"></script>
</html>