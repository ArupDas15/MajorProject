package com.smart.shop.logic;

import java.util.Random;

public class PINGenerator {
    
    public static String generatePin(int len)
    {
        System.out.println("Generating password using random() : ");
        System.out.print("Your new password is : ");
 
        String cap_ltr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String sm_ltr = "abcdefghijklmnopqrstuvwxyz";
        String nos = "0123456789";
        String symb = "!@#$%^&*_=+-/.?<>)";
 
 
        String values = cap_ltr + sm_ltr + nos + symb;
 
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
