package com.example.theclubd.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.theclubd.R;

public class DashboardActivity extends AppCompatActivity {

    Button liqourbtn, cocktailbtn, empbtn, ownerbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().hide();

        cocktailbtn = (Button)findViewById(R.id.add_co);

        cocktailbtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, splashBiteActivity.class);
                startActivity(intent);
            }
        });


        liqourbtn = (Button)findViewById(R.id.add_liq);

        liqourbtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, SplashActivity.class);
                startActivity(intent);
            }
        });

        empbtn = (Button)findViewById(R.id.add_emp);

        empbtn.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, SplashDActivity.class);
                startActivity(intent);
            }
        });








    }
}