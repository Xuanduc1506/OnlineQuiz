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
import dao.RoleDAO;
import dao.impl.AccountDAOImpl;
import dao.impl.RoleDAOImpl;
import entity.Account;
import entity.Role;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class use to register an account
 * 
 * @author Xuan Duc
 */
public class RegisterController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     * This method use RoleDAO to get data of all role and then forward to Register.jsp
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
            RoleDAO roleDAO = new RoleDAOImpl();
            ArrayList<Role> roles = roleDAO.getRoles();
            request.setAttribute("roles", roles);
            request.getRequestDispatcher("Register.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * This method use AccountDao to insert an account into Account table then send redirect to LoginController
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
            Account account = new Account();
            account.setUsername(request.getParameter("username"));
            account.setPassword(request.getParameter("password"));
            account.setType(Integer.parseInt(request.getParameter("type")));
            account.setEmail(request.getParameter("email"));
            AccountDAO accountDAO = new AccountDAOImpl();
            accountDAO.addAccount(account);
            response.sendRedirect("Login");
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
