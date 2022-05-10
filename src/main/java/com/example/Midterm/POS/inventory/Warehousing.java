package com.example.Midterm.POS.inventory;

public interface Warehousing {

    void addItem(Item item);

    void removeItem(String name);

    Item findByName(String name);

    void findAll();

    void decreaseCount(String name, int count);
}
