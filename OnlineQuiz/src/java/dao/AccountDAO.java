/*
 * Copyright(C)2021, FPT University
 * Lab Java Web
 * 
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2021-05-16         1.0               Ducnxhe141626       First Implement
 */
package dao;

import entity.Account;

/**
 * This interface class used to contain some method used to implements in another
 * class
 *
 * @author Xuan Duc
 */
public interface AccountDAO {
    
    /**
     * This method used to get all digital news have title contain the search
     * text form digital table
     *
     * @param username is a <code>String</code>
     * @param password is a <code>String</code>
     * @return account is a <code>Account</code> object
     * @throws Exception
     */
    public Account getAccount(String username,String password ) throws Exception;       
    
    /**
     * This method used to add an account to the Account table
     *
     * @param account is a <code>Account</code>
     * @throws Exception
     */
    public void addAccount(Account account) throws Exception;
}

