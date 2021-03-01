package com.smart.shop.logic;

import com.block.config.Global;
import com.businessrefinery.barcode.Barcode;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BarcodeTest {
    
    public static void generateBarCode(String productId, String text) {
        try {
            Barcode barcode = new Barcode();
            barcode.setSymbology(Barcode.CODE128);
            System.out.println("text = " + text);
            barcode.setCode(text);
            barcode.setDisplayText(false);
            barcode.setAddChecksum(false);
            barcode.setBarcodeHeight(100);
            barcode.setBarcodeWidth(100);
            barcode.drawImage2File(Global.BARCODE_PATH + productId + ".png");
        } catch (Exception ex) {
            Logger.getLogger(BarcodeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

//    public static void main(String[] args) {
//        generateBarCode("123456", "1234-qwerty-45");
//    }
}
