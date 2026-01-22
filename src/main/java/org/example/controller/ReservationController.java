package org.example.controller;

import org.example.config.DataSeeder;
import org.example.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private DataSeeder dataSeeder;


    @GetMapping("/creatReservation")
    public String addOrEditReservation(@RequestParam(required = false) Long reservationId,
                                       @RequestParam(required = false) Long roomId,
                                       Model model) {
        Reservation reservation = (reservationId != null)
                ? dataSeeder.getReservationById(reservationId)
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

        Room room = dataSeeder.getRoomById(roomId);

        model.addAttribute("reservation", reservation);
        model.addAttribute("hotel", dataSeeder.getHotelById(room.getHotelId()));
        model.addAttribute("room", room);
        model.addAttribute("guests", dataSeeder.getGuests());

        return "reservation/createReservation";
    }

    @GetMapping("/reservationList")
    public String reservationList(Model model){
        List<Reservation> reservations = dataSeeder.getReservation();
        model.addAttribute("reservations", reservations);
        return "reservation/reservationList";
    }

    @GetMapping("/edit")
    public String editReservation(@RequestParam("reservationId") Long id, Model model){
        Reservation reservation = dataSeeder.getReservationById(id);
        model.addAttribute("hotels", dataSeeder.getHotelById(reservation.getHotel().getId()));
        model.addAttribute("rooms", dataSeeder.getRoomsByHotelId(reservation.getHotel().getId()).stream().filter(room -> room.isAvailable()));
        model.addAttribute("reservation", reservation);
        return "reservation/editReservation";
    }

    @PostMapping("/confirm")
    public String confirmReservation(@ModelAttribute Reservation reservation,
                                    @RequestParam("hotelId") Long hotelId,
                                    @RequestParam("roomId") Long roomId,
                                     Model model) {

        reservation.setHotel(dataSeeder.getHotelById(hotelId));
        reservation.setRoom(dataSeeder.getRoomById(roomId));
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
        reservation.setHotel(dataSeeder.getHotelById(hotelId));
        reservation.setRoom(dataSeeder.getRoomById(roomId));
        Guest guest = new Guest();

        guest.setFirstName(guestFirstName);
        guest.setLastName(guestLastName);
        guest.setEmail(guestEmail);
        guest.setPhone(guestPhone);
        guest.setPassportNumber(guestPassportNumber);

        reservation.setGuest(guest);
        dataSeeder.addReservation(reservation);
        return "redirect:/hotel";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Reservation reservation,
                                 @RequestParam("hotelId") Long hotelId,
                                 @RequestParam("roomId") Long roomId,
                                 @RequestParam("guestFirstName") String guestFirstName,
                                 @RequestParam("guestLastName") String guestLastName,
                                 @RequestParam("guestEmail") String guestEmail,
                                 @RequestParam("guestPhone") String guestPhone,
                                 @RequestParam("guestPassportNumber") String guestPassportNumber) {
        Reservation reservation1 = dataSeeder.getReservationById(reservation.getId());
        reservation1.setRoom(dataSeeder.getRoomById(roomId));
        Guest guest = new Guest();
        double totalPrica = reservation1.getRoom().getPricePerNight() + (reservation1.getService().getPrice() * reservation1.getNumberOFGuests());
        reservation1.setTotalPrice(totalPrica);
        guest.setFirstName(guestFirstName);
        guest.setLastName(guestLastName);
        guest.setEmail(guestEmail);
        guest.setPhone(guestPhone);
        guest.setPassportNumber(guestPassportNumber);

        reservation1.setGuest(guest);
        reservation1.setNumberOFGuests(reservation.getNumberOFGuests());
        reservation1.setCheckInDate(reservation.getCheckInDate());
        reservation1.setCheckOutDate(reservation.getCheckOutDate());
        reservation1.setReservationDate(reservation.getReservationDate());
        reservation1.setService(reservation.getService());

        return "redirect:/reservation/reservationList";
    }

    @GetMapping("remove")
    public String removeReservation(@RequestParam("reservationId") Long id){
        dataSeeder.removeReservation(id);
        return "redirect:/reservation/reservationList";
    }


}
