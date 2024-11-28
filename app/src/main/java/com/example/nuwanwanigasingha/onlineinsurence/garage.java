package com.example.nuwanwanigasingha.onlineinsurence;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class garage extends AppCompatActivity {
    //private static ListView listView;
    //private static String[] NAMES= new String[]{"matara","colombo","kandy","galle","gampaha"};
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<location> location;
    private RecyclerView.Adapter adapter;
    private APIService mAPIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage);
        recyclerView = (RecyclerView)findViewById(R.id.recycleview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        if(getIntent().getExtras() !=null){
            String type = getIntent().getExtras().getString("type");
            fetchInformation(type);
        }


        //setListView();
    }
    public void fetchInformation(String type){
        mAPIService = ApiUtils.getAPIService();
        Call<List<location>> call = mAPIService.getLocationInfo();

        call.enqueue(new Callback<List<com.example.nuwanwanigasingha.onlineinsurence.location>>() {
            @Override
            public void onResponse(Call<List<location>> call, Response<List<location>> response) {

                location = response.body();
               // adapter = new RecyclerAdapter(location,garage.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<location>> call, Throwable t) {

            }
        });
    }

    public void getmap(View view) {
        //Intent intent = new Intent("com.example.nuwanwanigasingha.onlineinsurence.map");
       //startActivity(intent);
    }

    /*public void setListView(){
        listView = (ListView)findViewById(R.id.listview1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.name_list1,NAMES);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String value = (String)listView.getItemAtPosition(position);
                        //Toast.makeText(rating.this,"Position : "+position+ "Value : "+value,Toast.LENGTH_LONG).show();
                        ListView lv= (ListView) findViewById(R.id.listview1);
                        lv.setSelector( R.drawable.listselecter);
                        //Toast.makeText(getApplicationContext(),
                        //""+position, Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent("com.example.nuwanwanigasingha.onlineinsurence.map");
                                startActivity(intent);


                    }
                }
        );
    }*/
}
