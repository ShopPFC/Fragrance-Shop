/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import BLL.ArticuloBLL;
import BLL.CarritoBLL;
import BLL.UsuarioBLL;
import DAO.ConexionBD;
import Entidades.Articulo;
import Entidades.Carrito;
import Entidades.Usuario;
import ICommand.ICommand;
import java.sql.Connection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Javier
 */
public class PerfilCommand extends ICommand{

    public void initPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");

        String dniId = request.getParameter("dni");
        Usuario usuario = new Usuario();
        usuario.setDni(dniId);

        try {
            UsuarioBLL usuarioBll = new UsuarioBLL();
            Usuario resultado = usuarioBll.consultarDni(usuario);
            request.setAttribute("usuarioencontrado", resultado);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        return "/visualizaperfil.jsp";

    }

}
