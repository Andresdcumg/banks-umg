package com.bank.bankSite.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    @GetMapping("/login")
    public String loginAction(Model model) {
        return "login"; //view
    }

    @GetMapping("/register")
    public String registerAction(Model model) {
        return "register"; //view
    }

    @GetMapping("/suggestion")
    public String suggestionAction(Model model) {
        return "suggestion"; //view
    }

    @GetMapping("/reset-pass")
    public String resetPasswordAction(Model model) {
        return "reset-password"; //view
    }
}
