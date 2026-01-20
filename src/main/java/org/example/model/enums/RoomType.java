package org.example.model.enums;

public enum RoomType {
    SINGLE("Jednokrevetna"),
    DOUBLE("Dvokrevetna"),
    TWIN("Dva single kreveta"),
    SUITE("Apartman"),
    FAMILY("Porodična"),
    DELUXE("Deluxe");

    private final String displayName;

    RoomType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
