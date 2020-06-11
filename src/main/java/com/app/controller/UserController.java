package com.app.controller;

import com.app.dao.UserRepository;
import com.app.model.Product;
import com.app.model.ProductValidator;
import com.app.model.User;
import com.app.model.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @ModelAttribute("user")
    public User initUser(){
        return new User();
    }

    @PostMapping("/add")
    public String addUser(@Valid @ModelAttribute("user") User user, BindingResult result, @RequestParam("passwordConfirmation")String passwordConfirmation, Model model){
        new UserValidator().validate(user, result);
        if(result.hasErrors()){
            return "new-user";
        }
        userRepository.save(user);
        return "redirect:/home";
    }

    @GetMapping("/add")
    public String addProduct(@ModelAttribute("product") Product product) {
        return "new-user";
    }
}
