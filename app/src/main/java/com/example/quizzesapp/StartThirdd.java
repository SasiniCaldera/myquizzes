package com.example.quizzesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StartThirdd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void startGame(View view) {
        Intent intent = new Intent(StartThirdd.this, StartThird.class);
        startActivity(intent);

    }
}