/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieudn.castercontrollers;

import hieudn.dtos.CasterDTO;
import hieudn.models.CasterDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hp
 */
public class CasterSearchController extends HttpServlet {

    private static final String HISTORY = "recorded.jsp";
    private static final String FUTURE = "norecorded.jsp";
    private static final String ERROR = "error.jsp";

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
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("USERNAME");
            System.out.println("username " + username);
            CasterDAO dao = new CasterDAO();
            List<CasterDTO> result = dao.findByLikeTime(username);
            List<CasterDTO> history = new ArrayList<>();
            List<CasterDTO> future = new ArrayList<>();
            Date d = new Date();
            for (CasterDTO f : result) {
                if (f.getStart().compareTo(d) > 0) {
                    future.add(f);
                    System.out.println("f:" + f);
                } else {
                    history.add(f);
                    System.out.println("h:" + f);
                }
            }
            request.setAttribute("INFOCASTER1", future);
            request.setAttribute("INFOCASTER2", history);
            String action = request.getParameter("action");
            if (action.equals("Upcoming videotapping")) {
                url = FUTURE;
            } else if (action.equals("Videotapped Scenes")) {
                url = HISTORY;
            } else {
                request.setAttribute("ERROR", "Invalid action!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
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
