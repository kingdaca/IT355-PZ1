package org.example.model;

import org.example.model.enums.ServiceType;

public class Service {

    private ServiceType type;
    private String description;
    private double price;

    public Service() {

    }

    public Service( ServiceType type, String description, double price) {
        this.type = type;
        this.description = description;
    }


    public ServiceType getType() {
        return type;
    }

    public void setType(ServiceType type) {
        this.type = type;

        if (type == null) {
            this.price = 0;
        } else {
            switch (type) {
                case ALL_INCLUSIVE -> this.price = 200;
                case FULL_BOARD -> this.price = 100;
                case HALF_BOARD -> this.price = 50;
                default -> this.price = 0;
            }
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Service{" +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
