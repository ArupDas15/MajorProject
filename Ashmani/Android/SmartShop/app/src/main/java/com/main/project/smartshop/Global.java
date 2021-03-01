package com.main.project.smartshop;



public class Global {
    private String ip;
    private static String url;

    public Global(String ip_address){
        ip = ip_address;
        url = "http://"+ip+":8084/SmartShop/";
    }



    public static String getUrlString(){
        return url;
    }
}
