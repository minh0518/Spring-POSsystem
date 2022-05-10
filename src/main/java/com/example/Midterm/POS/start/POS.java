package com.example.Midterm.POS.start;

import com.example.Midterm.POS.AutoAppConfig;
import com.example.Midterm.POS.inventory.*;
import com.example.Midterm.POS.login.Login;
import com.example.Midterm.POS.order.Order;
import com.example.Midterm.POS.order.OrderService;
import com.example.Midterm.POS.order.OrderServiceImpl;
import com.example.Midterm.POS.statistics.Statistics;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class POS {

    static ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

    static OrderService orderService=ac.getBean(OrderServiceImpl.class);
    static Warehousing warehousing=ac.getBean(WarehousingImpl.class);
    static Check check=ac.getBean(CheckImpl.class);
    static Statistics statistics=ac.getBean(Statistics.class);

    

    
    //가격 기능 추가

    //구매 날짜를 Date객체로
    public static void main(String[] args) {


        while (true) {
            if (login()) {
                System.out.println("로그인이 완료되었습니다");
                break;
            } else {
                System.out.println("로그인에 실패했습니다");
            }
        }

        while(true) {

            getMenus();//메뉴들 출력

            int number=scanNumber();
            if(number==4){
                return;
            }
            else{
                selectMenu(number);
            }
       }

    }

    public static void getMenus(){
        System.out.println("");
        System.out.println("===============메뉴 선택===============");
        System.out.println("1.상품 구매");
        System.out.println("2.재고 관리");
        System.out.println("3.통계");
        System.out.println("4.종료");
        System.out.println("===============++++++++===============");
        System.out.println("");
    }


    public static int scanNumber(){
        System.out.println("번호를 입력하세요");
        Scanner input = new Scanner(System.in);
        int selectNumber = input.nextInt();
        return selectNumber;
    }


    public static void selectMenu(int scanNumber){
        if(scanNumber>=5 && scanNumber<=0){
            System.out.println("다시 입력해 주세요");
            return;
        }
        switch (scanNumber){
            case 1:
                System.out.println("<상품구매>");
                System.out.println("");
                selling();
                break;
            case 2:
                System.out.println("<재고 관리>");
                System.out.println("");
                manage();
                break;
            case 3:
                System.out.println("<통계>");
                System.out.println("");
                statics();
                break;


        }
    }




    public static boolean login(){
        System.out.println("================로그인================");
        Scanner input = new Scanner(System.in);
        System.out.print("ID:");
        String id = input.next();
        System.out.print("PASSWORD: ");
        int password = input.nextInt();

//        if(id.equals("minho")&&password==123){
//            return true;
//        }
//        else{
//            return false;
//        }

        if(new Login(id,password).checkAccount()){
            return true;
        }
        else{
            return false;
        }


    }










    public static void manage(){

        while (true) {

            System.out.println("");
            System.out.println("=============선택 해 주세요============");
            System.out.println("1.상품 입고");
            System.out.println("2.상품 제거");
            System.out.println("3.창고 조회");
            System.out.println("4.뒤로가기");
            System.out.println("=============++++++++++++============");
            System.out.println("");

            switch (scanNumber()) {
                case 1:
                    System.out.println("입고할 상품의 이름 ,가격, 수량을 입력해 주세요");
                    Scanner input = new Scanner(System.in);
                    //long id = input.nextInt();
                    String name = input.next();
                    int price = input.nextInt();
                    int count = input.nextInt();
                    warehousing.addItem(new Item(name, price, count));
                    System.out.println("입고가 완료되었습니다!");
                    break;
                case 2:
                    System.out.println("어느 상품을 제거하시겠습니까?");
                    System.out.println("=====================================");
                    check.findAll();
                    Scanner input2 = new Scanner(System.in);
                    String select=input2.next();
                    
                    warehousing.removeItem(select);

                    System.out.println("상품이 성공적으로 제거 되었습니다!");
                    System.out.println("=====================================");

                    check.findAll();

                    break;
                case 3:
                    check.findAll();
                    break;
                case 4:
                    System.out.println("재고 관리를 종료합니다");
                    return;

            }
        }
    }



    public static void selling(){

        System.out.println("=============구매 가능 목록=============");
        check.findAll();
        System.out.println("구매하고자 하는 품목, 수량을 입력해 주세요 (뒤로가기: 'x' 입력)");

        Scanner input = new Scanner(System.in);
        String name= input.next();
        if(name.equals("x")){
            return;
        }
        int count=input.nextInt();


        Order order = orderService.createOrder(name, count);
        if(order!=null){
            System.out.println("<<구매 내역>>");
            System.out.println(orderService.createOrder(name,count));
        }

    }



    public static void statics(){

        System.out.println("================통계=================");
        System.out.println("1.판매 내역 2.총 매출액 3.뒤로가기");


        while(true) {
            Scanner input = new Scanner(System.in);
            int select=input.nextInt();
            if(select==3){
                return;
            } else if (select == 1) {
                statistics.searchLog();
                break;
            } else if (select == 2) {
                statistics.totalIncome();
                break;
            } else {
                System.out.println("1과 2중에서 입력해 주세요");
            }
        }

    }

}
