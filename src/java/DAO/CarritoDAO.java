/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Carrito;
import Entidades.Usuario;
import Entidades.Articulo;
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
public class CarritoDAO {

    public void insertarFila(Connection conexion, Carrito carrito) throws SQLException, Exception {

        String SQL = "insert into carrito(dni,id_articulo,unidades,nombre,precio,imagen) values(?,?,?,?,?,?)";

        try {

            PreparedStatement pstmt = conexion.prepareStatement(SQL);
            pstmt.setString(1, carrito.getDni());
            pstmt.setString(2, carrito.getId_articulo());
            pstmt.setInt(3, carrito.getUnidades());
            pstmt.setString(4, carrito.getNombre());
            pstmt.setInt(5, carrito.getPrecio());
            pstmt.setString(6, carrito.getImagen());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al insertar fila carrito " + e.getMessage());

            throw e;
        }

    }

    public Usuario consultarPorPKCarrito(Connection conexion, Carrito carrito) throws SQLException, Exception {

        Usuario usuario = new Usuario();

        try {

            String sql = "select * from usuario where dni = cast(? as char(10))";

            PreparedStatement stmt = conexion.prepareStatement(sql);

            stmt.setString(1, carrito.getDni());

            ResultSet datos = stmt.executeQuery();

            while (datos.next()) {
                usuario.setNombre(datos.getString(2));
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar por pk en carrito " + e.getMessage());
        }

        return usuario;
    }

    public List<Carrito> mostrarCarrito(Connection conexion, Usuario usuario) throws SQLException, Exception {

        List<Carrito> listaCarrito = new ArrayList<>();

        try {

            String sql = "select * from carrito inner join articulo "
                    + "on articulo.ID_ARTICULO = carrito.ID_ARTICULO "
                    + "where carrito.dni=?";

            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setString(1, usuario.getDni());
            ResultSet datos = stmt.executeQuery();

            while (datos.next()) {
                Carrito carrito = new Carrito();
                carrito.setDni(datos.getString(1));
                carrito.setId_articulo(datos.getString(2));
                carrito.setUnidades(datos.getInt(3));
                carrito.setNombre(datos.getString(4));
                carrito.setPrecio(datos.getInt(5));
                carrito.setImagen(datos.getString(6));

                listaCarrito.add(carrito);
            }

        } catch (SQLException e) {
            System.out.println("Error al mostrar carrito " + e.getMessage());
        }

        return listaCarrito;
    }

    public void actualizarUnidades(Connection conexion, Carrito carrito) throws SQLException, Exception {

        String sql = "update carrito set unidades = "
                + "(select unidades+1 from carrito where id_articulo = cast(? as char(10))) "
                + "where dni = cast(? as char(10))";

        try {
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            pstmt.setString(1, carrito.getId_articulo());
            pstmt.setString(2, carrito.getDni());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al actualizar unidades " + e.getMessage());
            throw e;
        }

    }

    public void eliminarUnidades(Connection conexion, Carrito carrito, Usuario usuario) throws SQLException, Exception {

        String sql = "delete from carrito WHERE dni = ? AND id_articulo = ?";

        try {
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            pstmt.setString(1, usuario.getDni());
            pstmt.setString(2, carrito.getId_articulo());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al eliminar unidades " + e.getMessage());
            throw e;
        }

    }

    public void actualizarStock(Connection conexion, Carrito carrito) throws SQLException, Exception {

        String sql = "UPDATE articulo set stock = (select stock-1 from (SELECT * FROM articulo)articulo where id_articulo = ?) where id_articulo = ?";
        /*
        String sql = "UPDATE articulo set stock = "
                + "(SELECT * FROM articulo as stock-1 where id_articulo = ?) "
                + "where id_articulo = ?";
         */

        try {
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            pstmt.setString(1, carrito.getId_articulo());
            pstmt.setString(2, carrito.getId_articulo());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al actualizar el stock - " + e.getMessage());
            throw e;
        }

    }

    public void actualizarStockMas(Connection conexion, Carrito carrito) throws SQLException, Exception {

        String sql = "UPDATE articulo set stock = (select stock+1 from (SELECT * FROM articulo)articulo where id_articulo = ?) where id_articulo = ?";
        /*
        String sql = "UPDATE articulo set stock = "
                + "(SELECT * FROM articulo as stock+1 where id_articulo = ?) "
                + "where id_articulo = ?";
         */
        try {
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            pstmt.setString(1, carrito.getId_articulo());
            pstmt.setString(2, carrito.getId_articulo());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al actualizar el stock + " + e.getMessage());
            throw e;
        }

    }

    public void devolverStock(Connection conexion, Carrito carrito) throws SQLException, Exception {

        String sql = "UPDATE articulo set stock = (select articulo.stock + carrito.unidades from(SELECT * FROM articulo)articulo join carrito on (carrito.id_articulo = articulo.id_articulo) where articulo.id_articulo = ?) where id_articulo = ?";

        /*UPDATE articulo set stock = (select articulo.stock + carrito.unidades from(SELECT * FROM articulo)articulo inner join carrito on (carrito.id_articulo = articulo.id_articulo) where articulo.id_articulo = ?) where id_articulo = ?*/
        
        try {
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            pstmt.setString(1, carrito.getId_articulo());
            pstmt.setString(2, carrito.getId_articulo());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al devolver el stock " + e.getMessage());
            throw e;
        }

    }

}
