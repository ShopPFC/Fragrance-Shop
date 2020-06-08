<%@page import="Entidades.Usuario"%>
<%@page contentType="text/html; charset=UTF-8" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <meta http-equiv=”Content-Type” content=”text/html; charset=ISO-8859-1″ />
    </head>
    <%Usuario usuarioSesion = (Usuario) request.getSession().getAttribute("usuarioSesion");

        if (usuarioSesion == null) {%>
    <a href="controller?opID=Redireccion"><img src="img/belleza.png" alt="Inicio">   Inicio</a>
    <a href="controller?opID=ArticuloSinLogin&numpagina=0"><img src="img/catalogo.png" alt="Catalogo">   Catálogo</a>
    <a href="controller?opID=Carrito&dni=" class="carrito"><img src="img/cesta.png" alt="Carrito">   Carrito</a>
    <a href="javascript:void(0);" class="icon" onclick="myFunction()">
        <i class="fa fa-bars"></i>
    </a>
    <%} else {%>
    <a href="controller?opID=Redireccion"><img src="img/belleza.png" alt="Inicio">   Inicio</a>
    <a href="controller?opID=ControlPaginacion&numpagina=0"><img src="img/catalogo.png" alt="Catalogo">   Catálogo</a>
    <a href="controller?opID=Carrito&dni=<%=usuarioSesion.getDni()%>" class="carrito"><img src="img/cesta.png" alt="Carrito">   Carrito</a>
    <a href="controller?opID=Perfil&dni=<%=usuarioSesion.getDni()%>" class=""><img src="img/usuario.png" alt="Perfil">   Perfil</a>
    <%String dni = usuarioSesion.getDni();%>
    <%if (dni.equals("12345678A")) {%>
    <a href="controller?opID=ArticuloRedirectSecond" class=""><img src="img/mas.png" alt="Mas">   Añadir nuevo articulo</a>
    <%}%>
    <a href="javascript:void(0);" class="icon" onclick="myFunction()">
        <i class="fa fa-bars"></i>
    </a>
    <%}%>
</html>
