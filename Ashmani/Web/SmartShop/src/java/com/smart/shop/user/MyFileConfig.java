/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.shop.user;

import com.block.config.Global;
import com.block.config.UserConfig;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arup Das
 */
public class MyFileConfig {
    private double cost;
    private String usrmobile;

    public MyFileConfig() {
        
    }
    
    
    
    public void setVal(String mobile, double cost) {
        this.usrmobile = mobile;
        this.cost = cost;

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(Global.CONTEXT + "data.txt");
            fileWriter.write(mobile);
            fileWriter.write("-");
            fileWriter.write(cost + "");
        } catch (IOException e) {
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.flush();
                    fileWriter.close();
                }
            } catch (IOException e) {
            }
        }
    }

    public double getCost() {
        return cost;
    }

    public String getUsrmobile() {
        return usrmobile;
    }

    public void readdata() {
        try (BufferedReader br = new BufferedReader(new FileReader(Global.CONTEXT+"data.txt"))) {
            String line = br.readLine();

            if (line != null) {
                String arr[] = line.split("-");
                usrmobile = arr[0];
                cost = Double.parseDouble(arr[1]);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserConfig.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UserConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
