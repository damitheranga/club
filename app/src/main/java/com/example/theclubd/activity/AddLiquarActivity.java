package com.example.theclubd.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.theclubd.R;
import com.example.theclubd.database.DBHelper;
import com.example.theclubd.model.Liquar;

public class AddLiquarActivity extends AppCompatActivity {

    Spinner spinner;
    String[] types = {"Arrack","Viskey","Brandy","Beer"};
    ArrayAdapter<String> typeAdapter;

    EditText edName,edBrand,edVol,edPer,edPrice,edBatch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_liquar);
        getSupportActionBar().hide();


        spinner = findViewById(R.id.spinnerType);
        typeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,types);
        spinner.setAdapter(typeAdapter);

        edName = findViewById(R.id.edName);
        edBrand = findViewById(R.id.edBrand);
        edVol = findViewById(R.id.edVol);
        edPer = findViewById(R.id.edPer);
        edPrice = findViewById(R.id.edPrice);
        edBatch = findViewById(R.id.edBatch);

    }

    public void process(View view) {

        switch (view.getId()){
            case R.id.btnSave:

                String name = edName.getText().toString();
                if(TextUtils.isEmpty(name)){
                    edName.setError("Please Provide Name");
                    return;
                }
                String brand = edBrand.getText().toString();
                if(TextUtils.isEmpty((brand))){
                    edBrand.setError("Please Provide Brand");
                    return;
                }
                String type = spinner.getSelectedItem().toString();
                String strVol = edVol.getText().toString();
                if(TextUtils.isEmpty((strVol))){
                    edBrand.setError("Please Provide Volumn");
                    return;
                }
                String strPer = edPer.getText().toString();
                if(TextUtils.isEmpty((strPer))){
                    edBrand.setError("Please Provide Percentage");
                    return;
                }

                String strPrice = edPrice.getText().toString();

                if(TextUtils.isEmpty((strPrice))){
                    edBrand.setError("Please Provide Price");
                    return;
                }
                String batch = edBatch.getText().toString();
                if(TextUtils.isEmpty((batch))){
                    edBrand.setError("Please Provide Batch Code");
                    return;
                }

                int vol = Integer.parseInt(strVol);
                int per = Integer.parseInt(strPer);
                int price = Integer.parseInt(strPrice);



                DBHelper dbHelper = new DBHelper(this);

                Liquar liquar = new Liquar(name, brand, type, vol, price,per,batch);


                boolean isInsterted = dbHelper.addLiq(liquar);
                if(isInsterted = true)
                {
                    Toast.makeText(this, "Inserted", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
                }


                break;

            case R.id.btnShow:
                startActivity(new Intent(AddLiquarActivity.this,LiquarListActivity.class));
                break;
        }
    }
}
