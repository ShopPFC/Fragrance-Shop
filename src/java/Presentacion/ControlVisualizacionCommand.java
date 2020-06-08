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
public class ControlVisualizacionCommand extends ICommand {

    public void initPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");

        String id_articulo = request.getParameter("id_articulo");
        Articulo articulo = new Articulo();
        articulo.setId_articulo(id_articulo);

        try {
            ArticuloBLL articuloBll = new ArticuloBLL();
            Articulo resultado = articuloBll.articulosPorId(articulo);
            request.setAttribute("articuloencontrado", resultado);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        return "/visualizafila.jsp";

    }

}
