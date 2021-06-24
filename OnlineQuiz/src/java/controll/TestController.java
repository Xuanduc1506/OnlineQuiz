/*
 * Copyright(C)2021, FPT University
 * Lab Java Web
 * 
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2021-05-16         1.0               Ducnxhe141626       First Implement
 */
package controll;

import entity.Answer;
import entity.Question;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class use to display all questions 
 * 
 * @author Xuan Duc
 */
public class TestController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * This method use session to display all question and save the choice that user selected then forward to Test.jsp
     *
     * @param request the object of <code>HttpServletRequest</code>
     * @param response the object of <code>HttpServletRespone</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ArrayList<Question> questions = (ArrayList<Question>) request.getSession().getAttribute("questions");

            String preIndex = request.getParameter("index");
            int index = -1;//            String check = request.getParameter("check");
            if (preIndex != null) {
                index = Integer.parseInt(preIndex);
                for (Answer answer : questions.get(index).getOptions()) {
                    answer.setCheck(false);
                }
                String[] choosed = request.getParameterValues("choosed");
                if (choosed != null) {
                    int id;
                    for (String choose : choosed) {
                        String[] s = choose.split("_");
                        id = Integer.parseInt(s[1]);
                        for (Answer answer : questions.get(index).getOptions()) {
                            if (id == answer.getId()) {
                                answer.setCheck(true);
                            }
                        }
                    }
                }
            }
            String PreCurentIndex = request.getParameter("Curentindex");
            if (PreCurentIndex == null) {
                PreCurentIndex = "0";
            }
            int currentIndex = Integer.parseInt(PreCurentIndex);
            if (index == currentIndex) {
                response.sendRedirect("Result");
            } else {

                Question q = questions.get(currentIndex);
                request.setAttribute("q", q);
                request.setAttribute("total", questions.size());
                request.getRequestDispatcher("Test.jsp").forward(request, response);
            }

        } catch (IOException | NumberFormatException | ServletException e) {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
