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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
