/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import ICommand.ICommand;
import BLL.ArticuloBLL;
import BLL.UsuarioBLL;
import DAO.ConexionBD;
import Entidades.Usuario;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Javier
 */
public class InsertaUsuarioCommand extends ICommand {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Usuario usuario = new Usuario();
        usuario.setDni(request.getParameter("dni"));
        usuario.setNombre(request.getParameter("nombre"));
        usuario.setContrasenya(request.getParameter("contrasenya"));
        usuario.setApellidos(request.getParameter("apellidos"));
        usuario.setEmail(request.getParameter("email"));

        ConexionBD conexionBD = new ConexionBD();
        Connection conexion = null;

        try {
            System.out.println("Inicio try inserta usuario");
            
            conexion = conexionBD.abrirConexion();
            conexion.setAutoCommit(false);

            UsuarioBLL usuarioBLL = new UsuarioBLL();
            Usuario usuario_encontrado = usuarioBLL.consultarDni(usuario);
            
            if (usuario_encontrado != null) {
                request.setAttribute("registroResultado", "Usuario ya existe");
                request.setAttribute("redirectResultado", "");
            } else {
                usuarioBLL.insertaUsuario(usuario);
                request.setAttribute("registroResultado", "Registrado correctamente");
                request.setAttribute("redirectResultado", "Redirigiendo a Login");
            }

        } catch (Exception e) {
            conexion.rollback();
            System.out.println(e);
            throw e;

        } finally {
            conexionBD.cerrarConexion(conexion);
        }

        return "/registroResultado.jsp";
    }
}
