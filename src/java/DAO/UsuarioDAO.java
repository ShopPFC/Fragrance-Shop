/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
public class UsuarioDAO {

    public Usuario consultarDni(Connection conexion, Usuario usuarioDni) throws SQLException, Exception {

        Usuario compradorEncontrado = null;

        try {

            String SQL = "select * from usuario where dni=?";

            PreparedStatement pstmt = conexion.prepareStatement(SQL);
            pstmt.setString(1, usuarioDni.getDni());
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                compradorEncontrado = new Usuario();
                compradorEncontrado.setDni(rs.getString(1));
                compradorEncontrado.setNombre(rs.getString(2));
                compradorEncontrado.setContrasenya(rs.getString(3));
                compradorEncontrado.setApellidos(rs.getString(4));
                compradorEncontrado.setEmail(rs.getString(5));
            }

        } catch (SQLException e) {
            System.out.println("Problema al consultar por dni " + e.getMessage());
        }
        return compradorEncontrado;
    }

    public void insertarUsuario(Connection conexion, Usuario usuario) throws SQLException, Exception {

        String SQL = "INSERT INTO usuario (dni,nombre,contrasenya,apellidos,email) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement pstmt = conexion.prepareStatement(SQL);
            pstmt.setString(1, usuario.getDni());
            pstmt.setString(2, usuario.getNombre());
            pstmt.setString(3, usuario.getContrasenya());
            pstmt.setString(4, usuario.getApellidos());
            pstmt.setString(5, usuario.getEmail());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Problema al insertar usuario " + e.getMessage());
        }

    }

    public boolean actualizaUsuario(Connection conexion, Usuario usuario) throws SQLException, Exception {

        boolean f = false;

        conexion.setAutoCommit(false);

        String SQL = "UPDATE usuario set nombre=?, contrasenya=?, apellidos=?, email=? where dni=?";

        try {

            PreparedStatement pstmt = conexion.prepareStatement(SQL);

            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getContrasenya());
            pstmt.setString(3, usuario.getApellidos());
            pstmt.setString(4, usuario.getEmail());
            pstmt.setString(5, usuario.getDni());
            pstmt.executeUpdate();

            f = true;

            conexion.commit();
            conexion.setAutoCommit(true);

        } catch (Exception e) {
            System.out.println("Error en el actualizar usuario " + e);
        }

        return f;
    }

}
