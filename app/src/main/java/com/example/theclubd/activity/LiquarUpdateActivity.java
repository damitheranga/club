package com.example.theclubd.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.theclubd.R;
import com.example.theclubd.database.DBHelper;
import com.example.theclubd.model.Liquar;

public class LiquarUpdateActivity extends AppCompatActivity {

    Spinner spinner;
    String[] types = {"Arrack","Viskey","Brandy","Beer"};
    ArrayAdapter<String> typeAdapter;
    EditText edName,edBrand,edVol,edPer,edPrice,edBatch;
    DBHelper dbHelper;

    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liquar_update);
        getSupportActionBar().hide();

        dbHelper = new DBHelper(this);





        edName = findViewById(R.id.edName);
        edBrand = findViewById(R.id.edBrand);
        edVol = findViewById(R.id.edVol);
        edPer = findViewById(R.id.edPer);
        edPrice = findViewById(R.id.edPrice);
        edBatch = findViewById(R.id.edBatch);

        Liquar liquar = (Liquar) getIntent().getExtras().getSerializable("LIQUAR");

        id = liquar.getId();
        edName.setText(liquar.getName());
        edBrand.setText(liquar.getBrand());
        edVol.setText(String.valueOf(liquar.getVol()));
        edPer.setText(String.valueOf(liquar.getPer()));
        edPrice.setText(String.valueOf(liquar.getPrice()));
        edBatch.setText(liquar.getBatch());

        spinner = findViewById(R.id.spinnerType);
        typeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,types);
        spinner.setAdapter(typeAdapter);

        for(int i =0 ; i < types.length; i++){
            if(types[i].equals(liquar.getType()))
            {
                spinner.setSelection(i);
                break;
            }

        }





    }

    public void update(View view) {
        String name = edName.getText().toString();
        String brand = edBrand.getText().toString();
        String type = spinner.getSelectedItem().toString();
        String strVol = edVol.getText().toString();
        String strPer = edPer.getText().toString();
        String strPrice = edPrice.getText().toString();
        String batch = edBatch.getText().toString();


        int vol = Integer.parseInt(strVol);
        int per = Integer.parseInt(strPer);
        int price = Integer.parseInt(strPrice);

        Liquar liquar = new Liquar(id,name,brand,type,vol,per,price,batch);

        int result = dbHelper.updateLiquar(liquar);
        
        if(result > 0){
            Toast.makeText(this, "Liquar Updated", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Something went Wrong", Toast.LENGTH_SHORT).show();
        }




    }
}
