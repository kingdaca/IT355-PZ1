package org.example.controller;

import org.example.config.InitData;
import org.example.model.Hotel;
import org.example.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private InitData initData;

    private List<Hotel> hotels = new ArrayList<>();

    private List<Room> rooms = new ArrayList<>();

    @GetMapping
    public String hotels(Model model) {
        hotels = initData.getHotels();
        model.addAttribute("hotels", hotels);
        return "hotel/hotel"; // 👈 folder/fajl
    }

    @GetMapping("/rooms")
    public String getSobe(@RequestParam long hotelId, Model model){
        rooms = initData.getRoomsByHotelId(hotelId);
        model.addAttribute("hotelId", hotelId);
        model.addAttribute("rooms", rooms);
        return "room/rooms";
    }

    @GetMapping("/addOrEditHotel")
    public String addOrEditHotel(@RequestParam(required = false) Long hotelId, Model model) {

        Hotel hotel;

        if (hotelId != null) {
            hotel = initData.getHotelById(hotelId);
        } else {
            hotel = new Hotel();
        }

        model.addAttribute("hotel", hotel);
        return "hotel/addOrEditHotel";
    }

    @PostMapping("/update")
    public String updateHotel(Hotel hotel){
        Hotel hotel1 = initData.getHotelById((hotel.getId()));
        hotel1.setName(hotel.getName());
        hotel1.setAddress(hotel.getAddress());
        hotel1.setCity(hotel.getCity());
        hotel1.setPhone(hotel.getPhone());
        hotel1.setEmail(hotel.getEmail());
        hotel1.setWebsite(hotel.getWebsite());
        hotel1.setStarRating(hotel.getStarRating());
        hotel1.setDescription(hotel.getDescription());
        return "redirect:/hotel";
    }

    @PostMapping("/add")
    public String addHotel(Hotel hotel){
        initData.addHotel(hotel);
        return "redirect:/hotel";
    }

    @GetMapping("/remove")
    public String removeHotel(@RequestParam Long hotelId){
        initData.removeHotel(hotelId);
        return "redirect:/hotel";
    }


}

