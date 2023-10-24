package org.ulpgc.is1.model;

public class NIF {
    private String number;

    private NIF(String number) {
        this.number = number;
    }

    public static NIF create(String number) {
        NIF nif = new NIF(number);
        if (!nif.isValid()) return new NIF("XXXX");
        return nif;
    }

    public boolean isValid() {
        return isValid(this.number);
    }

    private static boolean isValid(String number) {
        if (number.length() != 9) return false;
        if (!number.matches("\\d{8}[A-Z]")) return false;
        String NIF_ASOTIATION = "TRWAGMYFPDXBNJZSQVHLCKE";
        int checkNIF = Integer.parseInt(number.substring(0,8));
        return NIF_ASOTIATION.charAt(checkNIF % 23)==(number.charAt(8));
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number){
        if (isValid(number)) this.number = number;
    }
}
