package com.example.cice.mistrastos.recyclerview.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cice.mistrastos.R;
import com.example.cice.mistrastos.recyclerview.viewholder.TrastoViewHolder;
import com.example.cice.mistrastos.activity.TrastoDetailActivity;
import com.example.cice.mistrastos.model.Trasto;

import java.util.ArrayList;

/**
 * Created by CICE on 12/1/16.
 */
public class TrastoRecyclerAdapater extends RecyclerView.Adapter<TrastoViewHolder> implements TrastoViewHolder.OnRowClickListener{

    ArrayList<Trasto> trastos;
    Context context;

    public TrastoRecyclerAdapater() {
        this.trastos = new ArrayList<>();
    }

    public TrastoRecyclerAdapater(Context context, ArrayList<Trasto> trastos) {
        this.trastos = trastos;
        this.context = context;
    }

    @Override
    public TrastoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_trasto,parent,false);

        return new TrastoViewHolder(layout,this);
    }

    @Override
    public void onBindViewHolder(TrastoViewHolder holder, int position) {
        holder.bind(trastos.get(position));
    }

    @Override
    public int getItemCount() {
        return trastos.size();
    }

    @Override
    public void onTrastoClicked(Trasto trasto) {
        Intent intent = new Intent(context, TrastoDetailActivity.class);
        intent.putExtra("trasto",trasto);
        context.startActivity(intent);
    }

    public void insertTrasto(Trasto trasto){
        trastos.add(0, trasto);
    }

    public void setDataSet(ArrayList<Trasto> trastos){
        this.trastos = trastos;
        notifyDataSetChanged();
    }
}
