package org.ulpgc.is1.control;

import org.ulpgc.is1.model.PaddleManager;

public class Main {
    public static void main(String[] args) {
        PaddleManager manager = new PaddleManager();
        init(manager);
        System.out.println("El nombre del primer cliente es" + manager.getCustomers().get(0).getName());
    }

    private static void init(PaddleManager manager){

    }


}
