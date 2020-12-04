/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieudn.accountControllers;

import hieudn.dtos.RegistrationErrorObject;
import hieudn.dtos.RegistrationDTO;
import hieudn.models.RegistrationBean;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hp
 */
public class LoginController extends HttpServlet {

    private static final String ADMIN = "admin.jsp";
    private static final String ERROR = "error.jsp";
    private static final String DIRECTOR = "director.jsp";
    private static final String CASTER = "caster.jsp";
    private static final String INVALID = "index.jsp";

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
            String role = "failed";
            boolean check = true;
            RegistrationErrorObject oreo = new RegistrationErrorObject();
            String username = request.getParameter("txtUsername");
            if (username.equals("")) {
                check = false;
                oreo.setUsernameError("Username cant be a blank");
            }
            String password = request.getParameter("txtPassword");
            if (password.equals("")) {
                check = false;
                oreo.setPasswordError("Password cant be a blank");
            }
            if (check) {
                RegistrationBean beans = new RegistrationBean();
                beans.setUsername(username);
                beans.setPassword(password);
                RegistrationDTO dto = beans.checklogin();
                HttpSession session = request.getSession();
                if (dto != null) {
//                    session.setAttribute("Fullname", dto.getFullname());
                    role = dto.getRole();
                    String fullname = dto.getFullname();
                    if (role.equals("admin")) {
                        url = ADMIN;
                    } else if (role.equals("director")) {
                        url = DIRECTOR;
                    } else if (role.equals("caster")) {
                        url = CASTER;
                    } else {
                        request.setAttribute("ERROR", "Invalid Role");
                    }
                    session.setAttribute("FULLNAME", fullname);
                    session.setAttribute("USERNAME", username);
                    System.out.println("username:" + username);
                } else {
                    request.setAttribute("ERROR", "Wrong Username or Password!!!");
                }
            } else {
                url = INVALID;
                request.setAttribute("INVALID", oreo);
                request.setAttribute("UN", username);
            }
        } catch (Exception e) {
            log("Error at LoginController: " + e.getMessage());
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
