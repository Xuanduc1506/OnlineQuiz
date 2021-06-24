/*
 * Copyright(C)2021, FPT University
 * Lab Java Web
 * 
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2021-05-16         1.0               Ducnxhe141626       First Implement
 */
package controll;

import dao.QuestionDAO;
import dao.impl.QuestionDAOImpl;
import entity.Question;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class use to get data of all questions then forward to ManageQuiz.JSP
 * 
 * @author Xuan Duc
 */
public class ManageQuizController extends BaseAuthenticationController {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * This method use QuestionDAO to get data of all questions then forward to ManageQuiz.jsp
     *
     * @param request the object of <code>HttpServletRequest</code>
     * @param response the object of <code>HttpServletRespone</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QuestionDAO questionDAO = new QuestionDAOImpl();
            String preIndex = request.getParameter("page");
            if (preIndex == null) {
                preIndex = "1";
            }
            int pageindex = Integer.parseInt(preIndex);
            int numRecords = questionDAO.count();
            int totalpage = (numRecords % 10 == 0)
                    ? numRecords / 3
                    : (numRecords / 3) + 1;
            ArrayList<Question> questions = questionDAO.getAll(pageindex, 3);
            request.setAttribute("numRecords", numRecords);
            request.setAttribute("totalpage", totalpage);
            request.setAttribute("pageindex", pageindex);
            request.setAttribute("questions", questions);
            request.getRequestDispatcher("ManageQuiz.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request the object of <code>HttpServletRequest</code>
     * @param response the object of <code>HttpServletRespone</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
