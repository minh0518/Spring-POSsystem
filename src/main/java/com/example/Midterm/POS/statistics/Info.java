package com.example.Midterm.POS.statistics;

import java.util.Date;

public class Info {

    private String date;
    private int price;
    private int count;

    public Info(String date, int price,int count) {
        this.date = date;
        this.price = price;
        this.count=count;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "\n"
                +"구매 가격 : " +price
                +" 구매날짜 : "+date+","
                +" 구매수량 : "+count
                +"\n";
    }
}
