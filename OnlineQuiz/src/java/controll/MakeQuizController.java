/*
 * Copyright(C)2021, FPT University
 * Lab Java Web
 * 
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2021-05-16         1.0               Ducnxhe141626       First Implement
 */
package controll;

import dao.AnswerDAO;
import dao.QuestionDAO;
import dao.ResultDAO;
import dao.impl.AnswerDAOImpl;
import dao.impl.QuestionDAOImpl;
import dao.impl.ResultDAOImpl;
import entity.Answer;
import entity.Question;
import entity.Result;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 *
 * @author Xuan Duc
 */
public class MakeQuizController extends BaseAuthenticationController {

    /**
     * Handles the HTTP <code>GET</code> method.
     * This method use to forward to MakeQuiz.jsp
     * 
     * 
     * @param request the object of <code>HttpServletRequest</code>
     * @param response the object of <code>HttpServletRespone</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("MakeQuiz.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * This method use QuestionDao to insert into Questions table
     * And use AnswerDAO to insert into Answer table
     * And use ResultDAO to insert into Result table
     *
     * @param request the object of <code>HttpServletRequest</code>
     * @param response the object of <code>HttpServletRespone</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QuestionDAO questionDAO = new QuestionDAOImpl();
            AnswerDAO answerDAO = new AnswerDAOImpl();
            ResultDAO resultDAO = new ResultDAOImpl();

            Question question = new Question();
            Result result = new Result();
            ArrayList<Answer> answers = new ArrayList<>();
            int id = answerDAO.count();

            question.setId(questionDAO.count() + 1);
            question.setQuestion(request.getParameter("question"));
            question.setDateCreated(java.time.LocalDate.now().toString());
            questionDAO.addQuestion(question);
            String[] options = request.getParameterValues("option");
            for (String option : options) {
                id++;
                Answer answer = new Answer();
                answer.setId(id);
                answer.setId_question(question);
                answer.setCheck(false);
                answer.setOption(option);
                answerDAO.addAnswer(answer);
                answers.add(answer);
            }
            question.setOptions(answers);
            int index = Integer.parseInt(request.getParameter("correct"));
            result.setId_question(question.getId());
            result.setId_answer(question.getOptions().get(index).getId());
            resultDAO.addResult(result);
            processGet(request, response);
        } catch (Exception e) {
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }

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
