package org.example.model;

import java.util.ArrayList;
import java.util.List;
    public class Guest {
        private Long id;
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private String passportNumber;
        private List<Reservation> reservations = new ArrayList<>();

        public Guest() {
        }

        public Guest(Long id, String firstName, String lastName, String email, String phone, String passportNumber, List<Reservation> reservations) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.phone = phone;
            this.passportNumber = passportNumber;
            this.reservations = reservations;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPassportNumber() {
            return passportNumber;
        }

        public void setPassportNumber(String passportNumber) {
            this.passportNumber = passportNumber;
        }

        public List<Reservation> getReservations() {
            return reservations;
        }

        public void setReservations(List<Reservation> reservations) {
            this.reservations = reservations;
        }

        @Override
        public String toString() {
            return "Guest{" +
                    "id=" + id +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", email='" + email + '\'' +
                    ", phone='" + phone + '\'' +
                    ", passportNumber='" + passportNumber + '\'' +
                    ", reservations=" + reservations +
                    '}';
        }
    }

