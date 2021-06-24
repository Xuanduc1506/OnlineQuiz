/*
 * Copyright(C)2021, FPT University
 * Lab Java Web
 * 
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2021-05-16         1.0               Ducnxhe141626       First Implement
 */
package entity;

/**
 * This class used to contain attribute and method getter, setter of Result
 *
 * @author Xuan Duc
 */
public class Result {
    
    //Create attribute
    private int id_question;
    private int id_answer;

    /**
     * This method used to get id_question
     *
     * @return id_question is an<code>int</code>
     */
    public int getId_question() {
        return id_question;
    }

    /**
     * This method used to set id_question
     *
     * @param id_question is an <code>int</code>
     */
    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

    /**
     * This method used to get id_answer
     *
     * @return id_answer is an<code>int</code>
     */
    public int getId_answer() {
        return id_answer;
    }

    /**
     * This method used to set id_answer
     *
     * @param id_answer is an <code>int</code>
     */
    public void setId_answer(int id_answer) {
        this.id_answer = id_answer;
    }
    
    
}
