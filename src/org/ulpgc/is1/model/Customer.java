package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String surname;
    private NIF nif;
    private ArrayList<Reservation> reservations;

    public Customer(String name, String surname, String nif){
        this.name = name;
        this.surname = surname;
        this.nif = NIF.create(nif);
        this.reservations = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public NIF getNif() {
        return nif;
    }

    public void setNif(NIF nif) {
        this.nif = nif;
    }

    public ArrayList<Reservation> getReservations() {
        return this.reservations;
    }

    public boolean addReservation(Reservation newReservation){
        return reservations.add(newReservation);
    }

    public boolean removeReservation(int reservationId){
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
