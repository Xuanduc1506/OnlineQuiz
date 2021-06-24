/*
 * Copyright(C)2021, FPT University
 * Lab Java Web
 * 
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2021-05-16         1.0               Ducnxhe141626       First Implement
 */
package controll;

import dao.AccountDAO;
import dao.impl.AccountDAOImpl;
import entity.Account;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class used AccountlDAO to get an account by username and password
 * then set session for this account
 *
 * @author Xuan Duc
 */
public class LoginController extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * This method use to forward to Login.jsp
     *
     * 
     * @param request the object of <code>HttpServletRequest</code>
     * @param response the object of <code>HttpServletRespone</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("Login.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * This method use to set an account session
     *
     * 
     * @param request the object of <code>HttpServletRequest</code>
     * @param response the object of <code>HttpServletRespone</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String userName = request.getParameter("username");
            String password = request.getParameter("password");
            AccountDAO accountDAO = new AccountDAOImpl();
            Account account = accountDAO.getAccount(userName, password);
            if (account.getUsername() == null) {
                String message = "Invalid username or password";
                request.setAttribute("message", message);
                request.getRequestDispatcher("Error.jsp").forward(request, response);           
            } else {
                request.getSession().setAttribute("account", account);
                String message = "Login successfully";
                request.setAttribute("message", message);
                request.getRequestDispatcher("Error.jsp").forward(request, response);
            }

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
