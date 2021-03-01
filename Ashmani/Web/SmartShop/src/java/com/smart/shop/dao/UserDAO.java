/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.shop.dao;

import java.util.List;

/**
 *
 * @author Dhiraj
 */
public interface UserDAO {

    boolean loginCheck(String uid, String pass);
    boolean registerUser(String name, String email, String pass, String mobno, String dob, String gender);
    boolean checkUserExist(String email);
    public List getTransactionDetails();
}
