/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import BLL.ArticuloBLL;
import BLL.UsuarioBLL;
import DAO.ConexionBD;
import Entidades.Articulo;
import Entidades.Usuario;
import ICommand.ICommand;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Javier
 */
public class ModificarUsuarioCommand extends ICommand {

    @Override
    public void initPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");

        String usuarioId = request.getParameter("dni");
        String usuarioNombre = request.getParameter("nombre");
        String usuarioApellidos = request.getParameter("apellidos");
        String usuarioEmail = request.getParameter("email");
        String usuarioContrasenya = request.getParameter("contrasenya");

        Usuario usuario = new Usuario();
        usuario.setDni(usuarioId);
        usuario.setNombre(usuarioNombre);
        usuario.setApellidos(usuarioApellidos);
        usuario.setEmail(usuarioEmail);
        usuario.setContrasenya(usuarioContrasenya);

        ConexionBD conexionBD = new ConexionBD();
        Connection conexion = null;

        try {

            conexion = conexionBD.abrirConexion();
            conexion.setAutoCommit(false);
            System.out.println("Entra en el try de la clase command");

            UsuarioBLL usuarioBll = new UsuarioBLL();

            boolean resultado = usuarioBll.actualizaUsuario(usuario);
            request.setAttribute("usuarioSesion", resultado);
            
            conexion.commit();
            conexion.setAutoCommit(true);

            request.setAttribute("registroResultado", "Usuario Modificado");
            request.setAttribute("redirectResultado", "Redirigiendo al Perfil");
            
            /*request.getSession().setAttribute("usuarioSesion", resultado);*/
            /*request.getSession().setAttribute("usuarioConectado", request.getParameter("dni"));*/
        } catch (Exception e) {
            
            conexion.rollback();
            System.out.println(e);
        }
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        return "/registroResultado.jsp";

    }
}
