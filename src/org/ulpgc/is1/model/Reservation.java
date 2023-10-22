package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.Date;

public class Reservation {
    private static int NEXT_ID = 0;
    private final int id;
    private Date date;
    private Customer customer;
    private Court court;
    private ArrayList<Extra> extras;

    public Reservation(Customer customer, Court court, Date date, String extra){
        this.id = NEXT_ID++;
        this.customer = customer;
        this.court = court;
        this.extras = new ArrayList<>();
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Court getCourt() {
        return court;
    }

    public void setCourt(Court court) {
        this.court = court;
    }

    public ArrayList<Extra> getExtras() {
        return extras;
    }

    public boolean addExtra(Extra newExtra){
        return extras.add(newExtra);
    }

    public boolean removeExtra(String extraName){
        for(Extra extra : extras){
            if(extra.getName().equals(extraName))
                return extras.remove(extra);
        }
        return false;
    }

    public Extra getExtra(String extraName){
        for(Extra extra : extras){
            if(extra.getName().equals(extraName))
                return extra;
        }
        return null;
    }

    public int price(){
        int totalPrice = 0;
        for(Extra extra : extras){
            totalPrice += extra.getPrice();
        }
        totalPrice += court.getPrice();
        return totalPrice;
    }
}
