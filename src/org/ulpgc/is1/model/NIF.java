package org.ulpgc.is1.model;

public class NIF {
    private final String number;

    private NIF(String number) {
        this.number = number;
    }

    public static NIF create(String number) {
        NIF nif = new NIF(number);
        if (!nif.isValid()) return new NIF("XXXX");
        return nif;
    }

    public boolean isValid() {
        if (this.number.length() != 9) return false;
        return this.number.matches("\\d{8}[A-Z]");
    }

    public String getNumber() {
        return this.number;
    }
}
