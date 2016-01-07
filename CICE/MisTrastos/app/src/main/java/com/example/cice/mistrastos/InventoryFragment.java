package com.example.cice.mistrastos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by CICE on 7/1/16.
 */
public class InventoryFragment extends Fragment {

    Toolbar toolbar;
    AppBarLayout appBarLayout;
    TabLayout tabLayout;
    ViewPager viewPager;

    MainActivity mainActivity;

    public static InventoryFragment newInstance() {
        
        Bundle args = new Bundle();
        
        InventoryFragment fragment = new InventoryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity = (MainActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_inventory,container,false);

        doBindings(layout);
        setupToolbar();
        setupTabLayout();

        return layout;
    }

    private void doBindings(View layout){
        toolbar = (Toolbar) layout.findViewById(R.id.toolbar);
        appBarLayout = (AppBarLayout) layout.findViewById(R.id.appbar_layout);
        tabLayout = (TabLayout) layout.findViewById(R.id.tab_layout);
        viewPager = (ViewPager) layout.findViewById(R.id.view_pager);
    }

    private void setupToolbar(){
        setHasOptionsMenu(true);
        mainActivity.setSupportActionBar(toolbar);
        ActionBar actionBar = mainActivity.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Mis Trastos");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setupViewPager(){

        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(RecyclerViewFragment.newInstance());
        fragments.add(RecyclerViewFragment.newInstance());
        fragments.add(RecyclerViewFragment.newInstance());

        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getFragmentManager(),fragments);
        viewPager.setAdapter(mainViewPagerAdapter);
    }

    private void setupTabLayout(){
        setupViewPager();
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                mainActivity.drawerLayout.openDrawer(GravityCompat.START);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
