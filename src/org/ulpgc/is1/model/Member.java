package org.ulpgc.is1.model;

public class Member extends Customer{
    private int points;

    private Address address;

    public static Member create(String name, String surname, String nif, String street, int number, int postalCode, String city){
        Member member = new Member(name, surname, nif);
        member.setAddress(street, number, postalCode, city);
        return member;
    }

    private Member(String name, String surname, String nif) {
        super(name, surname, nif);
        this.points = 0;
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
