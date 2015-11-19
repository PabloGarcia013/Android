package com.garcia.pablo.cice.layouts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LinearActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);
    }

    public void onClickGoToRelative(View view) {
        Intent intent = new Intent(LinearActivity.this,RelativeActivity.class);
        this.startActivity(intent);
    }
}
