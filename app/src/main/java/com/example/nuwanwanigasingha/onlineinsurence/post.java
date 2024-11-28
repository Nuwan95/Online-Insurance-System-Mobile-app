package com.example.nuwanwanigasingha.onlineinsurence;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by NUWAN WANIGASINGHA on 11/19/2017.
 */

public class post {
    @SerializedName("license")
    @Expose
    private String license;

    @SerializedName("lat")
    public String lat;

    @SerializedName("longt")
    public String longt;

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }
}
