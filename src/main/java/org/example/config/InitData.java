package org.example.config;

import jakarta.annotation.PostConstruct;
import org.example.model.Guest;
import org.example.model.Hotel;
import org.example.model.Reservation;
import org.example.model.Room;
import org.example.model.enums.RoomType;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.*;

@Component
@Scope(value = WebApplicationContext.SCOPE_APPLICATION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class InitData {
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
        room.setId(roomIdCounter++);
        rooms.put(roomIdCounter,room);
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
        r.setId(reservationIdCounter++);
        Guest g = r.getGuest();
        g.setId(userIdCounter++);
        reservations.put(reservationIdCounter,r);
    }

    public Reservation getReservationById(Long id) {
        for (Reservation r : getReservation()){
            if(r.getId() == id){
                return r;
            }
        }
        return null;
    }


    public Guest getGuestById(Long id){
        return new ArrayList<Guest>((Collection<? extends Guest>) guests.values().stream().filter(guest -> guest.getId() == id)).get(0);
    }



}
