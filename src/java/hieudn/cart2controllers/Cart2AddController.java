/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieudn.cart2controllers;

import hieudn.dtos.RegistrationErrorObject;
import hieudn.dtos.SceneToolDTO;
import hieudn.models.SceneToolDAO;
import java.io.IOException;
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
public class Cart2AddController extends HttpServlet {

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
            SceneToolDAO dao = new SceneToolDAO();
            List<SceneToolDTO> list = dao.getToolScene();
            HttpSession session = request.getSession();
            RegistrationErrorObject oreo = new RegistrationErrorObject();
            SceneToolCart cart = (SceneToolCart) session.getAttribute("cart");
            if (cart == null) {
                cart = new SceneToolCart();
            }
            String numOfUse = request.getParameter("txtCount");
            if (!numOfUse.matches("[0-9]{1,}")) {
                flag = false;
                oreo.setNumtoolshotError("Number format only");
            }
            String des = request.getParameter("txtTSDes");
            if (!des.matches("^[a-zA-Z0-9]{1,100}$")) {
                flag = false;
                oreo.setToolshotdesError("Give the tool some description ( < 100 chars)");
            }
            String idtool = request.getParameter("cart21");
            String idshot = request.getParameter("cart22");
            String[] tmp = idshot.split(" - ");
            String[] tmp1 = idtool.split(" - ");
            String idtoolshot = request.getParameter("txtShotTool");
            if (!idtoolshot.matches("^[a-zA-Z0-9]{1,20}$")) {
                flag = false;
                oreo.setIdtoolshotError("The Scene-Tool id cannot be blank (< 20 chars)");
            }
            if (!flag) {
                request.setAttribute("INVALID", oreo);
                request.setAttribute("ID", idtoolshot);
                request.setAttribute("DS", des);
                request.setAttribute("RL", numOfUse);
            } else {
                SceneToolDTO dto = new SceneToolDTO(idtoolshot, tmp[0].trim(), tmp1[0].trim(), Integer.parseInt(numOfUse), des);
                cart.addToCart(dto);
                if (cart.addToCart(dto)) {
                    request.setAttribute("SUCCESS", "Cart added successfully!");
                    session.setAttribute("cart", cart);
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
//            response.sendRedirect("castercart.jsp");
            request.getRequestDispatcher("Cart2SearchController").forward(request, response);
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
