<%-- 
    Document   : visualizafila
    Created on : 30-may-2020, 19:07:41
    Author     : Javier
--%>

<%@page import="Entidades.Articulo"%>
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
        <div  class="fila" >
            <%
                Articulo articuloEncontrado = (Articulo) request.getAttribute("articuloencontrado");
            %>
            <div class="fila">
                <br>
                <img src="img/<%=articuloEncontrado.getImagen()%>">
                <br>
                <%--<div>Id: <%=articuloEncontrado.getId_articulo()%></div>--%>
                <div>Nombre: <%=articuloEncontrado.getNombre()%></div>
                <div>Descripción: <%=articuloEncontrado.getDescripcion()%></div>
                <div>Precio: <%=articuloEncontrado.getPrecio()%>€</div>
                <div>Stock: <%=articuloEncontrado.getStock()%></div>
                <br><br>
                <a href="controller?opID=ControlPaginacion&numpagina=-5">Volver al Catálogo</a>
            </div>
        </div>
    </body>
</html>
