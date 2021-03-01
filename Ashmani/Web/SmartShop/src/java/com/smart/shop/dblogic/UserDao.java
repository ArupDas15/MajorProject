/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.shop.dblogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.smart.shop.dao.UserDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dhiraj
 */
public class UserDao implements UserDAO{

    public UserDao() {
    }

    public Connection con;
    
   
    @Override
    public boolean loginCheck(String uid, String pass) {
        PreparedStatement pstmt;
        ResultSet rs;
        boolean b=false;
        String query="select * from login where email=? and pass=?";
            
        try {
            con = DBConnection.getConn();
            
            pstmt= con.prepareStatement(query);
            pstmt.setString(1, uid);
            pstmt.setString(2, pass);
            
            rs= pstmt.executeQuery();

            if(rs.next()){
                b=true;
            }
            rs.close();
            pstmt.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;}

    @Override
    public boolean registerUser(String name, String email, String pass, String mobno, String dob, String gender) {
        PreparedStatement pstmt,pstmt1;
        
        
        int i=0,j=0;
        String query="insert into m_customer(name,email,dob,gender,mobile,pass) values(?,?,?,?,?,?)";
        String query1="insert into m_cust_login values(?,?)";  
        try {
            con= DBConnection.getConn();
            pstmt= con.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, dob);
            pstmt.setString(4, gender);
            pstmt.setString(5, mobno);
            pstmt.setString(6, pass);
            
            
            
            i= pstmt.executeUpdate();
            
            pstmt1= con.prepareStatement(query1);
            pstmt1.setString(1, email);
            pstmt1.setString(2, pass);
            j= pstmt1.executeUpdate();
            
            pstmt.close();
            pstmt1.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (j == 1  && i == j); 
    }

    @Override
    public boolean checkUserExist(String email) {
        PreparedStatement pstmt;
        ResultSet rs;
        boolean b=false;
        String query="select * from m_customer where email=?";
        
        try {
            con= DBConnection.getConn();
            pstmt= con.prepareStatement(query);
            pstmt.setString(1, email);
            
            rs= pstmt.executeQuery();

            if(!rs.next())
            { } else {
                b=true;
            }
        
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return b;
    }

    @Override
    public List getTransactionDetails() {
        List list = new ArrayList();
        Connection con;
        PreparedStatement pstmt;
        ResultSet rs;
        try {
            con = DBConnection.getConn();
            String query = "select * from m_transaction";
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                list.add(rs.getString("t_id"));
                list.add(rs.getString("t_amount"));
                list.add(rs.getString("t_timestamp"));
            }
            rs.close();
            pstmt.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

}
