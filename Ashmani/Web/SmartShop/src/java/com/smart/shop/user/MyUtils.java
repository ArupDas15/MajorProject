package com.smart.shop.user;


import com.block.config.Global;
import com.block.logic.BlockChain;
import com.block.logic.DeserializeObject;
import com.block.logic.EWallet;
import com.block.logic.SerializeObject;
import com.smart.shop.dao.AdminDAO;
import com.smart.shop.dblogic.AdminDao;
import java.io.File;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dhiraj
 */
public class MyUtils {

    public static void serializeBlockChain() {
        BlockChain object = new BlockChain();
        System.out.println("-----" + object.toString());
        AdminDAO dao = new AdminDao();
        int i = dao.insertBlockchainHashcode(object.hashCode());
        if (i == 1) {
            SerializeObject.serializeInstance(Global.SERIALIZED_DEFAULT_FILE_PATH, Global.BLOCK_FILE_NAME, object);
        } else {
            System.out.println(" Something went wrong during hashcode insertion... ");
        }

    }

    public static void deserializeBlockChain() {
        System.out.println("----------------------------------------------------");
        BlockChain object = (BlockChain) DeserializeObject.deserialzeInstance(Global.SERIALIZED_DEFAULT_FILE_PATH, Global.BLOCK_FILE_NAME);

        System.out.println(object);
        System.out.println("----------------------------------------------------");
    }

    public static boolean walletExist(String mobno) {

        File f = new File(Global.SERIALIZED_DEFAULT_FILE_PATH + mobno + Global.WALLET_FILE_NAME);

        return f.exists() && !f.isDirectory();
    }

    public static void serializeGenesisWallet(EWallet wallet) {
        System.out.println("Wallet = " + wallet);
        SerializeObject.serializeInstance(Global.SERIALIZED_DEFAULT_FILE_PATH, "admin" + Global.WALLET_FILE_NAME, wallet);
        System.out.println(" Wallet saved successfully...");
    }

    public static EWallet deserializeGenesisWallet() {
        System.out.println("Wallet Initialized.\n Wallet deserialization started...");
        EWallet wallet = (EWallet) DeserializeObject.deserialzeInstance(Global.SERIALIZED_DEFAULT_FILE_PATH, "admin" + Global.WALLET_FILE_NAME);
        System.out.println("wallet = " + wallet);
        System.out.println(" Wallet deserialized successfully...");
        return wallet;
    }

    public static void serializeShopWallet(EWallet wallet) {
        System.out.println("Wallet = " + wallet);
        SerializeObject.serializeInstance(Global.SERIALIZED_DEFAULT_FILE_PATH, "shop" + Global.WALLET_FILE_NAME, wallet);
        System.out.println(" Wallet saved successfully...");
    }

    public static EWallet deserializeShopWallet() {
        System.out.println("Wallet already existing.\n Wallet deserialization started...");
        EWallet wallet = (EWallet) DeserializeObject.deserialzeInstance(Global.SERIALIZED_DEFAULT_FILE_PATH, "shop" + Global.WALLET_FILE_NAME);
        System.out.println("wallet = " + wallet);
        System.out.println(" Wallet deserialized successfully...");
        return wallet;
    }

    public static void serializeUserWallet(EWallet wallet, String mobno) {
        System.out.println("Wallet = " + wallet);
        SerializeObject.serializeInstance(Global.SERIALIZED_DEFAULT_FILE_PATH, mobno + Global.WALLET_FILE_NAME, wallet);
        System.out.println(" Wallet saved successfully...");
    }

    public static EWallet deserializeUserWallet(String mobno) {
        System.out.println("Wallet already existing.\n Wallet deserialization started...");
        EWallet wallet = (EWallet) DeserializeObject.deserialzeInstance(Global.SERIALIZED_DEFAULT_FILE_PATH, mobno + Global.WALLET_FILE_NAME);
        System.out.println("wallet = " + wallet);
        System.out.println(" Wallet deserialized successfully...");
        return wallet;
    }
    
    public static void initialize(){
        EWallet adminwallet = new EWallet("admin@gmail.com");
        serializeGenesisWallet(adminwallet);
        
        EWallet shopwallet = new EWallet("shop@gmail.com");
        serializeShopWallet(shopwallet);
    }
    
}
