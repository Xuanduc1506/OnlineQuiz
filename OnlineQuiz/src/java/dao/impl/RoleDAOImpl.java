/*
 * Copyright(C)2021, FPT University
 * Lab Java Web
 * 
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2021-05-16         1.0               Ducnxhe141626       First Implement
 */
package dao.impl;

import context.DBContext;
import dao.RoleDAO;
import entity.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * This class used to get data from Role table
 *
 * @author Xuan Duc
 */
public class RoleDAOImpl extends DBContext implements RoleDAO{

    /**
     * This method used to get all roles form Role table
     *
     * @return roles is a <code>java.util.ArrayList<></code> object
     * @throws Exception
     */
    @Override
    public ArrayList<Role> getRoles() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Role> roles = new ArrayList<>();
        String sql= "SELECT * FROM Role";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Role role = new Role();
                role.setId(rs.getInt(1));
                role.setName(rs.getString(2));
                roles.add(role);
            }
            
       } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return roles;
    }
    
}
