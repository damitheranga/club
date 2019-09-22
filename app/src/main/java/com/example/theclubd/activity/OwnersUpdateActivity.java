package com.example.theclubd.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.theclubd.R;
import com.example.theclubd.database.DBHelper;
import com.example.theclubd.model.Owner;

public class OwnersUpdateActivity extends AppCompatActivity {

    EditText edOwnerName, edEmail, edNIC, edShopName, edRegisterNo, edContactNO, edAddress;
    DBHelper dbHelper;

    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owners_update);
        getSupportActionBar().hide();

        dbHelper = new DBHelper(this);

        edOwnerName = findViewById(R.id.edOwnerName);
        edEmail = findViewById(R.id.edEmail);
        edNIC = findViewById(R.id.edNIC);
        edShopName = findViewById(R.id.edShopName);
        edRegisterNo = findViewById(R.id.edRegisterNo);
        edContactNO = findViewById(R.id.edContactNO);
        edAddress = findViewById(R.id.edAddress);


        Owner owner = (Owner) getIntent().getExtras().getSerializable("OWNER");

        id = owner.getId();
        edOwnerName.setText(owner.getOwnerName());
        edEmail.setText(owner.getEmail());
        edNIC.setText(owner.getNIC());
        edShopName.setText(owner.getShopName());
        edRegisterNo.setText(owner.getRegisterNo());
        edContactNO.setText(owner.getContactNo());
        edAddress.setText(owner.getAddress());
    }


    public void Updated(View view) {
        String OwnerName = edOwnerName.getText().toString();
        String email = edEmail.getText().toString();
        String NIC = edNIC.getText().toString();
        String ShopName = edShopName.getText().toString();
        String RegisterNo = edRegisterNo.getText().toString();
        String ContactNo = edContactNO.getText().toString();
        String Address = edAddress.getText().toString();

        Owner owner = new Owner(id, OwnerName, email, NIC, ShopName, RegisterNo, ContactNo,Address);
        int result = dbHelper.updateOwner(owner);

        if(result > 0){
            startActivity(new Intent(OwnersUpdateActivity.this, OwnersListActivity.class));
            Toast.makeText(this,"Details Update Successful", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"Update Fail", Toast.LENGTH_SHORT).show();
        }
    }
}