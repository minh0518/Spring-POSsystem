package com.example.Midterm.POS.statistics;


import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


//OrdeService의 Map은 priavate로 되어 있으므로 OrderServiceImpl에서 접근이 불가능하다
//그러므로 여기서 public 메소드로 따로 구현해 줘야함
@Component
public class StatisticsImpl implements Statistics{


    int total=0;

    private static Map<String, Info> log=new HashMap<>();


    @Override
    //이건 주문할 때 자동으로 여기에도 기록을 하기 위해 사용된 메소드
    public void makeSellLog(String name,Info info){
        log.put(name,info);
    }

    @Override
    public void searchLog(){
        if(log.isEmpty()){
            System.out.println("구매 내역이 없습니다");
        }
        else {
            log.forEach((key, value) -> {
                System.out.println(key + ":" + value);
            });
        }
    }


    @Override
    public void totalIncome(){
        total=0;
        if(log.isEmpty()){
            System.out.println("매출이 존재하지 않습니다");
            return;
        }
        else {
            log.forEach((key, value) -> {
                total+=(value.getPrice()*value.getCount());
            });
        }
        System.out.println("총 매출액 : "+total);
    }

}
