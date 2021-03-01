package com.smart.shop.admin;

import com.smart.shop.dblogic.AdminDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.smart.shop.dao.AdminDAO;
import com.smart.shop.logic.SequenceGenerator;
import com.smart.shop.logic.BarcodeTest;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

public class AddProduct extends HttpServlet {

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

        RequestDispatcher rd = null;
        HttpSession session = request.getSession(false);

        try (PrintWriter out = response.getWriter()) {
            String p_name = request.getParameter("pname");
            String p_cat = request.getParameter("pcat");
            String p_cprice = request.getParameter("cprice");
            String p_sprice = request.getParameter("sprice");

            System.out.println("p_name = " + p_name);
            System.out.println("p_cat = " + p_cat);
            System.out.println("p_cprice = " + p_cprice);
            System.out.println("p_sprice = " + p_sprice);

            AdminDAO dao = new AdminDao();
            String newPid = null;
            String oldPid = dao.getProductSeqId(Integer.parseInt(p_cat));
            System.out.println("oldPid = " + oldPid);
            newPid = SequenceGenerator.next(oldPid);
            System.out.println("newPid = " + newPid);
            if (newPid != null) {
                int i = dao.insertProductDetails(newPid, p_name, p_cat, p_cprice, p_sprice);

                if (i == 1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(newPid);
                    sb.append("-");
                    sb.append(p_name);
                    sb.append("-");
                    sb.append(p_sprice);
                    sb.append("-");

                    BarcodeTest.generateBarCode(newPid+"-"+p_name, sb.toString());
                    System.out.println("Barcode generated successfully...");
                    boolean bool = dao.updateProductSeqId(p_cat, newPid);
                    System.out.println("bool = " + bool);
                    if (bool) {
                        session.setAttribute("msg", "Product added successfully...");
                        rd = request.getRequestDispatcher("add_product.jsp");
                        rd.forward(request, response);
                    } else {
                        session.setAttribute("msg", "Oops ! Something went wrong...");
                        rd = request.getRequestDispatcher("add_product.jsp");
                        rd.forward(request, response);
                    }

                } else {
                    session.setAttribute("msg", "Oops ! Something went wrong...");
                    rd = request.getRequestDispatcher("admin.jsp");
                    rd.forward(request, response);
                }
            } else {
                session.setAttribute("msg", "Oops ! Something went wrong...");
                rd = request.getRequestDispatcher("admin.jsp");
                rd.forward(request, response);
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
