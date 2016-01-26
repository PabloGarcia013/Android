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
import com.example.cice.mistrastos.api.ApiManager;
import com.example.cice.mistrastos.recyclerview.adapter.TrastoRecyclerAdapater;
import com.example.cice.mistrastos.model.Trasto;

import java.util.ArrayList;

/**
 * Created by CICE on 7/1/16.
 */
public class RecyclerViewFragment extends Fragment {

    private static final int REQ_CODE = 1;
    private static final String ARG_FAB = "with_fab";
    private static final String ARG_TRASTOS = "trastos";

    RecyclerView recyclerView;
    TrastoRecyclerAdapater adapter;
    ApiManager apiManager;
    boolean withFab;
    ArrayList<Trasto> trastos;


    public static RecyclerViewFragment newInstance(ArrayList<Trasto> trastos, boolean withFAB) {

        Bundle args = new Bundle();

        args.putBoolean(ARG_FAB,withFAB);
        args.putParcelableArrayList(ARG_TRASTOS, trastos);

        RecyclerViewFragment fragment = new RecyclerViewFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        this.withFab = args.getBoolean(ARG_FAB);
        this.trastos = args.getParcelableArrayList(ARG_TRASTOS);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_recycler_view,container,false);

        this.apiManager = new ApiManager(getContext());

        recyclerView = (RecyclerView)layout.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //FAB
        FloatingActionButton fab = (FloatingActionButton) layout.findViewById(R.id.fab);
        if (withFab){
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(), NewTrastoActivity.class);
                    startActivityForResult(intent, REQ_CODE);
                }
            });
        }else{
            fab.setVisibility(View.GONE);
        }


        adapter = new TrastoRecyclerAdapater(getContext(),getTrastos());
        recyclerView.setAdapter(adapter);

        return layout;
    }

    private ArrayList<Trasto> getTrastos(){
        return apiManager.getTrastos();
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.setDataSet(trastos);
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

    public void setDataSet(ArrayList<Trasto> trastos){
        this.trastos = trastos;
        getArguments().putParcelableArrayList(ARG_TRASTOS, trastos);
        adapter.setDataSet(trastos);
    }
}
