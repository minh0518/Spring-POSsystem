package com.example.Midterm.POS.inventory;

public interface Check {
    //์กฐํ, ์๊ณ 

    Item findItem(String name);

    void findAll();

}
