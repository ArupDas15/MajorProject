package com.main.project.smartshop;

import java.util.HashMap;
import java.util.Map;

public class Cart{

    private static Map<String,CartItem> myCart = new HashMap<>();


    public static Map<String, CartItem> getMyCart() {
        return myCart;
    }

    public static CartItem addItemToCart(String key,CartItem cartItem){
        return (myCart.put(key,cartItem));
    }

    public static  void refreshCart(){
        myCart.clear();
    }
}
