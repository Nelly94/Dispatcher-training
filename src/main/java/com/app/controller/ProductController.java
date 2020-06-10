package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @GetMapping({"/product", "/product/{idProduct}"})
    public String product(@PathVariable(required=false) int idProduct, Model model){
        model.addAttribute("id",idProduct);
        return "product";
    }
}
