package com.example.Midterm.POS.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//재고 조회
@Component
public class CheckImpl implements Check{

    private Warehousing warehousing;

    //재고 조회를 하려면 hashMap이 있는 Warehousing을 여기서 사용해야 함
    @Autowired
    public CheckImpl(Warehousing warehousing){
        this.warehousing=warehousing;
    }


    @Override
    public Item findItem(String name) {
        return warehousing.findByName(name);
    }

    @Override
    public void findAll(){
        warehousing.findAll();
    }
}
