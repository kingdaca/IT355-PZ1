package org.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Value("${spring.application.name}")
    private String appNeam;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Početna");
        model.addAttribute("message", "Dobrodošli u " + appNeam);
        return "home";
    }
}
