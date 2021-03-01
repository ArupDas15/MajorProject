/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.block.logic;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class DeserializeObject {

//    public static void main(String args[]) {
//        System.out.println("----------------------------------------------------");
//        
//
//        EWallet object = (EWallet) obj.deserialzeAddress("C:/Users/Dhiraj/Desktop/", "wallet");
//        BlockChain object = (BlockChain) deserialzeInstance("C:/Users/Dhiraj/Desktop/", "block");
//
//        System.out.println(object);
//        System.out.println("----------------------------------------------------");
//    }

    public static Object deserialzeInstance(String dir, String from) {
        Object object = null;
        FileInputStream fin = null;
        ObjectInputStream ois = null;

        try {

            fin = new FileInputStream(dir + from);
            ois = new ObjectInputStream(fin);
            object = ois.readObject();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return object;

    }
}
