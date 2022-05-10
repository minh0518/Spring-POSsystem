package com.example.Midterm.POS.order;

import com.example.Midterm.POS.inventory.Check;
import com.example.Midterm.POS.inventory.Item;
import com.example.Midterm.POS.inventory.Warehousing;
import com.example.Midterm.POS.statistics.Info;
import com.example.Midterm.POS.statistics.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class OrderServiceImpl implements OrderService{

    private final Check check;
    private final Warehousing warehousing;
    private final Statistics statistics;

    @Autowired
    public OrderServiceImpl(Check check, Warehousing warehousing ,Statistics statistics){
        this.check=check;
        this.warehousing=warehousing;
        this.statistics = statistics;
    }



    @Override
    public Order createOrder(String name, int count) {

        Date orderDate=new Date();
        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat time = new SimpleDateFormat("a hh:mm:ss");

        String orderTime= date.format(orderDate) + time.format(orderDate);

        if((warehousing.findByName(name)==null)){
            System.out.println("해당 상품이 창고에 존재하지 않습니다.");
            return null;
        }

        if(count>=(warehousing.findByName(name)).getCount()){
            System.out.println("창고에 있는 갯수보다 많으므로,최대 수량만큼 구매합니다");
            Item tmp=warehousing.findByName(name);

            warehousing.removeItem(name);

            //통계를위해 여기서 사용
            statistics.makeSellLog(name,new Info(orderTime,(warehousing.findByName(name)).getPrice(),count));


            return new Order(tmp,count,orderTime);
        }
        else{
            System.out.println(count+"(개) 구매합니다");
            warehousing.decreaseCount(name,count);

            //통계를위해 여기서 사용
            statistics.makeSellLog(name,new Info(orderTime,(warehousing.findByName(name)).getPrice(),count));

            //System.out.println("구매정보 입니다");
            return new Order(warehousing.findByName(name),count,orderTime);
        }
    }
}
