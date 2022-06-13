package com.example.finalPOS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/logincheck")
    public String logincheck(Model model, @RequestParam(value="id") String id,
                             @RequestParam(value = "pwd")String pwd) {

        if(id.equals("minho") && pwd.equals("1234")){
            model.addAttribute("id",id);
            return "home";
        }
        else{
            return "loginAgain";
        }

    }

}
