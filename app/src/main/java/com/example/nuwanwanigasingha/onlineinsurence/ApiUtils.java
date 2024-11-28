package com.example.nuwanwanigasingha.onlineinsurence;

/**
 * Created by NUWAN WANIGASINGHA on 11/20/2017.
 */

public class ApiUtils {
    private ApiUtils() {}

    public static final String BASE_URL = "http://10.10.4.194:8080/";

    public static APIService getAPIService() {
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
