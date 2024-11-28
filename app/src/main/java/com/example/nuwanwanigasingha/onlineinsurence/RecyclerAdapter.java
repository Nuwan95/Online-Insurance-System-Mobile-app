package com.example.nuwanwanigasingha.onlineinsurence;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by NUWAN WANIGASINGHA on 12/7/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{

    ArrayList<Contact> arrayList = new ArrayList<>();

    public RecyclerAdapter(ArrayList<Contact> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return  myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.MyViewHolder holder, int position) {
        holder.garage_name.setText(arrayList.get(position).getGarage_name());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView garage_name;
        public MyViewHolder(View itemView) {
            super(itemView);
            garage_name = (TextView)itemView.findViewById(R.id.textView8);
        }
    }
}
