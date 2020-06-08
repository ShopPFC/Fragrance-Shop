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
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Javier
 */
public class CarritoCommand extends ICommand {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Carrito carrito = new Carrito();
        Usuario usuario = new Usuario();
        usuario.setDni(request.getParameter("dni"));

        ConexionBD conexionBD = new ConexionBD();
        Connection conexion = null;

        try {
            conexion = conexionBD.abrirConexion();
            conexion.setAutoCommit(false);

            ArticuloBLL articuloBLL = new ArticuloBLL();
            CarritoBLL carritoBLL = new CarritoBLL();

            List<Carrito> listaCarrito = carritoBLL.mostrarCarrito(carrito, usuario);
            request.setAttribute("listaCarrito", listaCarrito);
            request.setAttribute("usuario", usuario);

        } catch (Exception e) {
            System.out.println(e);
            conexion.rollback();
            throw e;

        } finally {
            conexionBD.cerrarConexion(conexion);
        }

        return "/mostrarcarrito.jsp";
    }
}
