package org.example.controller;

import org.example.config.InitData;
import org.example.model.Hotel;
import org.example.model.Room;
import org.example.model.enums.RoomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/room")
public class RoomController {

    @Autowired
    InitData initData;

    @GetMapping("/addOrEditRoom")
    public String addOrEditRoom(@RequestParam(required = false) Long roomId , @RequestParam(required = false)Long hotelId, Model model) {

        Room room;

        if (roomId != null) {
            room = initData.getRoomById(roomId);
        } else {
            room = new Room();
        }
        model.addAttribute("roomTypes", RoomType.values());
        model.addAttribute("hotels",initData.getHotelById(hotelId));
        model.addAttribute("hotelId", hotelId);
        model.addAttribute("room", room);
        return "room/addOrEditRoom";
    }

    @PostMapping("/add")
    public String addRoom(Room room){
        initData.addRoom(room);
        return "redirect:/hotel/rooms?hotelId="+room.getHotelId();
    }

    @GetMapping("/remove")
    public String removeRoom(@RequestParam("roomId") Long roomId,
                            @RequestParam("hotelId") Long hotelId){
        initData.removeRoom(roomId);
        return "redirect:/hotel/rooms?hotelId="+hotelId;
    }

    @PostMapping("/update")
    public String updateRoom(Room room){
        Room room1 = initData.getRoomById(room.getId());
        room1.setRoomNumber(room.getRoomNumber());
        room1.setType(room.getType());
        room1.setPricePerNight(room.getPricePerNight());
        room1.setAvailable(room.isAvailable());
        return  "redirect:/hotel/rooms?hotelId="+room.getHotelId();
    }

}
