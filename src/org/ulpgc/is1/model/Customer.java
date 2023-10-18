package org.ulpgc.is1.model;

public class Customer {
    private String name;
    private String surname;
    private NIF nif;


    public Customer(String name, String surname, String nif){
        this.name = name;
        this.surname = surname;
        this.nif = NIF.create(nif);
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
}
