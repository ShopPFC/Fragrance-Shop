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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Javier
 */
public class ArticuloBLL {

    public List<Articulo> consultarPagina(Integer paginaActual) throws Exception {
        List<Articulo> listaPaginas = null;
        Connection conexion = null;
        ConexionBD conexionBD = new ConexionBD();

        try {
            conexion = conexionBD.abrirConexion();
            listaPaginas = new ArticuloDAO().consultarPagina(conexion, paginaActual);
        } catch (Exception e) {
            System.out.println("Error consultarPaginaBLL" + e);
            throw e;
        } finally {
            conexionBD.cerrarConexion(conexion);
        }
        return listaPaginas;
    }

    public Integer consultarNumFilas() throws Exception {

        Integer numFilas = null;
        Connection conexion = null;
        ConexionBD conexionBD = new ConexionBD();

        try {
            conexion = conexionBD.abrirConexion();
            numFilas = new ArticuloDAO().consultarNumFilas(conexion);
        } catch (Exception e) {
            throw e;
        } finally {
            conexionBD.cerrarConexion(conexion);
        }
        return numFilas;
    }

    public Articulo consultarId(Articulo articuloT) throws Exception {
        Connection conexion = null;
        ConexionBD conexionBD = new ConexionBD();
        Articulo articulo = null;

        try {
            conexion = conexionBD.abrirConexion();
            articulo = new ArticuloDAO().consultarId(conexion, articuloT);
        } catch (Exception e) {
            throw new MiExcepcion(1);

        } finally {
            conexionBD.cerrarConexion(conexion);
        }
        return articulo;
    }

    public Articulo articulosPorId(Articulo articulo) throws ClassNotFoundException, SQLException, Exception {

        Connection conexion = null;
        ConexionBD conexionBD = new ConexionBD();
        ArticuloDAO articuloDao = new ArticuloDAO();

        conexion = conexionBD.abrirConexion();
        Articulo articuloEncontrado = articuloDao.articulosPorId(conexion, articulo);

        conexionBD.cerrarConexion(conexion);

        return articuloEncontrado;
    }

    public void insertaArticulo(Articulo articulo) {

        System.out.println("Bll.Inicio InsertarArticulo");

        Connection conexion = null;
        ConexionBD conexionBD = new ConexionBD();
        ArticuloDAO articuloDAO = new ArticuloDAO();

        System.out.println(articulo.getNombre());
        System.out.println("Bll.Conexion InsertarArticulo");

        try {
            conexion = conexionBD.abrirConexion();
            articuloDAO.insertarArticulo(conexion, articulo);
            System.out.println("Bll.Dentro del Try InsertarArticulo");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Articulo ultimoArt(Articulo articulo) throws ClassNotFoundException, SQLException, Exception {

        ConexionBD conexionBD = new ConexionBD();
        ArticuloDAO articuloDAO = new ArticuloDAO();

        Connection conexion = conexionBD.abrirConexion();
        Articulo listaArticulos = articuloDAO.ultimoArt(conexion, articulo);

        conexionBD.cerrarConexion(conexion);

        return listaArticulos;
    }

    public boolean actualizaArticulo(Articulo articulo) {

        Connection conexion = null;
        ConexionBD conexionBD = new ConexionBD();

        boolean f = false;
        
        ArticuloDAO articuloDAO = new ArticuloDAO();
        
        try {
            conexion = conexionBD.abrirConexion();
            articuloDAO.actualizaArticulo(conexion, articulo);
            f = true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return f;

    }

    public void incrementarUnidadBLL(Carrito carrito, int c) throws Exception {

        //Punteros
        ConexionBD conexionBD = new ConexionBD();
        Connection conexion = null;

        CarritoDAO carritoDAO = new CarritoDAO();
        ArticuloDAO articuloDAO = new ArticuloDAO();

        //--------------------------------------------------------------------------
        if (c == 2) {

            try {

                //Abrir conexion
                conexion = conexionBD.abrirConexion();

                conexion.setAutoCommit(false);
                //Consultando el dni del usuario
                Usuario usuario = new Usuario();
                usuario = carritoDAO.consultarPorPKCarrito(conexion, carrito);

                //Consultando articulo por referencia
                Articulo articulo = new Articulo();
                articulo = articuloDAO.articulosPorReferen(conexion, carrito);

                if (articulo.getStock() == 0) {
                    throw new Exception("No tiene ningun articulo");

                }

                carritoDAO.actualizarUnidades(conexion, carrito);
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
        }

    }

    public void borrarLineaBLL(Carrito carrito, Usuario usuario) throws Exception {

        ConexionBD conexionBD = new ConexionBD();

        List<Carrito> listaCarrito = null;

        Connection conexion = null;

        CarritoDAO carritoDAO = new CarritoDAO();
        ArticuloDAO articuloDAO = new ArticuloDAO();
        Carrito carritoUni = null;

//        
        //--------------------------------------------------------------------------
        try {

            //Abrir conexion
            conexion = conexionBD.abrirConexion();

            conexion.setAutoCommit(false);

            listaCarrito = carritoDAO.mostrarCarrito(conexion, usuario);

            //Consultando articulo por referencia
            Articulo articulo = new Articulo();
            articulo = articuloDAO.articulosPorReferen(conexion, carrito);

            for (int i = 0; i < listaCarrito.size(); i++) {
                carritoUni = listaCarrito.get(i);
            }

            carritoDAO.devolverStock(conexion, carrito);
            carritoDAO.eliminarUnidades(conexion, carrito, usuario);

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

    }
}
