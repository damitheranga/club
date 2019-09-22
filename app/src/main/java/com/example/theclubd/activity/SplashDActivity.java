package com.example.theclubd.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.theclubd.R;

public class SplashDActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        getSupportActionBar().hide();











        Thread t = new Thread(new Runnable(){
            @Override
            public void run() {

                try {
                    Thread.sleep(2 * 1000);
                    startActivity(new Intent(SplashDActivity.this, AddOwnerActivity.class));
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });






        t.start();
    }
}
