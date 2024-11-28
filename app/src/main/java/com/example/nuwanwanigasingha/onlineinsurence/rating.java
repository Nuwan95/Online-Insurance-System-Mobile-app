package com.example.nuwanwanigasingha.onlineinsurence;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class rating extends AppCompatActivity {
    //private static ListView listView;
    //private static String[] NAMES= new String[]{"tom","mark","nuwan","jim","sam"};

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<Contact> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        recyclerView = (RecyclerView)findViewById(R.id.recycleview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        BackgroundTask backgroundTask = new BackgroundTask(rating.this);
        arrayList = backgroundTask.getList();
        adapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);
        //setListView();
    }



}
