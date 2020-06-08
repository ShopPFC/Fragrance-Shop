/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Excepciones.MiExcepcion;
import ICommand.ICommand;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Javier
 */
public class controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String operacion = request.getParameter("opID");

        try {

            if (!operacion.equals("Login") && !operacion.equals("Valida") && !operacion.equals("Registro") && !operacion.equals("InsertaUsuario") 
                    && !operacion.equals("Carrito") && !operacion.equals("ControlPaginacion") && !operacion.equals("ArticuloSinLogin") 
                    && !operacion.equals("InsertarLineaCarrito") && !operacion.equals("InsertaArticulo")&& !operacion.equals("Redireccion")) {
                if (request.getSession().getAttribute("usuarioSesion") == null) {
                    System.out.println("Error a la hora de mostrar sin iniciar sesión");
                    throw new MiExcepcion(3);
                }
            }

            System.out.println("Antes del classForname");
            ICommand command = (ICommand) Class.forName("Presentacion." + operacion + "Command").newInstance();
            command.initPage(request, response);
            String subVista = command.execute(request, response);
            request.setAttribute("paginaprincipal", subVista);
            request.getRequestDispatcher("/inicio.jsp").forward(request, response);

        } catch (MiExcepcion e) {
            System.out.println("Entra en el catch y salta mi excepción del controller");
            String mensajeError = "";
            switch (e.getCodigoError()) {
                case 1:
                    mensajeError = "Usuario no existe";
                    break;

                case 2:
                    mensajeError = "Contraseña incorrecta";
                    break;

                case 3:
                    mensajeError = "Identifíquese para acceder a la aplicación";
                    break;

                case 4:
                    mensajeError = "No existen filas";
                    break;

            }
            request.setAttribute("mensajeError", mensajeError);
            request.getRequestDispatcher("/inicio.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println(e);
            String mensajeError = "Error indeterminado. Pongase en contacto son su distribuidor";
            request.setAttribute("mensajeError", mensajeError);
            request.getRequestDispatcher("/inicio.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
