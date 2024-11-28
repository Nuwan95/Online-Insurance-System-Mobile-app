package com.example.nuwanwanigasingha.onlineinsurence;

/**
 * Created by NUWAN WANIGASINGHA on 12/7/2017.
 */

public class Contact {
    private String garage_name;
    private String garage_lat;
    private String garage_longt;

    public Contact() {
    }

    public Contact(String garage_name, String garage_lat, String garage_longt) {
        this.garage_name = garage_name;
        this.garage_lat = garage_lat;
        this.garage_longt = garage_longt;

    }


    public String getGarage_name() {
        return garage_name;
    }

    public void setGarage_name(String garage_name) {
        this.garage_name = garage_name;
    }

    public String getGarage_lat() {
        return garage_lat;
    }

    public void setGarage_lat(String garage_lat) {
        this.garage_lat = garage_lat;
    }

    public String getGarage_longt() {
        return garage_longt;
    }

    public void setGarage_longt(String garage_longt) {
        this.garage_longt = garage_longt;
    }
}
