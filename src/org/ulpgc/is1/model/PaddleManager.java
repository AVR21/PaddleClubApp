package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.Date;

public class PaddleManager {
    private ArrayList<Customer> customers;
    private ArrayList<Court> courts;
    private ArrayList<Reservation> reservations;

    public PaddleManager() {
        customers = new ArrayList<>();
        courts = new ArrayList<>();
        reservations = new ArrayList<>();
    }

    public ArrayList<Customer> getCustomers() {
        return this.customers;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addCourt(Court court) {
        courts.add(court);
    }

    public Customer getCustomer(int index) {
        if (index >= 0 && index < customers.size()) {
            return customers.get(index);
        } else {
            return null; // Manejo de índices fuera de rango, puedes ajustarlo según tus necesidades.
        }
    }

    public Court getCourt(int index) {
        if (index >= 0 && index < courts.size()) {
            return courts.get(index);
        } else {
            return null; // Manejo de índices fuera de rango, puedes ajustarlo según tus necesidades.
        }
    }

    public ArrayList<Reservation> getReservations() {
        return this.reservations;
    }

    public Reservation reserve(Customer customer, Court court, Date date, String extra) {

        if (!isCourtAvailable(court, date)) {
            return null;
        }
        Reservation reservation = new Reservation(customer, court, date, extra);
        reservations.add(reservation);
        court.addReservation(reservation);
        return reservation;
    }

    public boolean cancelReservation(Reservation reservation) {
        if (reservations.remove(reservation)) {
            Court court = reservation.getCourt();
            if (court != null) {
                court.removeReservation(reservation);
            }

            return true;
        } else {
            return false;
        }
    }

    private boolean isCourtAvailable(Court court, Date date) {
  for (Reservation reservation : reservations) {
            if (reservation.getCourt() == court && reservation.getDate().equals(date)) {
                return false;
            }
        }

        return true;
    }
}
