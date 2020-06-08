/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.ArticuloDAO;
import DAO.ConexionBD;
import DAO.UsuarioDAO;
import Entidades.Usuario;
import Excepciones.MiExcepcion;
import java.sql.Connection;

/**
 *
 * @author Javier
 */
public class UsuarioBLL {

    public Usuario consultarDni(Usuario usuarioT) throws Exception {
        Connection conexion = null;
        ConexionBD conexionBD = new ConexionBD();
        Usuario usuario = null;

        try {
            conexion = conexionBD.abrirConexion();
            usuario = new UsuarioDAO().consultarDni(conexion, usuarioT);
        } catch (Exception e) {
            throw new MiExcepcion(1);

        } finally {
            conexionBD.cerrarConexion(conexion);
        }
        return usuario;
    }

    public void insertaUsuario(Usuario usuario) {
        Connection conexion = null;
        ConexionBD conexionBD = new ConexionBD();
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        try {
            conexion = conexionBD.abrirConexion();
            usuarioDAO.insertarUsuario(conexion, usuario);
        } catch (Exception e) {
        }
    }

    public Usuario validaUsuario(Usuario usuario) throws Exception {

        ConexionBD conexionBD = new ConexionBD();
        ArticuloDAO articuloDAO = new ArticuloDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        Connection conexion = conexionBD.abrirConexion();

        Usuario usuarioT = usuarioDAO.consultarDni(conexion, usuario);

        if (usuarioT == null) {
            throw new MiExcepcion(1);
        }

        if ((usuario.getContrasenya()).compareTo(usuarioT.getContrasenya()) != 0) {
            throw new MiExcepcion(2);
        }
        conexionBD.cerrarConexion(conexion);

        return usuarioT;
    }
    
    public boolean actualizaUsuario(Usuario usuario){
        
        Connection conexion = null;
        ConexionBD conexionBD = new ConexionBD();
        
        boolean f = false;
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        try {
            conexion = conexionBD.abrirConexion();
            usuarioDAO.actualizaUsuario(conexion, usuario);
            f = true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return f;
    
    }

    public Usuario actualizaUsuario(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
