package org.ulpgc.is1.model;

public class Equipment extends Extra{
    public String name;

    public Equipment(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
