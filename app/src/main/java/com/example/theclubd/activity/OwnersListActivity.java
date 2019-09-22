package com.example.theclubd.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.theclubd.R;
import com.example.theclubd.database.DBHelper;
import com.example.theclubd.model.Owner;

import java.util.List;

public class OwnersListActivity extends AppCompatActivity {
    ListView lvOwner;
    List<Owner> list;
    ArrayAdapter<Owner> arrayAdapter;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owners_list);

        lvOwner = findViewById(R.id.lvOwners);
        dbHelper = new DBHelper(this);
        getSupportActionBar().hide();



        lvOwner.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Owner owner = list.get(position);
                Intent intent = new Intent(OwnersListActivity.this, OwnersUpdateActivity.class);
                intent.putExtra("OWNER", owner);
                startActivity(intent);
            }
        });
        lvOwner.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                AlertDialog.Builder builder = new AlertDialog.Builder(OwnersListActivity.this);
                builder.setMessage("Are you sure to delete this");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        Owner owner = list.get(position);
                        int oid = owner.getId();

                        int result = dbHelper.deleteOwner(oid);

                        if(result > 0)
                        {
                            Toast.makeText(OwnersListActivity.this, "Delete Successful",Toast.LENGTH_SHORT).show();
                            list.remove(owner);
                            arrayAdapter.notifyDataSetChanged();
                        }
                        else{
                            Toast.makeText(OwnersListActivity.this,"Delete Fail",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("No",null);
                builder.show();

                return true;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        list = dbHelper.getALLOwner();
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        lvOwner.setAdapter(arrayAdapter);
    }
}