package com.garcia.pablo.cice.appstart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Lanza la activity DetailActivity.
     * @param view Vista en la que se hizo click.
     */
    public void onClickMyButton(View view){
        Intent intent = new Intent(MainActivity.this,DetailActivity.class);
        startActivity(intent);
    }
}
