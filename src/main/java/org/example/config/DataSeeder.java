package org.example.config;

import jakarta.annotation.PostConstruct;
import org.example.model.*;
import org.example.model.enums.RoomType;
import org.example.model.enums.ServiceType;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.util.*;

@Component
@Scope(value = WebApplicationContext.SCOPE_APPLICATION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DataSeeder {
    private Map<Long, Hotel> hotels = new HashMap<>();
    private Map<Long, Room> rooms = new HashMap<>();

    private Map<Long, Guest> guests = new HashMap<>();

    private Map<Long, Reservation> reservations = new HashMap<>();

    private Long hotelIdCounter = 1L;
    private Long roomIdCounter= 1L;
    private Long userIdCounter= 1L;

    private Long reservationIdCounter= 1L;

    @PostConstruct
   public void init(){
       Hotel h1 = new Hotel(hotelIdCounter++, "Metropolitan Hotel",
               "Bulevar Kralja Aleksandra 88","Beograd", "+38111234567",
               "info@metropolitanhotel.rs", "", 4, "", null);

       Hotel h2 = new Hotel(hotelIdCounter++, "City Hotel",
               "Knez Mihailova 33","Nis", "+38111234568",
               "recepcija@cityhotel.rs", "", 3, "", null);

        rooms.put(roomIdCounter, new Room(roomIdCounter++, "101", RoomType.SINGLE, 50.0, true, h1.getId()));
        rooms.put(roomIdCounter, new Room(roomIdCounter++, "102", RoomType.DOUBLE, 80.0, true, h1.getId()));
        rooms.put(roomIdCounter, new Room(roomIdCounter++, "103", RoomType.TWIN, 55.0, true, h1.getId()));


        rooms.put(roomIdCounter, new Room(roomIdCounter++, "201", RoomType.DOUBLE, 85.0, true, h1.getId()));
        rooms.put(roomIdCounter, new Room(roomIdCounter++, "202", RoomType.SUITE,  130.0, true, h1.getId()));
        rooms.put(roomIdCounter, new Room(roomIdCounter++, "203", RoomType.DELUXE,  60.0, false, h1.getId()));

        rooms.put(roomIdCounter, new Room(roomIdCounter++, "101", RoomType.SINGLE, 45.0, true, h2.getId()));
        rooms.put(roomIdCounter, new Room(roomIdCounter++, "102", RoomType.DOUBLE, 75.0, true, h2.getId()));
        rooms.put(roomIdCounter, new Room(roomIdCounter++, "103", RoomType.DELUXE, 50.0, false, h2.getId()));

        rooms.put(roomIdCounter, new Room(roomIdCounter++, "201", RoomType.TWIN, 80.0, true, h2.getId()));
        rooms.put(roomIdCounter, new Room(roomIdCounter++, "202", RoomType.SUITE, 120.0, true, h2.getId()));
        rooms.put(roomIdCounter, new Room(roomIdCounter++, "203", RoomType.SINGLE, 55.0, true, h2.getId()));



        hotels.put(h1.getId(), h1);
        hotels.put(h2.getId(), h2);


        Reservation reservation = new Reservation();


        reservation.setId(userIdCounter++);
        reservation.setReservationNumber("RES-2026-001");
        reservation.setReservationDate(LocalDate.of(2026, 1, 20));
        reservation.setHotel(h1);
        reservation.setRoom(getRoomById(1));
        Guest davidMitic = new Guest();
        davidMitic.setId(1L);
        davidMitic.setFirstName("David");
        davidMitic.setLastName("Mitic");
        davidMitic.setEmail("david.mitic@example.com");
        davidMitic.setPhone("081641234567");
        davidMitic.setPassportNumber("SRB12345678");
        reservation.setGuest(davidMitic);

        Service service = new Service();
        service.setType(ServiceType.FULL_BOARD);
        service.getPrice();
        service.setDescription("");

        reservation.setService(service);
        reservation.setNumberOFGuests(4);
        reservation.setCheckInDate(LocalDate.of(2026, 1, 22));
        reservation.setCheckOutDate(LocalDate.of(2026, 1, 29));

        reservation.setTotalPrice(1050.0);

        addReservation(reservation);
   }

    public List<Hotel> getHotels() {
        return new ArrayList<>(hotels.values());
    }

    public void addHotel(Hotel hotel){
        hotel.setId(hotelIdCounter++);
        hotels.put(hotelIdCounter,hotel);
    }

    public Hotel getHotelById(long hotelId) {
        for (Hotel hotel : getHotels()) {
            if (hotel.getId() == hotelId) {
                return hotel;
            }
        }
        return null;
    }

    public void removeHotel(long hoteId){
        hotels.remove(hoteId);
    }


    public List<Room> getRooms() {
        return new ArrayList<>(rooms.values());
    }

    public Room getRoomById(long roomId) {
        for (Room room : getRooms()) {
            if (room.getId() == roomId) {
                return room;
            }
        }
        return null;
    }

    public void addRoom(Room room){
        room.setId(roomIdCounter);
        rooms.put(roomIdCounter++,room);
    }

    public void removeRoom(Long roomId){
        rooms.remove(roomId);
    }

    public List<Room> getRoomsByHotelId(long hotelId) {
        return new ArrayList<>(rooms.values().stream().filter(room -> room.getHotelId() == hotelId).toList());
    }

    public List<Guest> getGuests() {
        return new ArrayList<>(guests.values());
    }

    public List<Reservation> getReservation() {
        return new ArrayList<>(reservations.values());
    }

    public void addReservation(Reservation r){
        r.setId(reservationIdCounter);
        Guest g = r.getGuest();
        g.setId(userIdCounter++);
        reservations.put(reservationIdCounter++,r);
    }

    public Reservation getReservationById(Long id) {
        for (Reservation r : getReservation()){
            if(r.getId() == id){
                return r;
            }
        }
        return null;
    }

    public void removeReservation(Long id){
        reservations.remove(id);
    }


    public Guest getGuestById(Long id){
        return new ArrayList<Guest>((Collection<? extends Guest>) guests.values().stream().filter(guest -> guest.getId() == id)).get(0);
    }



}
