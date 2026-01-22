package org.example.controller;

import org.example.config.InitData;
import org.example.model.*;
import org.example.model.enums.ServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private InitData initData;


    @GetMapping("/addOrEdit")
    public String addOrEditReservation(@RequestParam(required = false) Long reservationId,
                                       @RequestParam(required = false) Long roomId,
                                       Model model) {
        Reservation reservation = (reservationId != null)
                ? initData.getReservationById(reservationId)
                : new Reservation();

        if (reservation.getGuest() == null) {
            reservation.setGuest(new Guest());
        }
        if (reservation.getService() == null) {
            reservation.setService(new Service());
        }

        if(reservation.getReservationNumber() == null){
            Random random = new Random();
            int randomNumber = random.nextInt(100000000);
            reservation.setReservationNumber(String.valueOf(randomNumber));
        }

        Room room = initData.getRoomById(roomId);

        model.addAttribute("reservation", reservation);
        model.addAttribute("hotel", initData.getHotelById(room.getHotelId()));
        model.addAttribute("room", room);
        model.addAttribute("guests", initData.getGuests());

        return "reservation/addOrEditReservation";
    }

    @GetMapping("/list")
    public String reservation(Model model){
        List<Reservation> reservations = initData.getReservation();
        System.out.println(reservations);
        model.addAttribute("reservations", reservations);
        return "reservation/reservationList";
    }

    @PostMapping("/confirm")
    public String confirmReservation(@ModelAttribute Reservation reservation,
                                    @RequestParam("hotelId") Long hotelId,
                                    @RequestParam("roomId") Long roomId,
                                     Model model) {

        reservation.setHotel(initData.getHotelById(hotelId));
        reservation.setRoom(initData.getRoomById(roomId));
        long numberOfDays = ChronoUnit.DAYS.between(
                reservation.getCheckInDate(),
                reservation.getCheckOutDate()
        );

        double pricePerNight = reservation.getRoom().getPricePerNight();
        double totalPrica = reservation.getRoom().getPricePerNight() + (reservation.getService().getPrice() * reservation.getNumberOFGuests());
        model.addAttribute("numberOfDays", numberOfDays);
        model.addAttribute("pricePerNight", pricePerNight);
        model.addAttribute("totalPrice", totalPrica);
        model.addAttribute("reservation",reservation);
        return "reservation/confirmeReservation";
    }

    @PostMapping("/add")
    public String addReservation(@ModelAttribute Reservation reservation,
                                 @RequestParam("hotelId") Long hotelId,
                                 @RequestParam("roomId") Long roomId,
                                 @RequestParam("guestFirstName") String guestFirstName,
                                 @RequestParam("guestLastName") String guestLastName,
                                 @RequestParam("guestEmail") String guestEmail,
                                 @RequestParam("guestPhone") String guestPhone,
                                 @RequestParam("guestPassportNumber") String guestPassportNumber) {
        reservation.setHotel(initData.getHotelById(hotelId));
        reservation.setRoom(initData.getRoomById(roomId));
        Guest guest = new Guest();

        guest.setFirstName(guestFirstName);
        guest.setLastName(guestLastName);
        guest.setEmail(guestEmail);
        guest.setPhone(guestPhone);
        guest.setPassportNumber(guestPassportNumber);

        reservation.setGuest(guest);
        initData.addReservation(reservation);
        return "redirect:/hotel";
    }


}
