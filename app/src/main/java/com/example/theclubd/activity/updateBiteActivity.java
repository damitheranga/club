package com.example.theclubd.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.theclubd.R;
import com.example.theclubd.database.DBHelper;
import com.example.theclubd.model.modelBite;

public class updateBiteActivity extends AppCompatActivity {

    EditText cnameid,lnameid,biteid,sdrinkid,priceid,desid;
    DBHelper dbHelper;

    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_bite);
        getSupportActionBar().hide();


        dbHelper = new DBHelper(this);
        cnameid = findViewById(R.id.cnameid);
        lnameid = findViewById(R.id.lnameid);
        biteid = findViewById(R.id.biteid);
        sdrinkid = findViewById(R.id.sdrinkid);
        priceid = findViewById(R.id.priceid);
        desid = findViewById(R.id.desid);

        modelBite bite = (modelBite) getIntent().getExtras().getSerializable("modelBite");

        id = bite.getId();
        cnameid.setText(bite.getCname() );
        lnameid.setText(bite.getLname());
        biteid.setText(bite.getBite());
        sdrinkid.setText(bite.getSdrink());
        priceid.setText(bite.getPrice());
        desid.setText(bite.getDes());
    }


    public void update(View view) {
        String upcname = cnameid.getText().toString();
        String uplname = lnameid.getText().toString();
        String upbite = biteid.getText().toString();
        String upsdrink = sdrinkid.getText().toString();
        String upprice = priceid.getText().toString();
        String updes = desid.getText().toString();

        modelBite bite = new modelBite(id, upcname, uplname,upbite,upsdrink,upprice,updes);

        int result = dbHelper.updateBite(bite);

        if (result >0)
        {
            Toast.makeText(this, "DETAILS UPDATED", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Some thing went wrong", Toast.LENGTH_SHORT).show();
        }

    }
}

