package com.example.Midterm.POS.inventory;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//입고
@Component
public class WarehousingImpl implements Warehousing{

    private static Map<String,Item> store=new HashMap<>();


    //Item객체에 있는 날짜는 여기서 find로 Item을 가져온 다음에
    //그걸 Item객체에 담고 그 다음에여기서 getter로 호출 
    @Override
    public void addItem(Item item) {
        
        //기존에 있던 제품인 경우
        if(store.containsKey(item.getName())){
            
            //가격이 변동된 경우
            if(item.getPrice()!=store.get(item.getName()).getPrice()){
                System.out.println("기존에 존재하던 제품과 가격이 다릅니다. 기존 가격으로 사용하시겠습니까?");
                System.out.println("1.예 2.아니요. 이 가격으로 수정합니다");
                while(true) {
                    Scanner input = new Scanner(System.in);
                    int choose = input.nextInt();

                    //여기서 일어나는 수정은 전부 다 기존 map에 있던 것을 가져와서 수정하는 것이다
                    if (choose == 1) {
                        item.setPrice(store.get(item.getName()).getPrice()); //가격 수정
                        item.setCount((store.get(item.getName())).getCount()+item.getCount()); //수량 수정
                        store.put(item.getName(), item);
                        break;
                    } 
                    else if (choose ==2) {
                        item.setCount((store.get(item.getName())).getCount()+item.getCount()); //수량 수정
                        store.remove(item.getName());
                        store.put(item.getName(), item);
                        break;
                    }
                    else {
                        System.out.println("1 or 2를 선택해 주세요");
                        continue;
                    }
                }
                
                
            }
            else {
                item.setCount((store.get(item.getName())).getCount()+item.getCount()); //수량 수정
                store.put(item.getName(), item);
            }

        }
        //처음 입고된 상품의 경우
        else{
            store.put(item.getName(),item);
        }
    }


    //수량 체크 필수
    @Override
    public void removeItem(String name) {

        store.remove(name);

    }
    
    //수량 수정 필요
    //이거하고 인터페이스에다가 추가하기
    @Override
    public void decreaseCount(String name, int count){
        int leftCount=store.get(name).getCount()-count;
        store.get(name).setCount(leftCount);
        store.put(store.get(name).getName(),store.get(name));
    }

    //나중에 리스트 형으로 바꿔야 할수도
    @Override
    public Item findByName(String name){
        return store.get(name);
    }

    @Override
    public void findAll(){

        if(store.isEmpty()){
            System.out.println("창고가 비었습니다");
        }
        else {
            store.forEach((key, value) -> {
                System.out.println(key + ":" + value);
            });
        }
    }
    
}
