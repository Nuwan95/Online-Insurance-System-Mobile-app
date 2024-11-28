package com.example.nuwanwanigasingha.onlineinsurence;

import android.graphics.Bitmap;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.ByteArrayOutputStream;

/**
 * Created by NUWAN WANIGASINGHA on 11/20/2017.
 */

public class image {
    @SerializedName("image")
    private String Image;

    @SerializedName("response")
    private String Response;

    public String getResponse() {
        return Response;
    }
}
