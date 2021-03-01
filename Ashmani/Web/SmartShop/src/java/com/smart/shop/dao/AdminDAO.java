/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.shop.dao;

import java.util.List;

public interface AdminDAO {

    public boolean loginCheck(String uid, String pass);

    public List getAllCategory();

    public String getProductSeqId(int catid);

    public boolean updateProductSeqId(String cid, String seqId);

    public List getAllProductDetails();

    public String getCategoryName(int catId);

    public int insertProductDetails(String p_id, String p_name, String p_cat, String p_cprice, String p_sprice);

    public int updateProductDetails(String p_id, String p_name, String p_cat, String p_cprice, String p_sprice);

    public String getPreviousHash();

    public int updateHash();

    public int insertTransactionDetails(String trnxnid, double valueCoins);

    public boolean verifyTransaction(String trnxnid);
    
    public boolean updateTransactionDetails(String trnxnid);

    public List getTransactionDetails();

    public int insertBlockchainHashcode(int hashcode);

    public int getBlockchainHashcode();

}
