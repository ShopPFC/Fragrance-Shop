/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import ICommand.ICommand;
import BLL.ArticuloBLL;
import Entidades.Articulo;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Javier
 */
public class ControlPaginacionCommand extends ICommand {

    public void initPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ArticuloBLL articuloBLL = new ArticuloBLL();

        int numeroPagina = Integer.parseInt(request.getParameter("numpagina"));
        Integer parametroPaginaActual = (Integer) request.getSession().getAttribute("actualpagina");
        int paginaActual = 0;
        if (parametroPaginaActual != null) {
            paginaActual = parametroPaginaActual.intValue();
        }

        int numeroFilas = (articuloBLL.consultarNumFilas()).intValue();
        int totalPaginas = numeroFilas / 6;
        if (numeroFilas % 3 != 0) {
            totalPaginas++;
        }
        request.setAttribute("totalpaginas", new Integer(totalPaginas));
        if (numeroPagina > 0) {
            paginaActual = numeroPagina;
        } else {
            switch (numeroPagina) {
                case 0:
                    paginaActual = 1;
                    break;

                case -1:
                    paginaActual--;
                    break;

                case -2:
                    paginaActual = 1;
                    break;

                case -3:
                    paginaActual++;
                    break;

                case -4:
                    paginaActual = totalPaginas;
                    break;
            }
        }
        if (request.getSession().getAttribute("actualpagina") != null) {
            request.getSession().setAttribute("actualpagina", new Integer(paginaActual));
            List<Articulo> listaArticulo = articuloBLL.consultarPagina(new Integer(paginaActual));
            request.setAttribute("listaguardada", listaArticulo);

        } else {
            request.getSession().setAttribute("actualpagina", 1);
            List<Articulo> listaArticulo = articuloBLL.consultarPagina(1);
            request.setAttribute("listaguardada", listaArticulo);
        }
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        return "/visualizapagina.jsp";

    }
}
