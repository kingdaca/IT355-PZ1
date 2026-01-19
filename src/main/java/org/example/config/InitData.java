package org.example.config;

import jakarta.annotation.PostConstruct;
import org.example.model.Hotel;
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

    private Long hotelIdCounter = 1L;

    @PostConstruct
   public void init(){
       Hotel h1 = new Hotel(hotelIdCounter++, "Metropolitan Hotel",
               "Bulevar Kralja Aleksandra 88","Beograd", "+38111234567",
               "info@metropolitanhotel.rs", "", 4, "", null);

       Hotel h2 = new Hotel(hotelIdCounter++, "City Hotel",
               "Knez Mihailova 33","Nis", "+38111234568",
               "recepcija@cityhotel.rs", "", 3, "", null);

       hotels.put(h1.getId(), h1);
       hotels.put(h2.getId(), h2);
   }

    public List<Hotel> getHoteli() {
        return new ArrayList<>(hotels.values());
    }
}
