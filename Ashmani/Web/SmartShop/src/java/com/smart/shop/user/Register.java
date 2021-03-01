/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.shop.user;

import com.smart.shop.dblogic.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.smart.shop.dao.UserDAO;

/**
 *
 * @author Dhiraj
 */
public class Register extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        UserDAO dao = new UserDao();
        try (PrintWriter out = response.getWriter()) {
        
            String fname     = request.getParameter("fname");
            String lname     = request.getParameter("lname");
            String uname     = request.getParameter("uname");
            String dob      = request.getParameter("dob");
            String gender   = request.getParameter("gender");
            String mobile   = request.getParameter("mobile");
            String pass     = request.getParameter("pass");
            
            
            boolean bool= dao.checkUserExist(uname);
            System.out.println("bool = " + bool);
            if(!bool){
                String name= fname+" "+lname;
                boolean queryStatus= dao.registerUser(name, uname, dob, gender, mobile, pass);
            
                if(queryStatus){
                    System.out.println("uid = "+ uname);
                    System.out.println("msg : You have successfully registered...");   
                }else{
                    System.out.println("msg : Oops! Something went wrong...");
                } 
            }else{
                System.out.println("uid = "+ uname);
                System.out.println("msg : You are already registered user...");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
