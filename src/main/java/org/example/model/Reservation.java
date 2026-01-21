package org.example.model;

import java.time.LocalDate;

public class Reservation {

    private Long id;
    private String reservationNumber;

    private Hotel hotel;
    private Guest guest;
    private Room room;

    private int NumberOFGuestsl;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private LocalDate reservationDate;
    private double totalPrice;
    private Service service;

    public Reservation() {
    }

    public Reservation(Long id, String reservationNumber, Hotel hotel, Guest guest, Room room, int numberOFGuestsl, LocalDate checkInDate, LocalDate checkOutDate, LocalDate reservationDate, double totalPrice, Service service) {
        this.id = id;
        this.reservationNumber = reservationNumber;
        this.hotel = hotel;
        this.guest = guest;
        this.room = room;
        NumberOFGuestsl = numberOFGuestsl;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.reservationDate = reservationDate;
        this.totalPrice = totalPrice;
        this.service = service;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public int getNumberOFGuestsl() {
        return NumberOFGuestsl;
    }

    public void setNumberOFGuestsl(int numberOFGuestsl) {
        NumberOFGuestsl = numberOFGuestsl;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", reservationNumber='" + reservationNumber + '\'' +
                ", hotel=" + hotel +
                ", guest=" + guest +
                ", room=" + room +
                ", NumberOFGuestsl=" + NumberOFGuestsl +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", reservationDate=" + reservationDate +
                ", totalPrice=" + totalPrice +
                ", service=" + service +
                '}';
    }
}
