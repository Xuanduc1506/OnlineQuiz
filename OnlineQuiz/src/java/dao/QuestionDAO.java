/*
 * Copyright(C)2021, FPT University
 * Lab Java Web
 * 
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2021-05-16         1.0               Ducnxhe141626       First Implement
 */
package dao;

import entity.Question;
import java.util.ArrayList;

/**
 * This interface class used to contain some method used to implements in another
 * class
 *
 * @author Xuan Duc
 */
public interface QuestionDAO {
    /**
     * This method used to get random some questions form Questions table
     *
     * @param totalQuestion is an <code>int</code>
     * @return questions is a <code>java.util.ArrayList<></code> object
     * @throws Exception
     */
    public ArrayList<Question> getQuestion(int totalQuestion)throws Exception ;
    
    /**
     * This method used to get number of questions form Questions table
     *
     * @return count is an <code>int</code>
     * @throws Exception
     */
    public int count() throws Exception;
    
    /**
     * This method used to add a question to the Questions table
     *
     * @param question is a <code>Question</code>
     * @throws Exception
     */
    public void addQuestion(Question question) throws Exception;
    
    
    /**
     * This method used to get all question form Questions table
     *
     * @param pageindex is an <code>int</code>
     * @param pagesize is an <code>int</code>
     * @return questions is a <code>java.util.ArrayList<></code> object
     * @throws Exception
     */
    public ArrayList<Question> getAll(int pageindex, int pagesize) throws Exception;
        
}
