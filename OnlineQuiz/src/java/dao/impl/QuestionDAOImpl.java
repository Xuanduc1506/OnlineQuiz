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
import dao.QuestionDAO;
import entity.Answer;
import entity.Question;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * This class used to get data from Question table
 *
 * @author Xuan Duc
 */
public class QuestionDAOImpl extends DBContext implements QuestionDAO {

    /**
     * This method used to get random some questions form Questions table
     *
     * @param totalQuestion is an <code>int</code>
     * @return questions is a <code>java.util.ArrayList<></code> object
     * @throws Exception
     */
    @Override
    public ArrayList<Question> getQuestion(int totalQuestion) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Question> questions = new ArrayList<>();
        String sql = "SELECT * FROM \n"
                + "(SELECT TOP(?)* FROM Questions q  \n"
                + "ORDER BY NEWID()) tbl\n"
                + "inner join Answer a on tbl.id = a.id_question";
        try {
            int index = 0;
            Question question = new Question();
            question.setId(-1);
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, totalQuestion);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (question.getId() != rs.getInt(1)) {
                    question = new Question();
                    question.setId(rs.getInt(1));
                    question.setQuestion(rs.getString(2));
                    question.setDateCreated(rs.getString(3));
                    question.setIndex(index);
                    questions.add(question);
                    index++;
                }
                Answer answer = new Answer();
                answer.setId(rs.getInt(4));
                answer.setOption(rs.getString(5));
                answer.setCheck(rs.getBoolean(7));
                answer.setId_question(question);
                question.getOptions().add(answer);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return questions;
    }

    /**
     * This method used to get number of questions form Questions table
     *
     * @return count is an <code>int</code>
     * @throws Exception
     */
    @Override
    public int count() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        String sql = "SELECT  count(*) FROM Questions";
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

    /**
     * This method used to add a question to the Questions table
     *
     * @param question is a <code>Question</code>
     * @throws Exception
     */
    @Override
    public void addQuestion(Question question) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO [dbo].[Questions]\n"
                + "           ([id]\n"
                + "           ,[question]\n"
                + "           ,[dateCreated])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, question.getId());
            ps.setString(2, question.getQuestion());
            ps.setString(3, question.getDateCreated());
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
     * This method used to get all question form Questions table
     *
     * @param pageindex is an <code>int</code>
     * @param pagesize is an <code>int</code>
     * @return questions is a <code>java.util.ArrayList<></code> object
     * @throws Exception
     */
    @Override
    public ArrayList<Question> getAll(int pageindex, int pagesize) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Question> questions = new ArrayList<>();
        String sql = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY id ASC) as rid,* \n"
                + "                                   FROM Questions  ) tbl \n"
                + "                                    WHERE rid >= (? - 1)*? + 1\n"
                + "                                    AND rid <= ? * ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pageindex);
            ps.setInt(2, pagesize);
            ps.setInt(3, pagesize);
            ps.setInt(4, pageindex);
            rs = ps.executeQuery();
            while (rs.next()) {
                Question question = new Question();
                question.setId(rs.getInt(2));
                question.setQuestion(rs.getString(3));
                question.setDateCreated(rs.getString(4));
                questions.add(question);
            }
       } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return questions;
    }

}
