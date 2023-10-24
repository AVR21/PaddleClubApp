package org.ulpgc.is1.control;

import org.ulpgc.is1.model.CourtType;
import org.ulpgc.is1.model.PaddleManager;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        PaddleManager manager = new PaddleManager();
        init(manager);
        System.out.println("\nNIF's válidos de los clientes del club:");
        int size = manager.countCustomers();
        for (int i = 0; i < size; i++) {
            if (!manager.getCustomer(i).getNif().getNumber().equals("XXXX")) {
                System.out.println("Cliente con nombre: " + manager.getCustomer(i).getName() + " con NIF válido: " + manager.getCustomer(i).getNif().getNumber());
            }
        }

        System.out.println("\nDatos del primer cliente:\n" +
                "Nombre: " + manager.getCustomer(0).getName() + "\n" +
                "Apellido: " + manager.getCustomer(0).getSurname() + "\n" +
                "NIF: " + manager.getCustomer(0).getNif().getNumber());

        System.out.println("\nDatos del segundo cliente:\n" +
                "Nombre: " + manager.getCustomer(1).getName() + "\n" +
                "Apellido: " + manager.getCustomer(1).getSurname() + "\n" +
                "NIF: " + manager.getCustomer(1).getNif().getNumber());

        System.out.println("\nDatos de la segunda pista:\n" +
                "Nombre: " + manager.getCourt(1).getName() + "\n" +
                "Precio: " + manager.getCourt(1).getPrice() + "€\n" +
                "Tipo: " + manager.getCourt(1).getType() + "\n" +
                "Número de reservas: " + manager.getCourt(1).countReservations());

        manager.reserve(manager.getCustomer(0), manager.getCourt(1), new Date());
        manager.removeCustomer(1);
        System.out.println("\nDatos de reservas:\n" +
                "Identificador de la reserva:  " + manager.getCustomer(0).getReservation(0).getId() + "\n" +
                "Fecha de la reserva: " + manager.getCustomer(0).getReservation(0).getDate().toString() + "\n" +
                "Nombre y Apellido del cliente: " + manager.getCustomer(0).getName() + " " +
                manager.getCustomer(0).getSurname() + "\n" +
                "Cancha seleccionada: " + manager.getCustomer(0).getReservation(0).getCourt().getName() + "\n" +
                "Precio de la reserva: " + manager.getCustomer(0).getReservation(0).price() + "€");
    }

    private static void init(PaddleManager manager) {

        manager.addCustomer("Francesco", "Vergollini", "12345678A");
        manager.addCustomer("Pablo", "Pérez", "12SD34TT4");
        manager.addCourt("Pista Rápida", 130, CourtType.FastCourt);
        manager.addCourt("Pista Lenta", 80, CourtType.SlowCourt);
    }
}
