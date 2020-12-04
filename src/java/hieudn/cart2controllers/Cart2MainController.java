/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieudn.cart2controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hp
 */
public class Cart2MainController extends HttpServlet {

    private static final String ADD = "Cart2AddController";
    private static final String DELETE = "Cart2DeleteController";
    private static final String DELETE1 = "Cart2Delete1Controller";
    private static final String ERROR = "error.jsp";
    private static final String ADDMORE = "Cart2SearchController";
    private static final String ALL = "Cart2Search1Controller";
    private static final String SAVE = "Cart2EditController";
    private static final String ACCEPT = "Cart2InsertController";

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
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            if (action.equals("Add tool to Collection")) {
                url = ADD;
            } else if (action.equals("Add more cart")) {
                url = ADDMORE;
            } else if (action.equals("View the overall scenes added")) {
                url = ALL;
            } else if (action.equals("Delete")) {
                url = DELETE;
            } else if (action.equals("Delete this")) {
                url = DELETE1;
            } else if (action.equals("Save")) {
                url = SAVE;
            } else if (action.equals("Accept to database")) {
                url = ACCEPT;
            } else if (action.equals("View the overall carts added")) {
                url = "cart2view.jsp";
            } else {
                request.setAttribute("ERROR", "Your action is invalid");
            }
        } catch (Exception e) {
            log("ERROR at Cart 2 MainController: " + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
