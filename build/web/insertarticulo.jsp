<%@page import="java.util.List"%>
<%@page import="Entidades.Articulo"%>
<%@page contentType="text/html; charset=UTF-8" %>
<%
    String imagen = (String) request.getParameter("imagen");
    /*List<Articulo> listaArticulos = (List) request.getAttribute("articuloPasado");*/
    Articulo articuloPasado = (Articulo) request.getAttribute("articuloPasado");
    /*
    String convertedToString = articuloPasado.toString();
    Integer numero = Integer.parseInt(convertedToString);
    //Integer suma = numero + 1;
     */
    System.out.println(articuloPasado);
%>
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
            <form class="insert-form" action="controller?opID=InsertaArticulo&imagen=<%=imagen%>" id="search-theme-form3" name="formulario3" method="Post">
                <h4>ID: </h4><input type="text" name="id_articulo" id="artId" required="" autofocus="" value="<%=articuloPasado.getId_articulo()%>"/>
                <h4>Nombre: </h4><input type="text" name="nombre" id="artNombre" required="" autofocus=""/>
                <h4>Descripción: </h4><input type="text" name="descripcion" id="artDesc" required="" autofocus=""/>
                <h4>Precio: </h4><input type="text" name="precio" id="artPrecio" required=""  autofocus=""/>
                <br><br>
                <button type="button" id="enviarArt">Añadir</button>
            </form>
        </div>
    </div>

    <script type="text/javascript" src="./js/articulo.js"></script>
</html>
