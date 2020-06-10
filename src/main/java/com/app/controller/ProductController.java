package com.app.controller;

import com.app.dao.ProductRepository;
import com.app.model.Product;
import com.app.model.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@Controller
@Transactional
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @ModelAttribute("product")
    public Product initProduct(){
        return new Product();
    }

    @GetMapping
    public String getList(){
        return "products";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute("product") Product product, BindingResult result, Model model){
        new ProductValidator().validate(product, result);
        if(result.hasErrors()){
            return "add-product";
        }
        model.addAttribute("description", product.getDescription());
        model.addAttribute("price", product.getPrice());
        productRepository.save(product);
        return "redirect:/home";
    }

    @GetMapping("/add")
    public String addProduct(@ModelAttribute("product") Product product) {
        return "add-product";
    }

    @GetMapping("/edit/{idProduct}")
    public String editProduct(@PathVariable long idProduct, @ModelAttribute("product") Product product, Model model){
        Product p = productRepository.getOne(idProduct);
        model.addAttribute("product", p);
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
