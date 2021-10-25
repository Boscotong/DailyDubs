package com.example.dailydubs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    TextView eChallenge;
    Button eNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        eChallenge = findViewById(R.id.tvChallenge);
        eNext = findViewById(R.id.btnNext);
    }
}