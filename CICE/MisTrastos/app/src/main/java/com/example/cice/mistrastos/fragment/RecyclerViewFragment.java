package com.example.cice.mistrastos.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cice.mistrastos.R;
import com.example.cice.mistrastos.activity.NewTrastoActivity;
import com.example.cice.mistrastos.recyclerview.adapter.TrastoRecyclerAdapater;
import com.example.cice.mistrastos.model.Trasto;

import java.util.ArrayList;

/**
 * Created by CICE on 7/1/16.
 */
public class RecyclerViewFragment extends Fragment {

    private static final int REQ_CODE = 1;
    RecyclerView recyclerView;
    TrastoRecyclerAdapater adapter;


    public static RecyclerViewFragment newInstance() {

        Bundle args = new Bundle();

        RecyclerViewFragment fragment = new RecyclerViewFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_recycler_view,container,false);

        recyclerView = (RecyclerView)layout.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //FAB
        FloatingActionButton fab = (FloatingActionButton) layout.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), NewTrastoActivity.class);
                startActivityForResult(intent, REQ_CODE);
            }
        });

        adapter = new TrastoRecyclerAdapater(getContext(),getTrastos());
        recyclerView.setAdapter(adapter);

        return layout;
    }

    private ArrayList<Trasto> getTrastos(){
        ArrayList<Trasto> trastos = new ArrayList<>();

        trastos.add(new Trasto("Cosa 1",true));
        trastos.add(new Trasto("Cosa 2", true));
        trastos.add(new Trasto("Cosa 3",true));
        trastos.add(new Trasto("Cosa 4",true));
        trastos.add(new Trasto("Cosa 5",true));
        trastos.add(new Trasto("Cosa 6",true));
        trastos.add(new Trasto("Cosa 7",true));
        trastos.add(new Trasto("Cosa 8",true));
        trastos.add(new Trasto("Cosa 9", true));
        trastos.add(new Trasto("Cosa 10",true));
        trastos.add(new Trasto("Cosa 11", true));

        return trastos;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQ_CODE && resultCode == Activity.RESULT_OK){
            Trasto trasto = data.getParcelableExtra("trasto");
            adapter.insertTrasto(trasto);
        }
        recyclerView.scrollToPosition(0);
        adapter.notifyItemInserted(0);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
