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
import entity.Account;
import entity.Question;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class use to get some questions
 * 
 * @author Xuan Duc
 */
public class TakeQuizController extends BaseAuthenticationController {

    /**
     * Handles the HTTP <code>GET</code> method.
     * This method use to set attribute an account and then forward to TakeQuiz.jsp
     *
     * @param request the object of <code>HttpServletRequest</code>
     * @param response the object of <code>HttpServletRespone</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account account = (Account) request.getSession().getAttribute("account");
        request.setAttribute("account", account);
        request.getRequestDispatcher("TakeQuiz.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * This method use QuestionDAO to get data of some questions and send redirect to TestController
     *
     * @param request the object of <code>HttpServletRequest</code>
     * @param response the object of <code>HttpServletRespone</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int totalQuiz = Integer.parseInt(request.getParameter("totalQuestion"));
            QuestionDAO qdao = new QuestionDAOImpl();
            ArrayList<Question> questions = qdao.getQuestion(totalQuiz);
            request.getSession().setAttribute("questions", questions);
            response.sendRedirect("Test");
        } catch (Exception e) {
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
