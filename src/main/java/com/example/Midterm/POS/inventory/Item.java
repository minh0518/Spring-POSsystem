package com.example.Midterm.POS.inventory;

//도메인 객체
public class Item {

    private String name;
    private int price;
    private int count;

    public Item(String name , int price , int count) {
        //this.id = id;
        this.name=name;
        //this.date = date;
        this.price = price;
        this.count= count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                +"가격:"+price+"원"
                +" 수량:"+count
                +"\n";
    }


}
