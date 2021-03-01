package com.main.project.smartshop;


public class CartItem {

    private String itemId;
    private String itemName;
    private int noOfItems;
    private double itemPrice;



    public CartItem() {

    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setNoOfItems(int noOfItems) {
        this.noOfItems = noOfItems;
    }


    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public int getNoOfItems() {
        return noOfItems;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "itemId='" + itemId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", noOfItems=" + noOfItems +
                ", itemPrice=" + itemPrice +
                '}';
    }

}
