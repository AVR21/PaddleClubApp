package org.ulpgc.is1.model;

public class Member extends Customer{
    private int points;

    public Address address;

    public Member(String name, String surname, String nif) {
        super(name, surname, nif);
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setAddress(String street, int number, int postalCode, String city) {
        this.address = new Address(street, number, postalCode, city);
    }

    public Address getAddress() {
        return address;
    }
}
