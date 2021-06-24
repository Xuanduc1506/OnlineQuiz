/*
 * Copyright(C)2021, FPT University
 * Lab Java Web
 * 
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2021-05-16         1.0               Ducnxhe141626       First Implement
 */
package dao;

import entity.Role;
import java.util.ArrayList;

/**
 * This interface class used to contain some method used to implements in another
 * class
 *
 * @author Xuan Duc
 */
public interface RoleDAO {
    /**
     * This method used to get all roles form Role table
     *
     * @return roles is a <code>java.util.ArrayList<></code> object
     * @throws Exception
     */
    public ArrayList<Role> getRoles() throws Exception;
    
}
