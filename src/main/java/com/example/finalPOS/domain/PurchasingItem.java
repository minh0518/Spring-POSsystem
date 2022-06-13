package com.example.finalPOS.domain;

public class PurchasingItem {

    private String itemName;
    private int itemPrice;
    private String plusDate;
    private int itemCount;
    private int totalPrice;


    public PurchasingItem(String itemName, int itemPrice, String plusDate, int itemCount, int totalPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.plusDate = plusDate;
        this.itemCount = itemCount;
        this.totalPrice = totalPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getPlusDate() {
        return plusDate;
    }

    public void setPlusDate(String plusDate) {
        this.plusDate = plusDate;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
