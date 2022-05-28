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
public class UserController {
    @GetMapping("/user/dashboard")
    public String dashboardAction(Model model) {

        return "dashboard"; //view
    }

    @GetMapping("/user/suggestion")
    public String suggestionAction(Model model) {
        return "loggedSuggestion"; //view
    }
}
