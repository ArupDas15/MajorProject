/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.shop.dblogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.smart.shop.config.DBGlobal;

/**
 *
 * @author Dhiraj
 */
public class DBConnection 
{
    private static Connection con = null;
    public static Connection getConn() throws ClassNotFoundException, SQLException
    {
        Class.forName(DBGlobal.driverClassPath);
        con= DriverManager.getConnection(DBGlobal.url, DBGlobal.user, DBGlobal.password);
      
        return con;
    }
}
