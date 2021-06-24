/*
 * Copyright(C)2021, FPT University
 * Lab Java Web
 * 
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2021-05-16         1.0               Ducnxhe141626       First Implement
 */
package dao;

import entity.Result;


/**
 * This interface class used to contain some method used to implements in another
 * class
 *
 * @author Xuan Duc
 */
public interface ResultDAO {
    
    /**
     * This method used to get result form Result table
     *
     * @param id_question is an <code>int</code>
     * @return result is a <code>Result</code> object
     * @throws Exception
     */
    public Result getResult(int id_question)throws Exception ;
    
    /**
     * This method used to add a result to the Result table
     *
     * @param result is a <code>Result</code>
     * @throws Exception
     */
    public void addResult(Result result) throws Exception;
    
    
}
