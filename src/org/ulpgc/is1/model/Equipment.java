package org.ulpgc.is1.model;

public class Equipment extends Extra{
    public String name;

    public Equipment(int price, String name) {
        super(price);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
