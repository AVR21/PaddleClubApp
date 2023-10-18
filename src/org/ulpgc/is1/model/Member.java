package org.ulpgc.is1.model;

public class Member extends Customer{
    public int points;
    public Address address;

    public Member(String name, String surname, NIF nif) {
        super(name, surname, nif);
    }
}
