package com.example.theclubd.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.theclubd.R;

import java.io.InterruptedIOException;

public class splashBiteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_bite);
        getSupportActionBar().hide();


        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

                try{
                    Thread.sleep(1*1000);
                    startActivity(new Intent(splashBiteActivity.this, bites1.class));
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
}
