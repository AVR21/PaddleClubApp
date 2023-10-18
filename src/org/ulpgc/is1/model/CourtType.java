package org.ulpgc.is1.model;

public enum CourtType {
    SlowCourt("Slow court"),
    FastCourt("Fast court");

    private final String displayType;

    CourtType(String displayType){
        this.displayType = displayType;
    }
    public String displayType(){
        return displayType;
    }

}
