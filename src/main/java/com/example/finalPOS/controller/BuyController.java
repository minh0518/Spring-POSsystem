package com.example.finalPOS.controller;

import com.example.finalPOS.domain.WarehousingItem;
import com.example.finalPOS.service.RegisterService;
import com.example.finalPOS.service.requests.BuyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BuyController {

    private final RegisterService registerService;

    @Autowired
    public BuyController(RegisterService registerService) {
        this.registerService = registerService;
    }




    //상품 구매
    @PostMapping ("/home/buy/purchaseConfirm")
    public String buy(BuyRequest req,Model model){
            if(registerService.buy(req)){

                model.addAttribute("itemName",req.getItemName());
                model.addAttribute("itemCount",req.getItemCount());
                model.addAttribute("totalPrice",(registerService.getPrice(req.getItemName()))*req.getItemCount());
                return "buy/purchaseConfirm";
            }
            else{
                return "buy/countOver";
            }
    }


}
