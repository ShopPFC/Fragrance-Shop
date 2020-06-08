/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Usuario;
import Entidades.Articulo;
import Entidades.Carrito;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Javier
 */
public class ArticuloDAO {

    public List<Articulo> consultarPagina(Connection conexion, Integer paginaActual) throws SQLException, Exception, IOException {

        List<Articulo> listaPagina = new ArrayList();
        Articulo articulo = null;
        PreparedStatement pstmt = null;

        try {

            String SQL = "select id_articulo, nombre, descripcion, precio, stock, imagen, numfila"
                    + " from articulo where numfila>=((?-1)*6)+1 and numfila<=(?*6) order by numfila";

            pstmt = conexion.prepareStatement(SQL);

            pstmt.setInt(1, paginaActual.intValue());
            pstmt.setInt(2, paginaActual.intValue());

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                articulo = new Articulo();
                articulo.setId_articulo(rs.getString(1));
                articulo.setNombre(rs.getString(2));
                articulo.setDescripcion(rs.getString(3));
                articulo.setPrecio(rs.getInt(4));
                articulo.setStock(rs.getInt(5));
                articulo.setImagen(rs.getString(6));
                listaPagina.add(articulo);
            }

        } catch (SQLException e) {
            System.out.println("Problema al consultar pagina " + e.getMessage());
            throw new Exception("Problema al consultar pagina " + e.getMessage());
        }

        return listaPagina;
    }

    public Integer consultarNumFilas(Connection conexion) throws Exception, IOException {
        Integer numFilas = null;
        Statement stmt = null;
        ResultSet rs = null;
        String SQL = "select count(*) from articulo";

        try {
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(SQL);
            if (rs.next()) {
                numFilas = new Integer(rs.getInt(1));
            }

        } catch (Exception e) {
            System.out.println("Problema al consultar pagina " + e.getMessage());
            throw new Exception("Problema al consultar pagina " + e.getMessage());

        }

        return numFilas;
    }

    public Articulo consultarId(Connection conexion, Articulo articuloId) throws SQLException, Exception, IOException {

        Articulo articuloEncontrado = null;

        try {

            String SQL = "select * from articulo where id_articulo=?";

            PreparedStatement pstmt = conexion.prepareStatement(SQL);
            pstmt.setString(1, articuloId.getId_articulo());
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                articuloEncontrado = new Articulo();
                articuloEncontrado.setId_articulo(rs.getString(1));
                articuloEncontrado.setNombre(rs.getString(2));
                articuloEncontrado.setDescripcion(rs.getString(3));
                articuloEncontrado.setPrecio(rs.getInt(4));
                articuloEncontrado.setStock(rs.getInt(5));
                articuloEncontrado.setImagen(rs.getString(6));
                articuloEncontrado.setNumfila(rs.getString(7));
            }

        } catch (SQLException e) {
            System.out.println("Problema al consultar por id " + e.getMessage());
        }
        return articuloEncontrado;
    }

    public Articulo articulosPorReferen(Connection conexion, Carrito carrito) throws SQLException, Exception, IOException {

        Articulo articulo = new Articulo();

        try {

            String sql = "select * from articulo where Id_articulo = cast(? as char(10)) ";

            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setString(1, carrito.getId_articulo());
            ResultSet datos = stmt.executeQuery();

            while (datos.next()) {
                articulo.setId_articulo(datos.getString(1));
                articulo.setNombre(datos.getString(2));
                articulo.setDescripcion(datos.getString(3));
                articulo.setPrecio(datos.getInt(4));
                articulo.setStock(datos.getInt(5));
                articulo.setImagen(datos.getString(6));
                articulo.setNumfila(datos.getString(7));
            }
        } catch (Exception e) {
            System.out.println("Error en articulo por referencia " + e.getMessage());
        }

        return articulo;
    }

    public Articulo articulosPorId(Connection conexion, Articulo articulo) throws SQLException, Exception, IOException {

        Articulo articuloId = new Articulo();

        try {

            String sql = "select * from articulo where Id_articulo = cast(? as char(10)) ";

            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setString(1, articulo.getId_articulo());
            ResultSet datos = stmt.executeQuery();

            while (datos.next()) {
                articuloId.setId_articulo(datos.getString(1));
                articuloId.setNombre(datos.getString(2));
                articuloId.setDescripcion(datos.getString(3));
                articuloId.setPrecio(datos.getInt(4));
                articuloId.setStock(datos.getInt(5));
                articuloId.setImagen(datos.getString(6));
                articuloId.setNumfila(datos.getString(7));
            }
        } catch (Exception e) {
            System.out.println("Error en articulo por referencia " + e.getMessage());
        }

        return articuloId;
    }

    public void insertarArticulo(Connection conexion, Articulo articulo) throws SQLException, Exception, IOException {

        System.out.println("Principio insertaArticulo");

        try {

            String SQL = "INSERT INTO articulo (id_articulo, nombre, descripcion, precio, stock, imagen, numfila) VALUES (?,?,?,?,1,?,?)";

            PreparedStatement pstmt = conexion.prepareStatement(SQL);
            pstmt.setString(1, articulo.getId_articulo());
            pstmt.setString(2, articulo.getNombre());
            pstmt.setString(3, articulo.getDescripcion());
            pstmt.setInt(4, articulo.getPrecio());
            pstmt.setString(5, articulo.getImagen());
            pstmt.setString(6, articulo.getNumfila());
            pstmt.executeUpdate();

            System.out.println("Final insertaArticulo");

        } catch (SQLException e) {
            System.out.println("Error en insertar articulo " + e.getMessage());
        }

    }

    public Articulo ultimoArt(Connection conexion, Articulo articulo) throws SQLException, Exception, IOException {

        System.out.println("Principio ultimo articulo");

        Articulo articuloId = null;

        try {

            String SQL = "select id_articulo+1 from articulo order by id_articulo desc limit 1";

            PreparedStatement stmt = conexion.prepareStatement(SQL);
            //stmt.setString(1, articulo.getId_articulo());
            ResultSet datos = stmt.executeQuery(SQL);

            while (datos.next()) {
                articuloId = new Articulo();
                articuloId.setId_articulo(datos.getString(1));
                System.out.println(articuloId);
            }

            System.out.println("Después del try de ultimo articulo");

        } catch (SQLException e) {
            System.out.println("Error en ultimo articulo " + e.getMessage());
        }
        return articuloId;
    }

    public boolean actualizaArticulo(Connection conexion, Articulo articulo) throws SQLException, Exception {

        boolean f = false;

        conexion.setAutoCommit(false);

        String SQL = "UPDATE articulo set nombre=?, descripcion=?, precio=?, stock=?, imagen=? where id_articulo=?";

        try {

            PreparedStatement pstmt = conexion.prepareStatement(SQL);

            pstmt.setString(1, articulo.getNombre());
            pstmt.setString(2, articulo.getDescripcion());
            pstmt.setInt(3, articulo.getPrecio());
            pstmt.setInt(4, articulo.getStock());
            pstmt.setString(5, articulo.getImagen());
            pstmt.setString(6, articulo.getId_articulo());
            pstmt.executeUpdate();

            f = true;

            conexion.commit();
            conexion.setAutoCommit(true);

        } catch (Exception e) {
            System.out.println("Error en el actualizar articulo " + e);
        }

        return f;
    }
}
