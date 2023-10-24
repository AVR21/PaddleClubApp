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

    public void addMember(String name, String surname, String nif, String street, int number, int postalCode, String city){
        customers.add(Member.create(name, surname, nif, street, number, postalCode, city));
    }

    //Devuelve un cliente según el índice pasado por parámetro
    public Customer getCustomer(int index) {
        if (index < 0 || index >= customers.size()) throw new IndexOutOfBoundsException();
        return customers.get(index);
    }

    //Elimina el cliente almacenado en la posición indicada de la lista
    public boolean removeCustomer(int index) {
        if (index < 0 || index >= customers.size()) throw new IndexOutOfBoundsException();
        return customers.remove(index) != null;
    }

    //Cuenta la cantidad de clientes registrados (tamaño de la lista customers)
    public int countCustomers(){
        return customers.size();
    }

    //Crea y añade una nueva cancha a la lista de canchas (Court)
    public void addCourt(String name, int price, CourtType type) {
        courts.add(new Court(name, price, type));
    }

    //Devuelve una cancha según el índice pasado por parámetro
    public Court getCourt(int index) {
        if (index < 0 || index >= courts.size()) throw new IndexOutOfBoundsException();
        return courts.get(index);
    }

    //Elimina la cancha almacenada en la posición indicada de la lista
    public boolean removeCourt(int index) {
        if (index < 0 || index >= courts.size()) throw new IndexOutOfBoundsException();
        return courts.remove(index) != null;
    }

    public int countCourts(){
        return customers.size();
    }

    //Reserva una cancha (Court) para un cliente (Customer), se comprueba si la cancha esta disponible en la fecha indicada
    public void reserve(Customer customer, Court court, Date date) {
        if (!isCourtAvailable(court, date)) return;
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
        return court.getReservation(reservationId).getCourt().removeReservation(reservationId) &&
                court.removeReservation(reservationId);
    }

    public boolean cancelReservation(Customer customer, int reservationId) {
        return customer.getReservation(reservationId).getCourt().removeReservation(reservationId) &&
                customer.removeReservation(reservationId);
    }

    private static boolean isCourtAvailable(Court court, Date date) {
        for (int i = 0; i < court.countReservations(); i++) {
            if (court.getReservation(i).getDate().equals(date)) return false;
        }
        return true;
    }
}
