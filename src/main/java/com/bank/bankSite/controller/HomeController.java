package com.bank.bankSite.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    // inject via application.properties
    @Value("${app.name}")
    private String name;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("AppName", name);

        return "index"; //view
    }
}