/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieudn.takecontrollers;

import hieudn.dtos.RegistrationDTOTake;
import hieudn.dtos.RegistrationErrorObject;
import hieudn.models.RegistrationBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hp
 */
public class TakeUpdateController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "TakeSearchController";
    private static final String INVALID = "takeupdate.jsp";

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
            String idtake = request.getParameter("txtIdTake");
            String takename = request.getParameter("txtTakeName");
            if (!takename.matches("^[a-zA-Z0-9]{1,50}$")) {
                c = false;
                oreo.setTakenameError("Every shot has a name (< 50 chars)");
            }
            String takedes = request.getParameter("txtTakeDescript");
            if (!takedes.matches("^[a-zA-Z0-9]{1,500}$")) {
                c = false;
                oreo.setTakedescriptError("Give the take some description!! (< 500 chars)");
            }
            String takelocation = request.getParameter("txtTakeLocation");
            if (!takelocation.matches("^[a-zA-Z0-9]{1,100}$")) {
                c = false;
                oreo.setTakelocationError("Where is the shot taken? (< 100 chars)");
            }
            String taketimes = request.getParameter("txtShotTimes");
            if (!taketimes.matches("^[0-9]+")) {
                c = false;
                oreo.setTaketimesError("How many times is the shot recorded?");
            }
            String startDateStr = request.getParameter("txtShotSDate");
            if (startDateStr.equals("")) {
                c = false;
                oreo.setStartError("Give it the starting day!");
            }

            String endDateStr = request.getParameter("txtShotEDate");
            if (endDateStr.equals("")) {
                c = false;
                oreo.setEndError("Give it the finish day!");
            }

            if (!c) {
                url = INVALID;
                request.setAttribute("INVALID", oreo);
                request.setAttribute("IT", idtake);
                request.setAttribute("TN", takename);
                request.setAttribute("TD", takedes);
                request.setAttribute("TL", takelocation);
                request.setAttribute("ST", taketimes);
                request.setAttribute("SSD", startDateStr);
                request.setAttribute("SED", endDateStr);
            } else {
                LocalDate ld = LocalDate.parse(startDateStr);
                Date startDate = Date.valueOf(ld);
                LocalDate ld1 = LocalDate.parse(endDateStr);
                Date endDate = Date.valueOf(ld1);
                if (!checkDate(startDate, endDate)) {
                    url = INVALID;
                    request.setAttribute("INVALID", oreo);
                    request.setAttribute("IT", idtake);
                    request.setAttribute("TN", takename);
                    request.setAttribute("TD", takedes);
                    request.setAttribute("TL", takelocation);
                    request.setAttribute("ST", taketimes);
                    request.setAttribute("SS", startDateStr);
                    request.setAttribute("SE", endDateStr);
                    oreo.setStartError("Start date must be before end date!");
                    oreo.setEndError("End date must be after start date!");
                } else {
                    RegistrationDTOTake dto = new RegistrationDTOTake(idtake, takename, takelocation, Integer.parseInt(taketimes), startDate, endDate, takedes);
                    RegistrationBean beans = new RegistrationBean();
                    beans.setDtotake(dto);
                    boolean check = beans.takeupdate();
                    if (check) {
                        url = SUCCESS;
                    }
                    if (!check) {
                        request.setAttribute("ERROR", "Error occurs during take updating");
                    }
                }
            }

        } catch (Exception e) {
//            if (e.getMessage().contains("duplicate")) {
//                url = INVALID;
//                request.setAttribute("DUP", "Existed username!");
//
//            } else {
//            log("ERROR at Take Register Controller: " + e.getMessage());
            e.printStackTrace();

        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    private boolean checkDate(Date startDate, Date endDate) {
        if (startDate.compareTo(endDate) > 0) {
            return false;
        }
        return true;
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
