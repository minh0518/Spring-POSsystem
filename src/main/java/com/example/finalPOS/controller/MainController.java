package com.example.finalPOS.controller;

import com.example.finalPOS.domain.PurchasingItem;
import com.example.finalPOS.domain.WarehousingItem;
import com.example.finalPOS.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    private final RegisterService registerService;

    @Autowired
    public MainController(RegisterService registerService) {
        this.registerService = registerService;
    }



    //로그인
    @GetMapping({"/","/login"})
    public String login() {
        return "login";
    }


    @GetMapping("/home")
    public String home(){
        return "home";
    }


    //재고 관리
    @GetMapping("/home/warehousing/menu")
    public String warehousing(){
        return "warehousing/menu";
    }

    //구매
    @GetMapping("/home/buy")
    public String  purchase(Model model){
        try{
            List<WarehousingItem> warehousingItemList =registerService.checkAll();
            model.addAttribute("items", warehousingItemList);
            return "buy/purchaseForm";
        }
        catch (Exception ex) {
            return "error";
        }
    }



    //통계
    @GetMapping("/home/log")
    public String getLog(Model model){
        List<PurchasingItem> purchasingItemList=registerService.selectAllforLog();
        int totalPrice=registerService.getTotalPrice();
        model.addAttribute("items",purchasingItemList);
        model.addAttribute("totalPrice",totalPrice);
        return "statistics/log";
    }


}
