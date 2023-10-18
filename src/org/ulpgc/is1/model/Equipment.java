package org.ulpgc.is1.model;

public class Equipment extends Extra{
    public String name;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
