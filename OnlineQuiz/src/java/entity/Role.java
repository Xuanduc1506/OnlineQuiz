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
 * This class used to contain attribute and method getter, setter of Role
 *
 * @author Xuan Duc
 */
public class Role {
    
    private int id;
    private String name;

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
     * This method used to get name
     *
     * @return name is a <code>String</code>
     */
    public String getName() {
        return name;
    }

    /**
     * This method used to set name
     *
     * @param name is a <code>String</code>
     */
    public void setName(String name) {
        this.name = name;
    }
    
}
