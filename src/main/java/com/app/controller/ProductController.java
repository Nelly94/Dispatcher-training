package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @GetMapping("/product")
    public String product(@RequestParam int id, Model model){
        model.addAttribute("id",id);
        return "product";
    }
}
