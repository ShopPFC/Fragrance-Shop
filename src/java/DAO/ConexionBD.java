/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;

/**
 *
 * @author Javier
 */
public class ConexionBD {

    public Connection abrirConexion() throws Exception {
        Connection conexion;
        Class.forName("com.mysql.jdbc.Driver");
        conexion = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/ventas","root","");
        return conexion;
    }

    public void cerrarConexion(Connection conexion) throws Exception {
        conexion.close();
    }
}
