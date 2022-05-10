package com.example.Midterm.POS.check;

import com.example.Midterm.POS.AutoAppConfig;
import com.example.Midterm.POS.inventory.Check;
import com.example.Midterm.POS.inventory.Item;
import com.example.Midterm.POS.inventory.Warehousing;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CheckTest {


    @Test
    @DisplayName("checkImpl에서 findItem을 사용하면 Warehousing을 통해서 제대로 가져와지는지 확인")
    void findItemIncheck(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        
        //아이템 등록
        Warehousing warehousing=ac.getBean(Warehousing.class);

        Item item1 = new Item(1L, "item1","1", "100");
        Item item2 = new Item(2L, "item2","1", "100");
        Item item3 = new Item(3L, "item3","1", "100");
        warehousing.addItem(item1);
        warehousing.addItem(item2);
        warehousing.addItem(item3);

        
        //등록된 것을 확인
        Check check=ac.getBean(Check.class);
        
        Item findItem=check.findItem(2L);

        //여기서 선언한 것과 등록한 것이 같은지 확인
        Assertions.assertThat(findItem).isEqualTo(item2);
        
        



    }
}
