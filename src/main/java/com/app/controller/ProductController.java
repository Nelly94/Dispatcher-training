package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public String getList(){
        return "products";
    }

    @GetMapping("/add")
    public String addProduct(){
        return "add-product";
    }

    @GetMapping("/edit/{idProduct}")
    public String editProduct(@PathVariable int idProduct, Model model){
        model.addAttribute("id",idProduct);
        return "add-product";
    }

    @GetMapping("/delete/{idProduct}")
    public String deleteProduct(@PathVariable int idProduct, Model model){
        model.addAttribute("id",idProduct);
        return "delete-product";
    }


    @GetMapping({"/product", "/product/{idProduct}"})
    public String productDetail(@PathVariable(required=false) int idProduct, Model model){
        model.addAttribute("id",idProduct);
        return "product";
    }
}
