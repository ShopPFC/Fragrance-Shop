<%@page import="Entidades.Articulo"%>
<%@page contentType="text/html; charset=UTF-8" %>
<%
    Articulo articuloPasado = (Articulo) request.getAttribute("articuloPasado");
    System.out.println(articuloPasado);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <meta http-equiv=”Content-Type” content=”text/html; charset=ISO-8859-1″ />
    </head>
    <div class="login-page">
        <div class="form">

            <form class="login-form" action="${ pageContext.request.contextPath}/Uploader" method="Post" encType="multipart/form-data">
                <input type="file"  name="file"/>
                <button>Añadir imagen</button>
            </form> 

        </div>
    </div>
</html>

