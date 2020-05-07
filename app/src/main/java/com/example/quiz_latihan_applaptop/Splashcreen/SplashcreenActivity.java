package com.example.quiz_latihan_applaptop.Splashcreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.quiz_latihan_applaptop.MainActivity;
import com.example.quiz_latihan_applaptop.R;

public class SplashcreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashcreen);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(SplashcreenActivity.this, MainActivity.class));


            }
        }, 5000);
    }
}