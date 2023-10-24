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

    //Crea y añade un nuevo cliente a la lista de clientes (Customer)
    public void addCustomer(String name, String surname, String nif) {
        customers.add(new Customer(name, surname, nif));
    }

    //Devuelve un cliente según el índice pasado por parámetro
    public Customer getCustomer(int index) {
        if(index < 0 || index >= customers.size()) throw new IndexOutOfBoundsException();
        return customers.get(index);
    }

    //Elimina el cliente almacenado en la posición indicada de la lista
    public boolean removeCustomer(int index) {
        if(index < 0 || index >= customers.size()) throw new IndexOutOfBoundsException();
        return customers.remove(index) != null;
    }

    //Crea y añade una nueva cancha a la lista de canchas (Court)
    public void addCourt(String name, int price, CourtType type) {
        courts.add(new Court(name, price, type));
    }

    //Devuelve una cancha según el índice pasado por parámetro
    public Court getCourt(int index) {
        if(index < 0 || index >= courts.size()) throw new IndexOutOfBoundsException();
        return courts.get(index);
    }

    //Elimina la cancha almacenada en la posición indicada de la lista
    public boolean removeCourt(int index){
        if(index < 0 || index >= courts.size()) throw new IndexOutOfBoundsException();
        return courts.remove(index) != null;
    }

    //Reserva una cancha (Court) para un cliente (Customer), se comprueba si la cancha esta disponible en la fecha indicada
    public void reserve(Customer customer, Court court, Date date) {
        if(!isCourtAvailable(court, date)) return;
        Reservation reservation = new Reservation(customer, court, date);
        if (court.addReservation(reservation)) {
            customer.addReservation(reservation);
        }
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
            return reservation.getCustomer().getReservations().remove(reservation) &&
                    court.getReservations().remove(reservation);
        }
        return false;
    }

    public boolean cancelReservation(Customer customer, int reservationId){
        Reservation reservation = customer.getReservation(reservationId);
        if(reservation == null) return false;
        if(reservation.getCourt().getReservations().contains(reservation)){
            return reservation.getCourt().getReservations().remove(reservation) &&
                    customer.getReservations().remove(reservation);
        }
        return false;
    }

    private static boolean isCourtAvailable(Court court, Date date) {
        for (Reservation reservation : court.getReservations()) {
            return !reservation.getDate().equals(date);
        }
        return true;
    }
}
