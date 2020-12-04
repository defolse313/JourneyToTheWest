/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieudn.toolcontrollers;

import hieudn.dtos.RegistrationDTO;
import hieudn.dtos.RegistrationDTOTool;
import hieudn.dtos.RegistrationErrorObject;
import hieudn.models.RegistrationBean;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.apache.tomcat.jni.User.username;

/**
 *
 * @author hp
 */
public class ToolUpdateController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "ToolSearchController";
    private static final String INVALID = "toolupdate.jsp";

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
            String idtool = request.getParameter("txtIdTool");
            if (!idtool.matches("^[a-zA-Z0-9]{1,20}$")) {
                c = false;
                oreo.setIdtoolError("Make it unique by giving an ID!(<20)");
            }
            String toolname = request.getParameter("txtToolName");
            if (!toolname.matches("^[a-zA-Z0-9]{1,100}$")) {
                c = false;
                oreo.setToolnameError("Name must be 1- 100 chars");
            }
            String tooldes = request.getParameter("txtToolDescript");
            if (!tooldes.matches("^[a-zA-Z0-9]{1,200}$")) {
                c = false;
                oreo.setTooldescriptError("Description must be 1- 200 chars");
            }
            String toolimg = request.getParameter("txtToolImg");
            if (toolimg.equals("")) {
                c = false;
                oreo.setToolimgError("A picture is required");
            }
            String toolstatus = request.getParameter("txtToolStatus");
            if (!toolstatus.matches("^[a-zA-Z0-9]{1,50}$")) {
                c = false;
                oreo.setToolstatusError("Tool's status must be given");
            }
            String quantity = request.getParameter("txtToolQuantity");
            if (!quantity.matches("^[0-9]+")) {
                c = false;
                oreo.setToolquantityError("Give it the amount!");
            }
            if (!c) {
                url = INVALID;
                request.setAttribute("INVALID", oreo);
                request.setAttribute("IT", idtool);
                request.setAttribute("TN", toolname);
                request.setAttribute("TD", tooldes);
                request.setAttribute("TI", toolimg);
                request.setAttribute("TS", toolstatus);
                request.setAttribute("QT", quantity);
            } else {
                RegistrationDTOTool dto = new RegistrationDTOTool(idtool, toolname, tooldes, toolimg, toolstatus, Integer.parseInt(quantity));
                RegistrationBean beans = new RegistrationBean();
                beans.setDtotool(dto);
                boolean check = beans.toolUpdate();
                if (check) {
                    url = SUCCESS;
                }
                if (!check) {
                    request.setAttribute("ERROR", "Error occurs during tools inserting");
                }
            }
        } catch (Exception e) {
            log("ERROR at Tool Update Controller: " + e.getMessage());

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
