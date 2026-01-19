package org.example.controller;

import org.example.config.InitData;
import org.example.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private InitData initData;

    private List<Hotel> hotels = new ArrayList<>();

    @GetMapping
    public String hotels(Model model) {
        hotels = initData.getHoteli();
        model.addAttribute("hotels", hotels);
        return "hotel/hotel"; // 👈 folder/fajl
    }
}

