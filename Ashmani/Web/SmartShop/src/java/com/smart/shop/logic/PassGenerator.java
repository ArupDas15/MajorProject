package com.smart.shop.logic;

import java.util.Random;


public class PassGenerator {
    
    public static String generatePin()
    {
        int len=8;
        System.out.print("Your new id is : ");
 
        String cap_ltr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String nos = "0123456789";
        String symb = "@#$)";
 
 
        String values = cap_ltr + nos + symb;
 
        Random random = new Random();
 
        StringBuilder sb= new StringBuilder(len);
 
        for (int i = 0; i < len; i++)
        {
            // Use of charAt() method : to get character value
            // Use of nextInt() as it is scanning the value as int
            sb.append(values.charAt(random.nextInt(values.length())));
 
        }
        return sb.toString();

    }
}
