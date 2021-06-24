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
import dao.AnswerDAO;
import entity.Answer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class used to get data from Answer table
 *
 * @author Xuan Duc
 */
public class AnswerDAOImpl extends DBContext implements AnswerDAO {
    /**
     * This method used to add an answer to the Answer table
     *
     * @param answer is a <code>Answer</code>
     * @throws Exception
     */    
    @Override
    public void addAnswer(Answer answer) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO [dbo].[Answer]\n"
                + "           ([id]\n"
                + "           ,[option]\n"
                + "           ,[id_question]\n"
                + "           ,[check])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, answer.getId());
            ps.setString(2, answer.getOption());
            ps.setInt(3, answer.getId_question().getId());
            ps.setBoolean(4, false);
            ps.execute();
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }

    }

    /**
     * This method used to get number of answers form Answer table
     *
     * @return count is an <code>int</code>
     * @throws Exception
     */
    @Override
    public int count() throws Exception {
        int count = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(*) FROM Answer ";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return count;
    }

}
