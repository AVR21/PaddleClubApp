package org.ulpgc.is1.model;

import java.util.Date;

public class Reservation {
    private static int NEXT_ID = 0;
    private final int id;
    private Date date;

    public Reservation(){

    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
