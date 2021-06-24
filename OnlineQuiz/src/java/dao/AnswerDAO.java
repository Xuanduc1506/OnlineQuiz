/*
 * Copyright(C)2021, FPT University
 * Lab Java Web
 * 
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2021-05-16         1.0               Ducnxhe141626       First Implement
 */
package dao;

import entity.Answer;

/**
 * This interface class used to contain some method used to implements in another
 * class
 *
 * @author Xuan Duc
 */
public interface AnswerDAO {
    /**
     * This method used to add an answer to the Answer table
     *
     * @param answer is a <code>Answer</code>
     * @throws Exception
     */    
    public void addAnswer(Answer answer) throws Exception;
    
    /**
     * This method used to get number of answers form Answer table
     *
     * @return count is an <code>int</code>
     * @throws Exception
     */
    public int count() throws Exception;
    
}
