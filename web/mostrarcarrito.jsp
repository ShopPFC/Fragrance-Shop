<%-- 
    Document   : inicio
    Created on : 10-may-2020, 10:26:00
    Author     : Javier
--%>

<%@page import="Entidades.Carrito"%>
<%@page import="Entidades.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="Entidades.Articulo"%>
<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv=”Content-Type” content=”text/html; charset=ISO-8859-1″ />
        <title>JSP Page</title>
    </head>
    <link rel="stylesheet" type="text/css" href="./css/bootstrap.css">
    <body>

        <div class="column_carrito">
            <%
                List<Carrito> listaCarrito = (List) request.getAttribute("listaCarrito");

                Usuario usuarioSesion = (Usuario) request.getSession().getAttribute("usuarioSesion");

                for (int i = 0; i < listaCarrito.size(); i++) {
                    Carrito carrito = (Carrito) listaCarrito.get(i);

            %> 

            <div class="articulo">

                <img src="img/<%=carrito.getImagen()%>" class=""/>
                <h6><%=carrito.getNombre()%></h6>

                <div class="datos">
                    <h5><%=carrito.getPrecio()%>€</h5>
                </div>

                <a href="controller?opID=EliminarLineaCarrito&id_articulo=<%=carrito.getId_articulo()%>&dni=<%=carrito.getDni()%>" class="botonAñadir">Eliminar</a>

            </div>
            <%}%>
        </div>

        <%if (listaCarrito.isEmpty() == true) {%>
        <h5>El carrito está vacio</h5>

        <%if (usuarioSesion == null) {%>
        <a href="controller?opID=Login">Inicia sesión para ver tu carrito</a>

        <%} else {%>
        <a href="controller?opID=ControlPaginacion&numpagina=0">Comienza a añadir articulos al carrito</a>

        <%}
            }%>

    </body>
</html>
