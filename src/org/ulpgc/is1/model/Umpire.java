package org.ulpgc.is1.model;

public class Umpire extends Extra {

    private String name;
    private String surname;

    public Umpire(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String getName() {
        return null;
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
}
