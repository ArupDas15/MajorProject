
package com.smart.shop.admin;

import com.block.logic.Block;
import com.block.logic.BlockChain;
import com.block.logic.Transaction;
import com.block.logic.TransactionInput;
import com.block.logic.TransactionOutput;
import com.smart.shop.dao.AdminDAO;
import com.smart.shop.dblogic.AdminDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerifyTransaction extends HttpServlet {

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
        RequestDispatcher rd= null;
        try (PrintWriter out = response.getWriter()) {
            String tid = request.getParameter("tid");
            System.out.println("tid = " + tid);
            
            if(verify(tid)){
                AdminDAO dao = new AdminDao();
                if(dao.updateTransactionDetails(tid)){
                    rd = request.getRequestDispatcher("verifytransactions.jsp");
                    rd.forward(request, response);
                }
                
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

    public static boolean verify(String tid) {

        Block current_block;
        Block previous_block;
        List<Block> blockList;

        blockList = BlockChain.blockchain;

        HashMap<String, TransactionOutput> tempUTXOs = new HashMap<>();

        for (int i = 1; i < blockList.size(); i++) {

            current_block = blockList.get(i);
            previous_block = blockList.get(i - 1);

            if (!current_block.hash.equals(current_block.calculateNewHashValue())) {
                return false;
            }

            if (!previous_block.hash.equals(current_block.previousHash)) {
                return false;
            }

            TransactionOutput tempOutput;
            for (int t = 0; t < current_block.transactions.size(); t++) {
                Transaction currTrnxn = current_block.transactions.get(t);

                if (!currTrnxn.verifySignature()) {
                    return false;
                }
                if (currTrnxn.getInputsValue() != currTrnxn.getOutputsValue()) {
                    return false;
                }

                for (TransactionInput input : currTrnxn.trnxn_inputs) {
                    tempOutput = tempUTXOs.get(input.transactionOutputId);

                    if (tempOutput == null) {
                        return false;
                    }

                    if (input.UTXO.valueCoin != tempOutput.valueCoin) {
                        return false;
                    }

                    tempUTXOs.remove(input.transactionOutputId);
                }

                currTrnxn.trnxn_outputs.forEach((output) -> {
                    tempUTXOs.put(output.id, output);
                });

                if (currTrnxn.trnxn_outputs.get(0).reciepientKey != currTrnxn.reciepientKey) {
                    return false;
                }
                if (currTrnxn.trnxn_outputs.get(1).reciepientKey != currTrnxn.senderKey) {
                    return false;
                }
                if (currTrnxn.trnxn_outputs.stream().anyMatch((transactionOutput) -> (transactionOutput.id.equals(tid)))) {
                    return true;
                }
            }

        }
        return true;
    }
}
