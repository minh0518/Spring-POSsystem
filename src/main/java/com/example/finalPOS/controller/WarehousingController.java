package com.example.finalPOS.controller;

import com.example.finalPOS.domain.WarehousingItem;
import com.example.finalPOS.service.requests.AddRequest;
import com.example.finalPOS.service.RegisterService;
import com.example.finalPOS.service.requests.RemoveRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class WarehousingController {

    private final RegisterService registerService;

    @Autowired
    public WarehousingController(RegisterService registerService) {
        this.registerService=registerService;
    }

    //입고
    @GetMapping("/home/warehousing/menu/plus")
    public String addItem(){
        return "warehousing/addItem";
    }

    @PostMapping("/home/warehousing/menu/plus/addConfirm")
    public String addConfirm(AddRequest req, Model model){
        try{
            registerService.plus(req);
            List<WarehousingItem> warehousingItemList =registerService.checkAll();
            model.addAttribute("items", warehousingItemList);
            return "warehousing/addConfirm";
        }
        catch (Exception ex) {
            return "error";
        }
    }




    //제거
    @GetMapping("/home/warehousing/menu/minus")
    public String removeItem(Model model){

        List<WarehousingItem> warehousingItemList =registerService.checkAll();
        model.addAttribute("items", warehousingItemList);
        return "warehousing/removeItem";

    }

    @PostMapping("/home/warehousing/menu/minus/removeConfirm")
    public String removeConfirm(RemoveRequest req, Model model){
        try{
            registerService.delete(req.getItemName(),req.getItemCount());
            //삭제

            List<WarehousingItem> warehousingItemList =registerService.checkAll();
            model.addAttribute("items", warehousingItemList);
            return "warehousing/removeConfirm";
        }
        catch (Exception ex) {
            return "error";
        }
    }


    //창고 조회
    @GetMapping("/home/warehousing/menu/checkItem")
    public String check(Model model){
        try{
            List<WarehousingItem> warehousingItemList =registerService.checkAll();
            model.addAttribute("items", warehousingItemList);
            return "warehousing/checkItem";
        }
        catch (Exception ex) {
            return "error";
        }

    }

}
