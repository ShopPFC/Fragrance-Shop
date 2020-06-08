/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import ICommand.ICommand;
import BLL.ArticuloBLL;
import BLL.UsuarioBLL;
import Entidades.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Javier
 */
public class ValidaCommand extends ICommand {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Usuario usuario = new Usuario();
        usuario.setDni(request.getParameter("dni"));
        usuario.setContrasenya(request.getParameter("contrasenya"));

        Usuario _usuarioEncontrado = new UsuarioBLL().validaUsuario(usuario);

        /*Con sesión
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("usuarioSesion", _usuarioEncontrado);
        httpSession.setAttribute("usuarioConectado", request.getParameter("dni"));
        */
        
        request.getSession().setAttribute("usuarioSesion", _usuarioEncontrado);
        request.getSession().setAttribute("usuarioConectado", request.getParameter("dni"));
        
        return "/enblanco.jsp";
    }
}
