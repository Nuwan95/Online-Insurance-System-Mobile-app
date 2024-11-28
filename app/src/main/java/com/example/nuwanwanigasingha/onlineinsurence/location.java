package com.example.nuwanwanigasingha.onlineinsurence;

import com.google.gson.annotations.SerializedName;

/**
 * Created by NUWAN WANIGASINGHA on 11/24/2017.
 */

public class location {
    @SerializedName("garage_name")
    private String garage_name ;

    @SerializedName("lat")
    private String lat;

    @SerializedName("lon")
    private  String lon;

    public String getGarage_name() {
        return garage_name;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }
}
