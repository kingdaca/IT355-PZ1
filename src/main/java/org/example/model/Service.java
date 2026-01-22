package org.example.model;

import org.example.model.enums.ServiceType;

public class Service {

    private Long id;
    private ServiceType type;
    private String description;
    private double price;

    public Service() {

    }

    public Service(Long id, ServiceType type, String description, double price) {
        this.id = id;
        this.type = type;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ServiceType getType() {
        return type;
    }

    public void setType(ServiceType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        if(this.type == ServiceType.ALL_INCLUSIVE){
            this.price = 200;
        } else if (this.type == ServiceType.FULL_BOARD) {
            this.price = 100;
        } else if (this.type == ServiceType.HALF_BOARD) {
            this.price = 50;
        } else {
            this.price = 0;
        }
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
