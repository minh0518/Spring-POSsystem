package com.example.Midterm.POS.inventory;

public interface Check {
    //조회, 입고

    Item findItem(String name);

    void findAll();

}
