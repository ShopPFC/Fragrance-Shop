/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.CarritoDAO;
import DAO.ConexionBD;
import DAO.ArticuloDAO;
import DAO.UsuarioDAO;
import Entidades.Carrito;
import Entidades.Usuario;
import Entidades.Articulo;
import Excepciones.MiExcepcion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Javier
 */
public class CarritoBLL {

    public List<Carrito> mostrarCarrito(Carrito carrito, Usuario usuario) throws Exception {

        ConexionBD conexionBD = new ConexionBD();
        Connection conexion = null;

        List<Carrito> listaCarrito = null;
        Object[] miObjeto = new Object[3];

        ArticuloDAO articuloDAO = new ArticuloDAO();
        CarritoDAO carritoDAO = new CarritoDAO();

        Carrito carritoUni = new Carrito();

        try {

            //Abrir conexion
            conexion = conexionBD.abrirConexion();

            conexion.setAutoCommit(false);

            //Consultando el dni del usuario
            //Consultando articulo por referencia
            listaCarrito = carritoDAO.mostrarCarrito(conexion, usuario);

            for (int i = 0; i < listaCarrito.size(); i++) {
                carritoUni = listaCarrito.get(i);
                miObjeto[0] = carritoUni.getDni();
                miObjeto[1] = carritoUni.getId_articulo();
                miObjeto[2] = carritoUni.getUnidades();
            }

            carritoDAO.mostrarCarrito(conexion, usuario);

            conexion.commit();
        } catch (Exception e) {

            if (conexion != null) {
                conexion.rollback();
            }
            throw e;

        } finally {
            //Cerrar conexion
            conexionBD.cerrarConexion(conexion);
        }

        return listaCarrito;
    }

    public Object[] nuevaLineaBll(Carrito carrito, Usuario usuarioT) throws Exception {

        ConexionBD conexionBD = new ConexionBD();
        Connection conexion = null;

        List<Carrito> listaCarrito = null;
        Object[] miObjeto = new Object[5];

        ArticuloDAO articuloDAO = new ArticuloDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        CarritoDAO carritoDAO = new CarritoDAO();

        Carrito carritoUni = new Carrito();

        try {

            //Abrir conexion
            conexion = conexionBD.abrirConexion();

            conexion.setAutoCommit(false);

            //Consultando el dni del usuario
            Usuario usuario = new Usuario();
            usuario = usuarioDAO.consultarDni(conexion, usuario);

            //Consultando articulo por referencia
            Articulo articulo = new Articulo();

            articulo = articuloDAO.articulosPorReferen(conexion, carrito);

            listaCarrito = carritoDAO.mostrarCarrito(conexion, usuarioT);

            for (int i = 0; i < listaCarrito.size(); i++) {

                carritoUni = listaCarrito.get(i);
                miObjeto[0] = carritoUni.getDni();
                miObjeto[1] = carritoUni.getId_articulo();
                miObjeto[2] = carritoUni.getUnidades();
                miObjeto[3] = carritoUni.getNombre();
                miObjeto[4] = carritoUni.getPrecio();
            }

            //--------------------------------------------------------------------------   
            if (articulo.getStock() == 0) {
                throw new Exception("No hay articulos en carritoBLL");

            }
            carritoDAO.insertarFila(conexion, carrito);
            carritoDAO.actualizarStock(conexion, carrito);

            conexion.commit();
        } catch (Exception e) {

            if (conexion != null) {
                conexion.rollback();
            }
            throw e;

        } finally {
            //Cerrar conexion
            conexionBD.cerrarConexion(conexion);
        }

        return miObjeto;
    }

}
