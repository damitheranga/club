package com.example.theclubd.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.theclubd.R;
import com.example.theclubd.database.DBHelper;
import com.example.theclubd.model.Owner;

public class AddOwnerActivity extends AppCompatActivity {

    EditText edOwnerName, edEmail, edNIC, edShopName, edRegisterNo, edContactNO, edAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_owner);
        getSupportActionBar().hide();

        edOwnerName = findViewById(R.id.edOwnerName);
        edEmail = findViewById(R.id.edEmail);
        edNIC = findViewById(R.id.edNIC);
        edShopName = findViewById(R.id.edShopName);
        edRegisterNo = findViewById(R.id.edRegisterNo);
        edContactNO = findViewById(R.id.edContactNO);
        edAddress = findViewById(R.id.edAddress);
    }

    public void process(View view) {
        switch (view.getId())
        {
            case R.id.btnsave:
                String OwnerName = edOwnerName.getText().toString();
                if(TextUtils.isEmpty(OwnerName)){
                    edOwnerName.setError(" Please provide name ");
                    return;
                }
                String email = edEmail.getText().toString();
                if(TextUtils.isEmpty(email)){
                    edEmail.setError(" Please provide email ");
                    return;
                }
                String NIC = edNIC.getText().toString();
                if(TextUtils.isEmpty(NIC)){
                    edNIC.setError(" Please provide NIC ");
                    return;
                }
                String ShopName = edShopName.getText().toString();
                if(TextUtils.isEmpty(ShopName)){
                    edShopName.setError(" Please provide name ");
                    return;
                }
                String RegisterNo = edRegisterNo.getText().toString();
                if(TextUtils.isEmpty(RegisterNo)){
                    edRegisterNo.setError(" Please provide RegisterNo ");
                    return;
                }
                String ContactNo = edContactNO.getText().toString();
                if(TextUtils.isEmpty(ContactNo)){
                    edContactNO.setError(" Please provide ContactNo ");
                    return;
                }
                String Address = edAddress.getText().toString();
                if(TextUtils.isEmpty(Address)){
                    edAddress.setError(" Please provide Address ");
                    return;
                }



                DBHelper dbHelper = new DBHelper(this);

                Owner owner =new Owner(OwnerName, email, NIC, ShopName, RegisterNo, ContactNo, Address);

                long result = dbHelper.addOwner(owner);
                if(result != -1){
                    startActivity(new Intent(AddOwnerActivity.this, OwnersListActivity.class));
                    Toast.makeText(this,"Details Added Successful",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(this,"Added Fail",Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.btnview:
                startActivity(new Intent(AddOwnerActivity.this, OwnersListActivity.class));
                break;
        }
    }
}
