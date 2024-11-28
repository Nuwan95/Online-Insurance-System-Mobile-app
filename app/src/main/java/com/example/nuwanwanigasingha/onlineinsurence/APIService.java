package com.example.nuwanwanigasingha.onlineinsurence;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by NUWAN WANIGASINGHA on 11/20/2017.
 */

public interface APIService {
    @GET("report/{license}/{lat}/{longt}")
    //@FormUrlEncoded
    Call<post> savePost(@Path(value = "license",encoded = true) String license,@Path(value = "lat",encoded = true) String lat, @Path(value = "longt",encoded = true) String longt);

    @POST("/upload")
    //@FormUrlEncoded
    Call<image> uploadimage(@Field("image") String image);

    @GET("")
    Call<List<location>> getLocationInfo();


    @GET("hello")
    Call<ResponseBody> hello();
}
