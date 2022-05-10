package com.example.Midterm.POS.order;


import com.example.Midterm.POS.inventory.Item;

import java.util.Date;

//판매가 완료되면 만들어지는 객체
public class Order {
    
    //총 판매 가격을 작성하기 위해 hashMap을 추가로 작성해야 할듯
    private Item item;
    private String orderDate;
    private int count;
    

    public Order(Item item,int count,String orderDate) {
        this.item = item;
        this.count=count;
        this.orderDate = orderDate;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    @Override
    public String toString() {
        return "상품 이름:"+item.getName()
                +" 구매수량:"+count+"(개)"
                +" 총가격:"+count*item.getPrice()+"원"
                +" 구매날짜:"+orderDate;

    }

}
