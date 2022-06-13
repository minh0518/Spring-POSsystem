package com.example.finalPOS.service.requests;

public class BuyRequest {

    //이름,수량
    private String itemName;
    private int itemCount;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

}
