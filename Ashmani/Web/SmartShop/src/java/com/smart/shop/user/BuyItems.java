/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.shop.user;

import com.block.config.UserConfig;
import com.block.logic.Transaction;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;

/**
 *
 * @author Dhiraj
 */
public class BuyItems extends HttpServlet {

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
            throws ServletException, IOException, JSONException, InstantiationException, IllegalAccessException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            System.out.println(" = = = = = = = = = = = = = = = = = =");

            String mobile = request.getParameter("mob");
            System.out.println("mobile = " + mobile);
            double cost = Double.parseDouble(request.getParameter("total"));
            System.out.println("total cost = " + cost);
            
            MyFileConfig config = new MyFileConfig();
            config.setVal(mobile, cost);
            
            System.out.println("mobile = " + config.getUsrmobile());
            
            System.out.println("cost = " + config.getCost());
            
//            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
//            if (!UserConfig.flag) {
//            MainProcess.createGenesisBlock(mobile);
//                UserConfig.flag = true;
//            }
//            MainProcess.doTransaction(UserConfig.prevBlock, MyUtils.deserializeUserWallet(mobile), MyUtils.deserializeShopWallet(), cost);
//            System.out.println("--------------------Check blockchain is valid or not-------------------");
//            boolean bool = isChainValid();
//
//            System.out.println("\nIs blockchain valid : " + bool);
            

            out.print("Transaction Successfull-" + Transaction.myretval + "-" + "shop@gmail.com");
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
        try {
            processRequest(request, response);
        } catch (JSONException ex) {
            Logger.getLogger(BuyItems.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(BuyItems.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BuyItems.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (JSONException ex) {
            Logger.getLogger(BuyItems.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(BuyItems.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BuyItems.class.getName()).log(Level.SEVERE, null, ex);
        }
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
