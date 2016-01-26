package com.example.cice.mistrastos.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cice.mistrastos.R;
import com.example.cice.mistrastos.model.Trasto;

public class TrastoDetailActivity extends AppCompatActivity {

    Trasto trasto;
    TextView editTextName, editTextInfo, editTextPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trasto_detail);

        trasto = getIntent().getParcelableExtra("trasto");

        editTextName = (EditText) findViewById(R.id.edit_text_name);
        editTextInfo = (EditText) findViewById(R.id.edit_text_info);
        editTextPrice = (EditText) findViewById(R.id.edit_text_price);

        editTextName.setText(trasto.getName());
        editTextInfo.setText(trasto.getInfo());
        editTextPrice.setText(String.valueOf(trasto.getPrice()));
    }
}
