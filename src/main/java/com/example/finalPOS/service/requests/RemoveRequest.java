package com.example.finalPOS.service.requests;

//item은 품목에 대한 모든 전체적인 정보를 가지고 있는 것이고
//이건 매번 POSTMapping에 의해 넘어온 데이터를 임시로 받기 위해서 사용
public class RemoveRequest {

    //이름,가격,수량
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
