package com.example.quizzesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Firstactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstactivity);
    }
    public void start(View view) {
        Intent intent = new Intent(Firstactivity.this, MainActivity.class);
        startActivity(intent);
    }
    public void startsecond(View view) {
        Intent intent = new Intent(Firstactivity.this, StartSecondd.class);
        startActivity(intent);
    }
    public void startthird(View view) {
        Intent intent = new Intent(Firstactivity.this, StartThirdd.class);
        startActivity(intent);
    }
}