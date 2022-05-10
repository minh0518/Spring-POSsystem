package com.example.Midterm.POS.autowried;

import com.example.Midterm.POS.AutoAppConfig;
import com.example.Midterm.POS.inventory.Check;
import com.example.Midterm.POS.inventory.Warehousing;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowiredTest {


    @Test
    @DisplayName("Warehousing의 구현체인 WarehousingImpl이 Warehousing형태로 빈에 제대로 들어갔는지 확인하는 테스트")
    void warehousingScan(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        Warehousing warehousing=ac.getBean(Warehousing.class);
        System.out.println("warehousing = " + warehousing);
        Assertions.assertThat(warehousing).isInstanceOf(Warehousing.class);
    }

    @Test
    @DisplayName("Check의 구현체인 CheckImpl이 Check형태로 제대로 빈에 들어갔는지 확인하는 테스트")
    void checkScan(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        Check check=ac.getBean(Check.class);
        System.out.println("check = " + check);
        Assertions.assertThat(check).isInstanceOf(Check.class);

    }

}
