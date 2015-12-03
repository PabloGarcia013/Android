package com.example.cice.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by cice on 3/12/15.
 */
public class MyViewPagerAdapter extends FragmentPagerAdapter {

    // declaramos los fragments
    ArrayList<Fragment> arrayList;

    public MyViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return this.arrayList.get(position);
    }

    // Aqui declaramos que como máximo se va a llamar a NUM_PAGES paginas es decir nunca accederemos a una posicion vacía.
    @Override
    public int getCount() {
        return this.arrayList.size();
    }

    public void addFragment(Fragment f){
        this.arrayList.add(f);
    }
}
