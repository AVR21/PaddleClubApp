package org.ulpgc.is1.control;

import org.ulpgc.is1.model.CourtType;
import org.ulpgc.is1.model.PaddleManager;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        PaddleManager manager = new PaddleManager();
        init(manager);
        System.out.println("NIF's válidos de los clientes del club:");
        int size = manager.getCustomers().size();
        for(int i = 0; i < size; i++){
            if (!manager.getCustomer(i).getNif().getNumber().equals("XXXX")){
                System.out.println("Cliente número " + i + "con NIF válido: " + manager.getCustomer(i).getNif().getNumber());
            }
        }

        System.out.println("Datos del primer cliente:\n" +
                "Nombre: " + manager.getCustomer(0).getName() + "\n" +
                "Apellido: " + manager.getCustomer(0).getSurname() + "\n" +
                "NIF: " + manager.getCustomer(0).getNif());

        System.out.println("Datos del segundo cliente:\n" +
                "Nombre: " + manager.getCustomer(1).getName() + "\n" +
                "Apellido: " + manager.getCustomer(1).getSurname() + "\n" +
                "NIF: " + manager.getCustomer(1).getNif());

        System.out.println("Datos de la segunda pista:\n" +
                "Nombre: " + manager.getCourt(1).getName() + "\n" +
                "Precio: " + manager.getCourt(1).getPrice() + "€\n" +
                "Tipo: " + manager.getCourt(1).getType() + "\n" +
                "Número de reservas: " + manager.getCourt(1).getReservations().size());

        manager.reserve(manager.getCustomer(0), manager.getCourt(1), new Date());
        manager.getCustomer(1).removeReservation()
        }
    }

    private static void init(PaddleManager manager) {


        manager.addCustomer("Francesco", "Vergollini", "12345678A");
        manager.addCustomer("Pablo", "Pérez", "12SD34TT4");
        manager.addCourt("Pista Rápida", 130, CourtType.FastCourt);
        manager.addCourt("Pista Lenta", 80, CourtType.SlowCourt);
    }
}
