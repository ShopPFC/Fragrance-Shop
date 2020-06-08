/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import ICommand.ICommand;
import BLL.ArticuloBLL;
import BLL.CarritoBLL;
import DAO.ConexionBD;
import Entidades.Carrito;
import Entidades.Usuario;
import Entidades.Articulo;
import java.sql.Connection;
import java.util.Scanner;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Javier
 */
public class InsertarLineaCarritoCommand extends ICommand {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Usuario usuario = new Usuario();
        Carrito carrito = new Carrito();
        
        carrito.setId_articulo(request.getParameter("id_articulo"));
        carrito.setDni((String) request.getParameter("dni"));
        carrito.setUnidades(Integer.parseInt(request.getParameter("unidades")));
        carrito.setNombre((String) request.getParameter("nombre"));
        carrito.setPrecio(Integer.parseInt(request.getParameter("precio")));
        carrito.setImagen((String) request.getParameter("imagen"));
        
        usuario.setDni((String) request.getParameter("dni"));

        ConexionBD conexionBD = new ConexionBD();
        Connection conexion = null;

        try {

            conexion = conexionBD.abrirConexion();
            conexion.setAutoCommit(false);

            ArticuloBLL articulosBLL = new ArticuloBLL();
            CarritoBLL carritoBLL = new CarritoBLL();

            carritoBLL.nuevaLineaBll(carrito, usuario);

            request.setAttribute("registroResultado", "Añadido al carrito");
            request.setAttribute("redirectResultado", "Redirigiendo al Catálogo");

        } catch (Exception e) {
            conexion.rollback();
            System.out.println("Error insertarLineaCarro " + e.getMessage());
            throw e;

        } finally {
            conexionBD.cerrarConexion(conexion);
        }

        return "/registroResultado.jsp";
    }
}
