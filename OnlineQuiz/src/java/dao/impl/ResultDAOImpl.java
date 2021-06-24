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
import dao.ResultDAO;
import entity.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class used to get data from Result table
 *
 * @author Xuan Duc
 */
public class ResultDAOImpl extends DBContext implements ResultDAO {

    /**
     * This method used to get result form Result table
     *
     * @param id_question is an <code>int</code>
     * @return result is a <code>Result</code> object
     * @throws Exception
     */
    @Override
    public Result getResult(int id_question) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Result result = new Result();
        String sql = "SELECT * FROM Result Where id_question = " + id_question;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                result.setId_question(rs.getInt(1));
                result.setId_answer(rs.getInt(2));
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return result;

    }

    /**
     * This method used to add a result to the Result table
     *
     * @param result is a <code>Result</code>
     * @throws Exception
     */
    @Override
    public void addResult(Result result) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO [dbo].[Result]\n"
                + "           ([id_question]\n"
                + "           ,[id_answer])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?)";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, result.getId_question());
            ps.setInt(2, result.getId_answer());
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
