<%-- 
    Document   : inicio
    Created on : 10-may-2020, 10:26:00
    Author     : Javier
--%>

<%@page import="Entidades.Articulo"%>
<%@page import="Entidades.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html; charset=UTF-8" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <meta http-equiv=”Content-Type” content=”text/html; charset=ISO-8859-1″ />
    </head>
    <%
        int numeroPagina = ((Integer) request.getSession().getAttribute("actualpagina")).intValue();
        Usuario usuarioSesion = (Usuario) request.getSession().getAttribute("usuarioSesion");
        int totalPaginas = ((Integer) request.getAttribute("totalpaginas")).intValue();
    %>
    <div class="column">
        <%
            List<Articulo> listaArticulo = (List) request.getAttribute("listaguardada");
            for (int i = 0; i < listaArticulo.size(); i++) {
                Articulo articulo = (Articulo) listaArticulo.get(i);

        %>  

        <div class="articulo">
            <img src="img/<%=articulo.getImagen()%>"/> 
            <h6><%=articulo.getNombre()%> - <%=articulo.getPrecio()%>€</h6>
            <div class="datos">
                <span>Descripción: <%=articulo.getDescripcion()%></span>
            </div>
            <a href="controller?opID=Login" class="botonAñadir">Iniciar sesión para añadir</a>

        </div>
        <% }%>
    </div>
    <div class="paginacion">
        <%
            if (numeroPagina > 1) {
        %>      

        <a href ="controller?opID=ArticuloSinLogin&numpagina=-2"> << </a>
        <a href ="controller?opID=ArticuloSinLogin&numpagina=-1"> < </a>
        <% }%>

        <%
            for (int i = 1; i <= totalPaginas; i++) {
        %>
        <a href="controller?opID=ArticuloSinLogin&numpagina=<%=i%>"><%=i%></a>
        <%}%>

        <%
            if (numeroPagina < totalPaginas) {
        %> 

        <a href ="controller?opID=ArticuloSinLogin&numpagina=-3"> > </a>
        <a href ="controller?opID=ArticuloSinLogin&numpagina=-4"> >> </a>
        <% }%>
        <br><br><br>

    </div>
</html>

