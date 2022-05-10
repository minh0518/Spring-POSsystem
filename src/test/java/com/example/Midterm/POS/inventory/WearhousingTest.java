package com.example.Midterm.POS.inventory;

import com.example.Midterm.POS.AutoAppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class WearhousingTest {


    @Test
    @DisplayName("WarehousingImpl의 HashMap에 제대로 저장이 되는지 확인")
    void addItem(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        Warehousing warehousing=ac.getBean(Warehousing.class);

        Item item = new Item(1L, "item1","1", "100");

        warehousing.addItem(item);
        Item findItem=warehousing.findById(1L);

        //warehousing.findAll();

        Assertions.assertThat(item).isEqualTo(findItem);


    }
}
