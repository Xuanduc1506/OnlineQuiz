/*
 * Copyright(C)2021, FPT University
 * Lab Java Web
 * 
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2021-05-16         1.0               Ducnxhe141626       First Implement
 */
package dao.impl;

import context.DBContext;
import dao.AccountDAO;
import entity.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class used to get data from Account table
 *
 * @author Xuan Duc
 */
public class AccountDAOImpl extends DBContext implements AccountDAO {

    /**
     * This method used to get all digital news have title contain the search
     * text form digital table
     *
     * @param username is a <code>String</code>
     * @param password is a <code>String</code>
     * @return account is a <code>Account</code> object
     * @throws Exception
     */
    @Override
    public Account getAccount(String username, String password) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Account account = new Account();
        String sql = "SELECT * FROM Account WHERE username =? AND password = ? ";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                account.setUsername(rs.getString(1));
                account.setPassword(rs.getString(2));
                account.setType(rs.getInt(3));
                account.setEmail(rs.getString(4));
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return account;
    }

    /**
     * This method used to add an account to the Account table
     *
     * @param account is a <code>Account</code>
     * @throws Exception
     */
    @Override
    public void addAccount(Account account) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO [dbo].[Account]\n"
                + "           ([username]\n"
                + "           ,[password]\n"
                + "           ,[userType]\n"
                + "           ,[email])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, account.getUsername());
            ps.setString(2, account.getPassword());
            ps.setInt(3, account.getType());
            ps.setString(4, account.getEmail());
            ps.execute();
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
    }

}
