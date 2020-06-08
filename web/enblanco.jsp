<%-- 
    Document   : inicio
    Created on : 10-may-2020, 10:26:00
    Author     : Javier
--%>

<%@page import="Entidades.Articulo"%>
<%@page import="Entidades.Usuario"%>
<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta http-equiv=”Content-Type” content=”text/html; charset=ISO-8859-1″ />
        <link rel="stylesheet" type="text/css" href="./css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="./css/bootstrap-grid.css">
        <link rel="stylesheet" type="text/css" href="./css/bootstrap-grid.min.css">
        <link rel="stylesheet" type="text/css" href="./css/bootstrap-reboot.css">
        <link rel="stylesheet" type="text/css" href="./css/bootstrap-reboot.min.css">
        <link rel="stylesheet" type="text/css" href="./css/estilo.css">
        <link rel="stylesheet" type="text/css" href="./css/slider.css">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">    
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <script src="./js/slider.js"></script>
        <title>JSP Page</title>
    </head>
    <!-- Slider -->
    <div class="all">
        <div class="container-all">

            <input type="radio" id="1" name="image-slide" hidden/>
            <input type="radio" id="2" name="image-slide" hidden/>
            <input type="radio" id="3" name="image-slide" hidden/>
            <input type="radio" id="4" name="image-slide" hidden/>

            <div class="slide">

                <div class="item-slide">
                   <img src="img/idole.jpg">
                </div>

                <div class="item-slide">
                    <img src="img/one_million.jpg">
                </div>
                
                <div class="item-slide">
                    <img src="img/millenaire.jpg">
                </div>
                
                <div class="item-slide">
                    <img src="img/la_vie_est_belle.jpg">
                </div>
                    
            </div>

            <div class="paginationImg">

                <label class="pagination-item" for="2">
                    <img src="img/idole.jpg">
                </label>

                <label class="pagination-item" for="3">
                    <img src="img/one_million.jpg">
                </label>
                
                <label class="pagination-item" for="4">
                    <img src="img/millenaire.jpg">
                </label>
                <label class="pagination-item" for="4">
                    <img src="img/la_vie_est_belle.jpg">
                </label>
                

            </div>
        </div>
    </div>
    <div class="descripcionInicio">
        Somos una perfumería especializada en la venta de perfumes, cosmética, maquillaje y aseo personal. Disponemos de un amplio catálogo de los productos más innovadores y las mejores marcas del mercado. Nuestro objetivo es ofrecer el mejor asesoramiento a nuestros clientes en el cuidado de su imagen y la mejor experiencia de compra gracias a la profesionalidad, formación y atención de nuestro personal. Compra tus perfumes online durante las 24 horas.Fragrance-shop, como distribuidor oficial, te ofrece más de 15.000 productos originales de perfumería femenina y masculina, colonias y fragancias para niños.
    </div> 
</html>
