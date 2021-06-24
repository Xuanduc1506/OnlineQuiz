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
 * This class used to contain attribute and method getter, setter of Account
 *
 * @author Xuan Duc
 */
public class Account {

    //Create attribute
    private String username;
    private String password;
    private int type;
    private String email;

    /**
     * This method used to get type
     *
     * @return type is an<code>int</code>
     */
    public int getType() {
        return type;
    }

    /**
     * This method used to set type
     *
     * @param type is an <code>int</code>
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * This method used to get email
     *
     * @return email is a <code>String</code>
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method used to set email
     *
     * @param email is a <code>String</code>
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method used to get username
     *
     * @return username is a <code>String</code>
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method used to set username
     *
     * @param username is a <code>String</code>
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method used to get password
     *
     * @return password is a <code>String</code>
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method used to set password
     *
     * @param password is a <code>String</code>
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
