package com.example.cice.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    TrastosDatabaseManager trastosDatabaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        trastosDatabaseManager = new TrastosDatabaseManager(this);

        Trasto trasto = new Trasto();
        trasto.setName("Bicicleta");

        trastosDatabaseManager.insertTrastos(trasto);

    }
}
