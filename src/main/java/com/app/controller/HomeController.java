package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(@RequestParam(required = false, defaultValue = "World") String username, Model model){
        model.addAttribute("username", username);
        return "home";
    }
}
