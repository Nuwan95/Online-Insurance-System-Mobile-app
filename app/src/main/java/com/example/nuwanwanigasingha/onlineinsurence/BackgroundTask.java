package com.example.nuwanwanigasingha.onlineinsurence;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

import java.util.ArrayList;

/**
 * Created by NUWAN WANIGASINGHA on 12/7/2017.
 */

public class BackgroundTask {
    Context context;
    ArrayList<Contact> arrayList = new ArrayList<>();
    String json_url = "http://10.10.4.194:8080/getGarage/";
    String server_url_with_get_data;
    public String lat = "TEST1";
    public String longt="TEST";

    public BackgroundTask(Context context) {
        this.context = context;
    }

    public ArrayList<Contact> getList(){

        server_url_with_get_data = json_url +lat+"/"+longt;

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,json_url, (String)null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        try {

                            JSONArray jsonArray = response.getJSONArray("list");


                            DailyMovie movie = new DailyMovie();
                            for (int a = 0; a < jsonArray.length(); a++) {
                                JSONObject obj = jsonArray.getJSONObject(a);
                                System.out.println("Object Value " + a + " " + obj.toString());

                                movie.setId(obj.getString("id"));

                                movie.setTitle(obj.getString("title"));

                                movie.setOwner(obj.getString("owner"));

                                movie.setChannel(obj.getString("channel"));
                                // adding movie to movies array

                                movieList.add(movie);
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        /*int count = 0;
                        while (count < response.length()){
                            try {
                                JSONObject jsonObject =response.getJSONObject(count);
                                Contact contact = new Contact(jsonObject.getString("garage_name"));
                                arrayList.add(contact);
                                count++;
                            }catch (JSONException e){
                                e.printStackTrace();
                            }
                        }*/
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"Error..",Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        }
        );

        MySingleton.getmInstance(context).addRequestque(jsonArrayRequest);
        return arrayList;
    }
}
