package org.example.model.enums;

public enum ServiceType {
    HALF_BOARD("Half Board"),
    FULL_BOARD("Full Board"),
    ALL_INCLUSIVE("All Inclusive"),
    NONE("NONE");

    private final String displayName;

    ServiceType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
