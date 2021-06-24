/*
 * Copyright(C)2021, FPT University
 * Lab Java Web
 * 
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2021-05-16         1.0               Ducnxhe141626       First Implement
 */
package entity;

import java.util.ArrayList;

/**
 * This class used to contain attribute and method getter, setter of Question
 *
 * @author Xuan Duc
 */
public class Question {
    
    //Create attributr
    private int id;
    private String question;
    ArrayList<Answer> options = new ArrayList<>();
    private String dateCreated;
    private int index;
    
    /**
     * This method used to get index
     *
     * @return index is an <code>int</code>
     */
    public int getIndex() {
        return index;
    }

    /**
     * This method used to set index
     *
     * @param index is an<code>int</code>
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * This method used to get id
     *
     * @return id is an <code>int</code>
     */
    public int getId() {
        return id;
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
     * This method used to get question
     *
     * @return question is a <code>String</code>
     */
    public String getQuestion() {
        return question;
    }

    /**
     * This method used to set question
     *
     * @param question is a <code>String</code>
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * This method used to get dateCreated
     *
     * @return dateCreated is a <code>String</code>
     */
    public String getDateCreated() {
        return dateCreated;
    }

    /**
     * This method used to set dateCreated
     *
     * @param dateCreated is a <code>String</code>
     */
    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * This method used to get options
     *
     * @return options is a <code>java.util.ArrayList<></code> object
     */
    public ArrayList<Answer> getOptions() {
        return options;
    }

    /**
     * This method used to set options
     *
     * @param options is a <code>java.util.ArrayList<></code>
     */
    public void setOptions(ArrayList<Answer> options) {
        this.options = options;
    }

}
