/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieudn.accountControllers;

import hieudn.dtos.RegistrationDTO;
import hieudn.dtos.RegistrationErrorObject;
import hieudn.models.RegistrationBean;
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
public class RegisterController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "crewmanagement.jsp";
    private static final String INVALID = "register.jsp";

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
        RegistrationErrorObject oreo = new RegistrationErrorObject();
        try {
            boolean c = true;
            String username = request.getParameter("txtUsername");
            if (!username.matches("^[a-zA-Z0-9]{1,20}$")) {
                c = false;
                oreo.setUsernameError("Username must be less than 21 chars");
            }

            String password = request.getParameter("txtPassword");
            if (!password.matches("^[a-zA-Z0-9]{1,20}$")) {
                c = false;
                oreo.setPasswordError("Password cant be a blank or over 20 chars");
            }
            String fullname = request.getParameter("txtFullname");
            if (!fullname.matches("^[a-zA-Z]{1,50}$")) {
                c = false;
                oreo.setFullnameError("Fullname cant be a blank or over 50 chars");
            }
            String descript = request.getParameter("txtDescript");
            if (!descript.matches("^[a-zA-Z0-9]{1,200}$")) {
                c = false;
                oreo.setDescriptError("Description cant be a blank or over 200 chars");
            }
            String phone = request.getParameter("txtPhone");
            if (!phone.matches("^[0-9]{10,11}$")) {
                c = false;
                oreo.setPhoneError("Number format only! (10-11 chars)");
            }
            String email = request.getParameter("txtEmail");
            if (!email.matches(".+\\@.+\\..+")) {
                c = false;
                oreo.setEmailError("Wrong email format!");
            }
            String pic = request.getParameter("txtPicture");
            if (pic.equals("")) {
                c = false;
                oreo.setPictureError("Profile picture must be added");
            }
            String role = request.getParameter("cbRole");
            if (!c) {
                url = INVALID;
                request.setAttribute("INVALID", oreo);
                request.setAttribute("UN", username);
                request.setAttribute("FN", fullname);
                request.setAttribute("DS", descript);
                request.setAttribute("PH", phone);
                request.setAttribute("EM", email);
                request.setAttribute("PT", pic);
                request.setAttribute("RL", role);
            } else {
                RegistrationDTO dto = new RegistrationDTO(username, fullname, descript, phone, email, pic, role);
                dto.setPasswordAcc(password);
                RegistrationBean beans = new RegistrationBean();
                beans.setDto(dto);
                boolean check = beans.insert();
                if (check) {
                    url = SUCCESS;
                }
                if (!check) {
                    request.setAttribute("ERROR", "Error occurs during inserting");
                }
            }
        } catch (Exception e) {
            if (e.getMessage().contains("duplicate")) {
                url = INVALID;
                request.setAttribute("DUP", "Existed username!");

            } else {
//                log("ERROR at RegisterController: " + e.getMessage());
                e.printStackTrace();
            }
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
