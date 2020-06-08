/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import ICommand.ICommand;
import BLL.ArticuloBLL;
import DAO.ConexionBD;
import Entidades.Carrito;
import Entidades.Articulo;
import Entidades.Usuario;
import java.sql.Connection;
import java.util.Scanner;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Javier
 */
public class EliminarLineaCarritoCommand extends ICommand {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Usuario usuario = new Usuario();
        Carrito carrito = new Carrito();

        carrito.setId_articulo(request.getParameter("id_articulo"));
        usuario.setDni(request.getParameter("dni"));

        ConexionBD conexionBD = new ConexionBD();
        Connection conexion = null;

        try {

            conexion = conexionBD.abrirConexion();
            conexion.setAutoCommit(false);

            ArticuloBLL articuloBLL = new ArticuloBLL();

            articuloBLL.borrarLineaBLL(carrito, usuario);

            request.setAttribute("registroResultado", "Se ha eliminado del carrito");
            request.setAttribute("redirectResultado", "Redirigiendo al Carrito");

        } catch (Exception e) {
            System.out.println("Error al eliminar línea carrito " + e.getMessage());
            conexion.rollback();
            throw e;

        } finally {
            conexionBD.cerrarConexion(conexion);
        }

        return "/registroResultado.jsp";
    }
}
