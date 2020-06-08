<%@page import="Entidades.Articulo"%>
<%@page import="Entidades.Usuario"%>
<%@page contentType="text/html; charset=UTF-8" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <meta http-equiv=”Content-Type” content=”text/html; charset=ISO-8859-1″ />

        <%String pagina = request.getParameter("opID");
            String paginacion = request.getParameter("numpagina");
            Usuario usuarioSesion = (Usuario) request.getSession().getAttribute("usuarioSesion");
            Articulo articuloSesion = (Articulo) request.getSession().getAttribute("articuloSesion");

            if (pagina.equals("InsertaUsuario")) {%>
        <meta http-equiv = "refresh" content = "1; url = /VentaArticulos/controller?opID=Login" />
        <%}%>

        <%if (pagina.equals("InsertarLineaCarrito")) {%>
        <meta http-equiv = "refresh" content = "1; url = /VentaArticulos/controller?opID=ControlPaginacion&numpagina=<%=paginacion%>" />
        <%}%>

        <%if (pagina.equals("EliminarLineaCarrito")) {%>
        <meta http-equiv = "refresh" content = "1; url = /VentaArticulos/controller?opID=Carrito&dni=<%=usuarioSesion.getDni()%>" />
        <%}%>

        <%if (pagina.equals("InsertaArticulo")) {%>
        <%-- <meta http-equiv = "refresh" content = "1; url = /VentaArticulos/controller?opID=ArticuloRedirectSecond" />--%>
        <meta http-equiv = "refresh" content = "1; url = /VentaArticulos/controller?opID=ControlPaginacion&numpagina=<%=0%>" />
        <%}%>

        <%if (pagina.equals("ModificarUsuario")) {%>
        <%-- <meta http-equiv = "refresh" content = "1; url = /VentaArticulos/controller?opID=ArticuloRedirectSecond" />--%>
        <meta http-equiv = "refresh" content = "1; url = /VentaArticulos/controller?opID=Perfil&dni=<%=usuarioSesion.getDni()%>" />
        <%}%>

    </head>
    <link rel="stylesheet" type="text/css" href="./css/bootstrap.css">
    <div class="login-page">
        <div class="form">   
            <form class="login-form"  method="Post" id="search-theme-form" name="formulario1">
                <h1> <%=request.getAttribute("registroResultado")%></h1>
                <h4> <%=request.getAttribute("redirectResultado")%></h4>
            </form>
        </div>
    </div>
</html>
