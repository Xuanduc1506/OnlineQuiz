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
 * This class used to contain attribute and method getter, setter of Answer
 *
 * @author Xuan Duc
 */
public class Answer {
    //Create attribulte
    private int id;
    private String option;
    private boolean check;
    private Question id_question;
    
    /**
     * This method used to get id
     *
     * @return id is an <code>int</code>
     */
    public int getId() {
        return id;
    }

    /**
     * This method used to get check
     *
     * @return check is a <code>boolean</code>
     */
    public boolean isCheck() {
        return check;
    }

    /**
     * This method used to set check
     *
     * @param check is a <code>boolean</code>
     */
    public void setCheck(boolean check) {
        this.check = check;
    }

    /**
     * This method used to set id
     *
     * @param id is an<code>int</code>
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * This method used to get option
     *
     * @return option is a <code>String</code>
     */
    public String getOption() {
        return option;
    }

    /**
     * This method used to set option
     *
     * @param option is a <code>String</code>
     */
    public void setOption(String option) {
        this.option = option;
    }

    public Question getId_question() {
        return id_question;
    }

    /**
     * This method used to set id_question
     *
     * @param id_question is a <code>Question</code> object
     */
    public void setId_question(Question id_question) {
        this.id_question = id_question;
    }
    
}
