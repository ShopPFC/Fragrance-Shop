/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import ICommand.ICommand;
import BLL.ArticuloBLL;
import Entidades.Articulo;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Javier
 */
public class LoginCommand extends ICommand {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/login.jsp";
    }
}
