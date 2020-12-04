/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieudn.cart1controllers;

import hieudn.dtos.RegistrationErrorObject;
import hieudn.dtos.ScenesPartDTO;
import hieudn.models.ScencesPartDAO;
import java.io.IOException;
import java.util.Iterator;  
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hp
 */
public class Cart1AddController extends HttpServlet {

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
        try {
            boolean flag = true;
            ScencesPartDAO dao = new ScencesPartDAO();
            List<ScenesPartDTO> list = dao.getAccScene();
            HttpSession session = request.getSession();
            RegistrationErrorObject oreo = new RegistrationErrorObject();
            ScenesPartCart cart = (ScenesPartCart) session.getAttribute("cart1");
            if (cart == null) {
                cart = new ScenesPartCart();
            }
            String role = request.getParameter("txtASRole");
            if (!role.matches("^[a-zA-Z0-9]{1,50}$")) {
                flag = false;
                oreo.setAccshotroleError("Give the caster a role (< 50 chars)");
            }
            String des = request.getParameter("txtASDes");
            if (!des.matches("^[a-zA-Z0-9]{1,500}$")) {
                flag = false;
                oreo.setAccshotdesError("Give the role some description (< 500 chars)");
            }
            String idcaster = request.getParameter("cart11");
            String idshot = request.getParameter("cart12");
            String[] tmp = idcaster.split("-");
            String[] tmp1 = idshot.split("-");
            for (int i = 0; i < list.size(); i++) {
                if (tmp[0].trim().equals(list.get(i).getUsername().trim()) && tmp1[0].trim().equals(list.get(i).getIdShot().trim())) {
                    oreo.setExistedError("This caster has already participated in this scene!");
                    flag = false;
                }
            }
            for (ScenesPartDTO value : cart.getCart().values()) {
                if (tmp[0].trim().equals(value.getUsername().trim()) && tmp1[0].trim().equals(value.getIdShot().trim())) {
                    oreo.setExistedError("This caster has already participated in this scene! Delte the existed one or try another one");
                    flag = false;
                }
            }

            String idaccshot = request.getParameter("txtIdAccShot");
            if (!idaccshot.matches("^[a-zA-Z0-9]{1,20}$")) {
                flag = false;
                oreo.setIdaccshotError("The Scene-Caster id cannot be blank ( < 20 chars)");
            }
            if (!flag) {
                request.setAttribute("INVALID", oreo);
                request.setAttribute("ID", idaccshot);
                request.setAttribute("DS", des);
                request.setAttribute("RL", role);
            } else {
                String editor = (String) session.getAttribute("FULLNAME");
                ScenesPartDTO dto = new ScenesPartDTO(tmp[0].trim(), tmp1[0].trim(), role, idaccshot, des, editor);
                cart.addToCart(dto);
                if (cart.addToCart(dto)) {
                    request.setAttribute("SUCCESS", "Cart added successfully!");
                    session.setAttribute("cart1", cart);
                } else {
                    request.setAttribute("ERROR", "ERROR occurs while adding cart");
                }

            }
        } catch (Exception e) {
            if (e.getMessage().contains("duplicate")) {
                request.setAttribute("DUP", "Existed id!");
            } else {
//                log("ERROR at RegisterController: " + e.getMessage());
                e.printStackTrace();
            }
        } finally {
            request.getRequestDispatcher("Cart1SearchController").forward(request, response);
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
