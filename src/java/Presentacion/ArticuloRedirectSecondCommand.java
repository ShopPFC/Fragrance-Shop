/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import BLL.ArticuloBLL;
import Entidades.Articulo;
import ICommand.ICommand;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Javier
 */
public class ArticuloRedirectSecondCommand extends ICommand {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Articulo articulo = new Articulo();
        ArticuloBLL articuloBLL = new ArticuloBLL();

        Articulo listaId = articuloBLL.ultimoArt(articulo);
        request.setAttribute("articuloPasado", listaId);
        System.out.println(listaId);

        return "subirfoto.jsp";
    }
}
