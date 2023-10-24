package org.ulpgc.is1.control;

import org.ulpgc.is1.model.CourtType;
import org.ulpgc.is1.model.PaddleManager;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        PaddleManager manager = new PaddleManager();

        System.out.println("\nRegistro de nuevos usuarios y pistas... [Método init(...)]");
        init(manager);

        System.out.println("\nAhora hay " + manager.countCustomers() + " clientes en la base de datos.");
        System.out.println("\nAhora hay " + manager.countCourts() + " pistas en la base de datos.");

        System.out.println("\nNIFs de los clientes del club:");
        int size = manager.countCustomers();
        for (int i = 0; i < size; i++) {
            if (!manager.getCustomer(i).getNif().getNumber().equals("XXXX")) {
                if(manager.getMember(i) == null)
                    System.out.println(" - Cliente con nombre " + manager.getCustomer(i).getName() + " y con NIF válido: " + manager.getCustomer(i).getNif().getNumber());
                else System.out.println(" - Miembro del club con nombre " + manager.getCustomer(i).getName() + " y con NIF válido: " + manager.getCustomer(i).getNif().getNumber());
            } else {
                if(manager.getMember(i) == null)
                    System.out.println(" - Cliente con nombre " + manager.getCustomer(i).getName() + " y con NIF no válido: " + manager.getCustomer(i).getNif().getNumber());
                else System.out.println(" - Miembro del club con nombre " + manager.getCustomer(i).getName() + " y con NIF no válido: " + manager.getCustomer(i).getNif().getNumber());
            }
        }

        System.out.println("\nDatos del primer cliente " + ((manager.getMember(0)!= null) ? "(Miembro) : \n" : ": \n") +
                "Nombre: " + manager.getMember(0).getName() + "\n" +
                "Apellido: " + manager.getMember(0).getSurname() + "\n" +
                "NIF: " + manager.getMember(0).getNif().getNumber() + "\n" +
                "Puntos de socio: " + manager.getMember(0).getPoints() + " pts.\n" +
                "Residencia: " + manager.getMember(0).getAddress().toString());

        System.out.println("\nDatos del segundo cliente:\n" +
                "Nombre: " + manager.getCustomer(1).getName() + "\n" +
                "Apellido: " + manager.getCustomer(1).getSurname() + "\n" +
                "NIF: " + manager.getCustomer(1).getNif().getNumber());

        System.out.println("\nDatos de la segunda pista:\n" +
                "Nombre: " + manager.getCourt(1).getName() + "\n" +
                "Precio: " + manager.getCourt(1).getPrice() + "€\n" +
                "Tipo: " + manager.getCourt(1).getType().displayType() + "\n" +
                "Número de reservas: " + manager.getCourt(1).countReservations());

        System.out.println("\nReserva del primer cliente en la segunda pista...");
        manager.reserve(manager.getCustomer(0), manager.getCourt(1), new Date());
        manager.removeCustomer(1);
        System.out.println("\nBorrado del segundo cliente de la base de datos, ahora hay " +
                manager.countCustomers() + " clientes en la base de datos");

        System.out.println("\nDatos de reservas:\n" +
                "Identificador de la reserva:  " + manager.getCustomer(0).getReservation(0).getId() + "\n" +
                "Fecha de la reserva: " + manager.getCustomer(0).getReservation(0).getDate().toString() + "\n" +
                "Nombre y Apellido del cliente: " + manager.getCustomer(0).getName() + " " +
                manager.getCustomer(0).getSurname() + "\n" +
                "Pista seleccionada: " + manager.getCustomer(0).getReservation(0).getCourt().getName() + "\n" +
                "Precio de la reserva: " + manager.getCustomer(0).getReservation(0).price() + "€");
    }

    private static void init(PaddleManager manager) {
        manager.addMember("Francesco", "Vergollini", "61631648C", "Calle Menorca", 4, 35000, "Las Palmas");
        manager.addCustomer("Pablo", "Pérez", "12SD34TT4");

        manager.addCourt("Pista Rápida", 130, CourtType.FastCourt);
        manager.addCourt("Pista Lenta", 80, CourtType.SlowCourt);

    }
}
