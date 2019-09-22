package com.example.theclubd.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.theclubd.R;

public class bites1 extends AppCompatActivity {

    private Button insert,view,tohome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bites1);
        getSupportActionBar().hide();


        insert = (Button) findViewById(R.id.insert_btn);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bites1.this, InsertBiteActivity.class);
                startActivity(intent);

            }
        });


        view = (Button) findViewById(R.id.view_btn);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bites1.this, biteListActivity.class);
                startActivity(intent);

            }
        });


        tohome = (Button) findViewById(R.id.toHome_btn);

        tohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bites1.this, DashboardActivity.class);
                startActivity(intent);

            }
        });

    }
}

