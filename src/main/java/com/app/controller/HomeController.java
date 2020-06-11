package com.app.controller;

import com.app.model.PrincipalUser;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@PrincipalUser.IsAdmin
public class HomeController {

    @GetMapping("/home")
    public String home(@RequestParam(required = false, defaultValue = "World") String username, Model model){
        model.addAttribute("username", username);
        return "home";
    }
}
