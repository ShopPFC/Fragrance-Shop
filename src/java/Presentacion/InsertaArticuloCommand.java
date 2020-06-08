/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import ICommand.ICommand;
import BLL.ArticuloBLL;
import DAO.ConexionBD;
import Entidades.Articulo;
import java.sql.Connection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Javier
 */
public class InsertaArticuloCommand extends ICommand {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //System.out.println(request.getParameter("precio"));

        Articulo articulo = new Articulo();
        articulo.setId_articulo(request.getParameter("id_articulo"));
        articulo.setNombre(request.getParameter("nombre"));
        articulo.setDescripcion(request.getParameter("descripcion"));
        articulo.setPrecio(Integer.parseInt(request.getParameter("precio")));
        articulo.setImagen((String) request.getParameter("imagen"));
        System.out.println(request.getParameter("imagen"));

        ConexionBD conexionBD = new ConexionBD();
        Connection conexion = null;

        try {
            conexion = conexionBD.abrirConexion();
            conexion.setAutoCommit(false);

            ArticuloBLL articuloBLL = new ArticuloBLL();
            Articulo articulo_encontrado = articuloBLL.consultarId(articulo);
            
            Articulo listaId = articuloBLL.ultimoArt(articulo);
            request.setAttribute("articuloPasado", listaId);
            
            System.out.println(listaId);

            if (articulo_encontrado != null) {
                request.setAttribute("registroResultado", "Articulo ya registrado");
                request.setAttribute("redirectResultado", "");
            } else {

                articuloBLL.insertaArticulo(articulo);
                request.setAttribute("registroResultado", "Nuevo artículo insertado");
                request.setAttribute("redirectResultado", "Redirigiendo al Catálogo");
            }

        } catch (Exception e) {
            System.out.println("Error en insertar articulo" + e.getMessage());
            conexion.rollback();
            throw e;

        } finally {
            conexionBD.cerrarConexion(conexion);
        }

        return "/registroResultado.jsp";
    }
}
