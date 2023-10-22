package org.ulpgc.is1.model;

import java.util.ArrayList;

public class Court {
    private String name;
    private int price;
    private CourtType type;

    private ArrayList<Reservation> reservations;

    public Court(String name, int price, CourtType type){

        this.name = name;
        this.price = price;
        this.type = type;
        this.reservations = new ArrayList<>();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public CourtType getType() {
        return type;
    }

    public void setType(CourtType type) {
        this.type = type;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public boolean addReservation(Reservation newReservation){
        return reservations.add(newReservation);
    }

    public boolean removeReservation(Reservation reservationId){
        for(Reservation reservation : reservations){
            if(reservation.getId() == reservationId)
                return reservations.remove(reservation);
        }
        return false;
    }

    public Reservation getReservation(int reservationId){
        for(Reservation reservation : reservations){
            if(reservation.getId() == reservationId)
                return reservation;
        }
        return null;
    }
}
