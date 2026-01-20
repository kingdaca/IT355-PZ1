package org.example.config;

import jakarta.annotation.PostConstruct;
import org.example.model.Hotel;
import org.example.model.Room;
import org.example.model.enums.RoomType;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Scope(value = WebApplicationContext.SCOPE_APPLICATION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class InitData {
    private Map<Long, Hotel> hotels = new HashMap<>();
    private Map<Long, Room> rooms = new HashMap<>();

    private Long hotelIdCounter = 1L;
    private Long sobaIdCounter= 1L;

    @PostConstruct
   public void init(){
       Hotel h1 = new Hotel(hotelIdCounter++, "Metropolitan Hotel",
               "Bulevar Kralja Aleksandra 88","Beograd", "+38111234567",
               "info@metropolitanhotel.rs", "", 4, "", null);

       Hotel h2 = new Hotel(hotelIdCounter++, "City Hotel",
               "Knez Mihailova 33","Nis", "+38111234568",
               "recepcija@cityhotel.rs", "", 3, "", null);

        rooms.put(sobaIdCounter, new Room(sobaIdCounter++, "101", RoomType.SINGLE, 50.0, true, h1));
        rooms.put(sobaIdCounter, new Room(sobaIdCounter++, "102", RoomType.DOUBLE, 80.0, true, h1));
        rooms.put(sobaIdCounter, new Room(sobaIdCounter++, "103", RoomType.TWIN, 55.0, true, h1));


        rooms.put(sobaIdCounter, new Room(sobaIdCounter++, "201", RoomType.DOUBLE, 85.0, true, h1));
        rooms.put(sobaIdCounter, new Room(sobaIdCounter++, "202", RoomType.SUITE,  130.0, true, h1));
        rooms.put(sobaIdCounter, new Room(sobaIdCounter++, "203", RoomType.DELUXE,  60.0, false, h1));

        rooms.put(sobaIdCounter, new Room(sobaIdCounter++, "101", RoomType.SINGLE, 45.0, true, h2));
        rooms.put(sobaIdCounter, new Room(sobaIdCounter++, "102", RoomType.DOUBLE, 75.0, true, h2));
        rooms.put(sobaIdCounter, new Room(sobaIdCounter++, "103", RoomType.DELUXE, 50.0, false, h2));

        rooms.put(sobaIdCounter, new Room(sobaIdCounter++, "201", RoomType.TWIN, 80.0, true, h2));
        rooms.put(sobaIdCounter, new Room(sobaIdCounter++, "202", RoomType.SUITE, 120.0, true, h2));
        rooms.put(sobaIdCounter, new Room(sobaIdCounter++, "203", RoomType.SINGLE, 55.0, true, h2));



        hotels.put(h1.getId(), h1);
        hotels.put(h2.getId(), h2);
   }

    public List<Hotel> getHotels() {
        return new ArrayList<>(hotels.values());
    }

    public List<Room> getRooms(long hotelId) {
        return new ArrayList<>(rooms.values().stream().filter(room -> room.getHotel().getId() == hotelId).toList());
    }

    public Hotel getHotelById(long hotelId) {
        for (Hotel hotel : getHotels()) {
            if (hotel.getId() == hotelId) {
                return hotel;
            }
        }
        return null;
    }
}
