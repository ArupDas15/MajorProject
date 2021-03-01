package com.smart.shop.dblogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.smart.shop.dao.AdminDAO;
import java.sql.Statement;
import java.sql.Timestamp;

public class AdminDao implements AdminDAO {

    public AdminDao() {

    }

    @Override
    public boolean loginCheck(String uid, String pass) {
        PreparedStatement pstmt;
        ResultSet rs;
        Connection con;
        boolean b = false;

        String query = "select * from m_puser_login where adminid=? and pass=?";

        try {
            con = DBConnection.getConn();
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, uid);
            pstmt.setString(2, pass);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                b = true;
            }
            rs.close();
            pstmt.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }

    @Override
    public List getAllCategory() {
        List list = new ArrayList();
        Connection con;
        PreparedStatement pstmt;
        ResultSet rs;

        String query = "select * from m_category";

        try {
            con = DBConnection.getConn();
            pstmt = con.prepareStatement(query);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                list.add(rs.getString(1));
                list.add(rs.getString(2));
            }
            rs.close();
            pstmt.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    @Override
    public List getAllProductDetails() {
        List list = new ArrayList();
        Connection con;
        PreparedStatement pstmt;
        ResultSet rs;

        String query = "select * from m_product";

        try {
            con = DBConnection.getConn();
            pstmt = con.prepareStatement(query);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                list.add(rs.getString(1));
                list.add(rs.getString(2));
                list.add(rs.getString(3));
                list.add(rs.getString(4));
                list.add(rs.getString(5));
            }
            rs.close();
            pstmt.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    @Override
    public int insertProductDetails(String p_id, String p_name, String p_cat, String p_cprice, String p_sprice) {
        PreparedStatement pstmt;
        ResultSet rs;
        Connection con;
        int status = 0;

        String query = "insert into m_product(p_id,p_name,p_catid,p_cprice,p_sprice) values(?,?,?,?,?)";

        try {
            con = DBConnection.getConn();
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, p_id);
            pstmt.setString(2, p_name);
            pstmt.setString(3, p_cat);
            pstmt.setString(4, p_cprice);
            pstmt.setString(5, p_sprice);

            status = pstmt.executeUpdate();

            pstmt.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    @Override
    public int updateProductDetails(String p_id, String p_name, String p_cat, String p_cprice, String p_sprice) {
        PreparedStatement pstmt;
        Connection con;
        int status = 0;

        String query = "insert into m_product(p_name,p_catid,p_cprice,p_sprice) values(?,?,?,?)";

        try {
            con = DBConnection.getConn();
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, p_name);
            pstmt.setString(2, p_cat);
            pstmt.setString(3, p_cprice);
            pstmt.setString(4, p_sprice);

            status = pstmt.executeUpdate();

            pstmt.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    @Override
    public String getCategoryName(int catId) {
        Connection con;
        PreparedStatement pstmt;
        ResultSet rs;
        String val = null;

        String query = "select c_name from m_category where c_id = ?";

        try {
            con = DBConnection.getConn();
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, catId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                val = rs.getString("c_name");
            }
            rs.close();
            pstmt.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return val;
    }

    @Override
    public String getPreviousHash() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateHash() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertTransactionDetails(String trnxnid, double valueCoins) {
        PreparedStatement pstmt;
        Connection con;
        int status = 0;

        String query = "insert into m_transaction values(?,?,?,?)";

        try {
            con = DBConnection.getConn();
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, trnxnid);
            pstmt.setDouble(2, valueCoins);
            pstmt.setObject(3, new Timestamp(System.currentTimeMillis()));
            pstmt.setString(4, "false");

            status = pstmt.executeUpdate();

            pstmt.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    @Override
    public String getProductSeqId(int cid) {
        Connection con;
        PreparedStatement pstmt;
        ResultSet rs;
        String nid = "";
        try {
            System.out.println("cid = " + cid);
            con = DBConnection.getConn();
            String query = "select * from m_category where c_id= ?";
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, cid);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                nid = rs.getString("bar_prev_code");
            }
            rs.close();
            pstmt.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return nid;
    }

    @Override
    public boolean updateProductSeqId(String cid, String seqId) {
        Connection con;
        PreparedStatement pstmt;
        boolean status = false;
        try {
            con = DBConnection.getConn();
            String query = "update  m_category set bar_prev_code =? where c_id=?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, seqId);
            pstmt.setInt(2, Integer.parseInt(cid));

            if (pstmt.executeUpdate() == 1) {
                status = true;
            }

            pstmt.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }

    @Override
    public int insertBlockchainHashcode(int hashcode) {
        PreparedStatement pstmt;
        Connection con = null;
        int status = 0;

        try {
            con = DBConnection.getConn();
            String qry = "TRUNCATE m_block";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(qry);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            String query = "insert into m_block values(?,?)";
            pstmt = con.prepareStatement(query);
            pstmt.setObject(1, new Timestamp(System.currentTimeMillis()));
            pstmt.setInt(2, hashcode);

            status = pstmt.executeUpdate();

            pstmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    @Override
    public int getBlockchainHashcode() {
        Connection con;
        PreparedStatement pstmt;
        ResultSet rs;
        int hash = 0;
        try {
            con = DBConnection.getConn();
            String query = "select * from m_block";
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                hash = Integer.parseInt(rs.getString("hash"));
            }
            rs.close();
            pstmt.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return hash;
    }

    public int findNoOfRow(String tname) {
        Connection con;
        PreparedStatement pstmt;
        ResultSet rs;
        int i = 0;
        try {
            con = DBConnection.getConn();
            String query = "select * from " + tname;
            pstmt = con.prepareStatement(query);

            rs = pstmt.executeQuery();

            i = rs.last() ? rs.getRow() : 0;

            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return i;
    }

    @Override
    public boolean verifyTransaction(String trnxnid) {
        return true;
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
                list.add(rs.getString("t_status"));
            }
            rs.close();
            pstmt.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    @Override
    public boolean updateTransactionDetails(String trnxnid) {
        Connection con;
        PreparedStatement pstmt;
        boolean status = false;
        try {
            con = DBConnection.getConn();
            String query = "update  m_transaction set t_status =? where t_id=?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, "true");
            pstmt.setString(2, trnxnid);

            if (pstmt.executeUpdate() == 1) {
                status = true;
            }

            pstmt.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }
}
