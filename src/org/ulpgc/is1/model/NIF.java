package org.ulpgc.is1.model;

public class NIF {
    private final String number;

    private NIF(String number){
        this.number = number;
    }

    public static NIF create(String number){
        if(!isValid(number)) return new NIF("XXXX");
        return new NIF(number);
    }

    private static boolean isValid(String number){
        if(number.length() != 9) return false;
        return number.matches("\\d{8}[A-Z]");
    }

    public String getNumber() {
        return this.number;
    }

}
