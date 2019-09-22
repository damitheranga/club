package com.example.theclubd.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.theclubd.R;
import com.example.theclubd.database.DBHelper;
import com.example.theclubd.model.modelBite;

public class InsertBiteActivity extends AppCompatActivity {

    EditText cnameid,lnameid,biteid,sdrinkid,priceid,desid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_bite);
        getSupportActionBar().hide();

        cnameid = findViewById(R.id.cnameid);
        lnameid = findViewById(R.id.lnameid);
        biteid = findViewById(R.id.biteid);
        sdrinkid = findViewById(R.id.sdrinkid);
        priceid = findViewById(R.id.priceid);
        desid = findViewById(R.id.desid);


    }

    public void process(View view) {
        switch (view.getId())
        {
            case R.id.insert_btn2:
                String cname = cnameid.getText().toString();

                if(TextUtils.isEmpty(cname))
                {
                    cnameid.setError("Please provide this");
                    return;
                }

                String lname = lnameid.getText().toString();

                if(TextUtils.isEmpty(lname))
                {
                    lnameid.setError("Please provide this");
                    return;
                }

                String bite = biteid.getText().toString();

                if(TextUtils.isEmpty(bite))
                {
                    biteid.setError("Please provide this");
                    return;
                }
                String sdrink = sdrinkid.getText().toString();

                if(TextUtils.isEmpty(sdrink))
                {
                    sdrinkid.setError("Please provide this");
                    return;
                }
                String price = priceid.getText().toString();

                if(TextUtils.isEmpty(price))
                {
                    priceid.setError("Please provide this");
                    return;
                }
                String des = desid.getText().toString();

                if(TextUtils.isEmpty(des))
                {
                    desid.setError("Please provide this");
                    return;
                }

                DBHelper dbHelper = new DBHelper(this);


                modelBite model = new modelBite(cname, lname, bite,sdrink,price,des);
                long result = dbHelper.addBite(model);

                if(result != -1)
                {
                    Toast.makeText(this, "Added Successfully", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(this, "Unsuccesfull", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.showbtn:
                startActivity(new Intent(InsertBiteActivity.this, biteListActivity.class));
                break;

        }
    }
}

