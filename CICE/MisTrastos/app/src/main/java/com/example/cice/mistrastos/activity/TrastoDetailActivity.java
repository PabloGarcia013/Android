package com.example.cice.mistrastos.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.cice.mistrastos.R;
import com.example.cice.mistrastos.model.Trasto;

public class TrastoDetailActivity extends AppCompatActivity {

    Trasto trasto;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trasto_detail);

        trasto =getIntent().getParcelableExtra("trasto");

        textView = (TextView) findViewById(R.id.trasto_name);
        textView.setText(trasto.getName());
    }
}
