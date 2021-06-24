/*
 * Copyright(C)2021, FPT University
 * Lab Java Web
 * 
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2021-05-16         1.0               Ducnxhe141626       First Implement
 */
package controll;

import dao.ResultDAO;
import dao.impl.ResultDAOImpl;
import entity.Answer;
import entity.Question;
import entity.Result;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class use to calculate the mark of the test
 * 
 * @author Xuan Dưc
 */
@WebServlet(name = "ResultController", urlPatterns = {"/Result"})
public class ResultController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     * This method use ResultDAO to check the correct answer and calculate the mark then forward to Result.jsp
     *
     * @param request the object of <code>HttpServletRequest</code>
     * @param response the object of <code>HttpServletRespone</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ArrayList<Question> questions = (ArrayList<Question>) request.getSession().getAttribute("questions");
        Cookie[] cookies = request.getCookies();
        for (Cookie cooky : cookies) {
            if(cooky.getName().equals("temp_value")){
                cooky.setValue("10");
                cooky.setMaxAge(0);
                response.addCookie(cooky);
            }
        }
        try {
            int mark=0;
            ResultDAO resultDAO = new ResultDAOImpl();
            for (Question question : questions) {
                int count=0;
                Result result = resultDAO.getResult(question.getId());
                for (Answer answer : question.getOptions()) {
                    if(answer.isCheck()==true){
                        if(answer.getId()==result.getId_answer()){
                            mark++;
                            count++;
                        }else{
                            if(count>0) mark--;
                            break;
                        }
                    }
                }
            }
            request.setAttribute("totalQuestion", questions.size());
            request.setAttribute("mark", (float)mark/questions.size());
            request.getRequestDispatcher("Result.jsp").forward(request, response);

        } catch (Exception e) {
            
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request the object of <code>HttpServletRequest</code>
     * @param response the object of <code>HttpServletRespone</code>
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
     * @param request the object of <code>HttpServletRequest</code>
     * @param response the object of <code>HttpServletRespone</code>
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
