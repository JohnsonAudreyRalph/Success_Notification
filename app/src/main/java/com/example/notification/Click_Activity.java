package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Click_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click);
        getSupportActionBar().setTitle("Click Activity");
    }

    public void Back_MainActivity(){
        Intent intent = new Intent(Click_Activity.this, MainActivity.class);
        startActivity(intent);
    }
}