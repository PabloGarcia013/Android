package com.example.cice.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{
    ViewPager viewPager;
    RadioButton radioButton1,radioButton2,radioButton3;
    Fragment page1,page2,page3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Aqui configuramos el view Pager con su adapter

        // BIDING
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        radioButton1 = (RadioButton) findViewById(R.id.radio1);
        radioButton2 = (RadioButton) findViewById(R.id.radio2);
        radioButton3 = (RadioButton) findViewById(R.id.radio3);

        // Creo el adapter.
        FragmentPagerAdapter fragmentPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager()); // getSupportFragmentManager -> Pertenece a la activity.

        // Creamos los fragments y los asignamos.
        page1 = FirstFragment.newInstance();
        page2 = SecondFragment.newInstance();
        page3 = ThirdFragment.newInstance();

        fragmentPagerAdapter.addFragment(page1);

        // Asociamos el adapter con el viewPager
        viewPager.setAdapter(fragmentPagerAdapter);

        viewPager.addOnPageChangeListener(this);
    }

    public void goToPageRadioButton(View v){
        switch (v.getId()){
            case R.id.radio1:
                // Cambio a la pagina 1.
                viewPager.setCurrentItem(0);
                break;
            case R.id.radio2:
                // Cambio a la pagina 2.
                viewPager.setCurrentItem(1);
                break;
            case R.id.radio3:
                // Cambio a la pagina 3.
                viewPager.setCurrentItem(2);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                radioButton1.setChecked(true);
                break;
            case 1:
                radioButton2.setChecked(true);
                break;
            case 2:
                radioButton3.setChecked(true);
                break;
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if(state==ViewPager.SCROLL_STATE_DRAGGING){

        }else if(state==ViewPager.SCROLL_STATE_SETTLING){

        }else if(state==ViewPager.SCROLL_STATE_IDLE){

        }
    }
}