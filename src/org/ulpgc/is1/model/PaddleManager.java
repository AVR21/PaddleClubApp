package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.Date;


public class PaddleManager {
    private ArrayList<Customer> customers;
    private ArrayList<Court> courts;

    public PaddleManager() {
        customers = new ArrayList<>();
        courts = new ArrayList<>();
    }

    //Devuelve la lista de clientes (Customer)
    public ArrayList<Customer> getCustomers() {
        return this.customers;
    }

    //Devuelve la lista de canchas (Court)
    public ArrayList<Court> getCourts(){
        return this.courts;
    }

    //Añade un nuevo cliente a la lista de clientes (Customer)
    public void addCustomer(String name, String surname, String nif) {
        customers.add(new Customer(name, surname, nif));
    }

    //Añade una nueva cancha a la lista de canchas (Court)
    public void addCourt(String name, int price, CourtType type) {
        courts.add(new Court(name, price, type));
    }

    //Devuelve un cliente cuyo NIF coincida con el pasado por parámetro
    public Customer getCustomer(String nif) {
        for(Customer customer : customers){
            if(customer.getNif().getNumber().equals(nif)) return customer;
        }
        return null;
    }

    //Devuelve una cancha cuyo nombre coincide con el pasado por parámetro
    public Court getCourt(String name) {
        for(Court court : courts){
            if(court.getName().equals(name)) return court;
        }
        return null;
    }

    //Reserva una cancha (Court) para un cliente (Customer), se comprueba si la cancha esta disponible en la fecha indicada
    public boolean reserve(Customer customer, Court court, Date date) {
        if(!isCourtAvailable(court, date)) return false;
        Reservation reservation = new Reservation(customer, court, date);
        customer.addReservation(reservation);
        return court.addReservation(reservation);
    }

    /*
    * Esto es un ejemplo de "Overload" en java, es posible llamar dos métodos con el mismo nombre siempre que tengan
    * distintos parámetros. Se suele usar como en este caso, para realizar la misma función pero recibiendo diferentes
    * datos. Hay que recordar, eliminar la reserva por parte de la cancha y por parte del cliente en ambos casos.
    */
    public boolean cancelReservation(Court court, int reservationId) {
        Reservation reservation = court.getReservation(reservationId);
        if(reservation == null) return false;
        if(reservation.getCustomer().getReservations().contains(reservation)){
            reservation.getCustomer().getReservations().remove(reservation);
            court.getReservations().remove(reservation);
            return true;
        }
        return false;
    }

    public boolean cancelReservation(Customer customer, int reservationId){
        Reservation reservation = customer.getReservation(reservationId);
        if(reservation == null) return false;
        if(reservation.getCourt().getReservations().contains(reservation)){
            reservation.getCourt().getReservations().remove(reservation);
            customer.getReservations().remove(reservation);
            return true;
        }
        return false;
    }

    private static boolean isCourtAvailable(Court court, Date date) {
        for (Reservation reservation : court.getReservations()) {
            if (reservation.getDate().equals(date)) {
                return false;
            }
        }
        return true;
    }
}