package com.example.theclubd.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.theclubd.R;
import com.example.theclubd.database.DBHelper;
import com.example.theclubd.model.modelBite;

import java.util.List;

public class biteListActivity extends AppCompatActivity {

    ListView lvBite;
    List<modelBite> List;
    ArrayAdapter<modelBite> arrayAdapter;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bite_list);
        getSupportActionBar().hide();

        lvBite = findViewById(R.id.listbite);
        dbHelper = new DBHelper(this);



        lvBite.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                modelBite bite = List.get(position);

                Intent intent = new Intent(biteListActivity.this,updateBiteActivity.class);
                intent.putExtra("modelBite",bite);
                startActivity(intent);
            }
        });

        lvBite.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                AlertDialog.Builder builder = new AlertDialog.Builder(biteListActivity.this);
                builder.setMessage("Are you sure to delete ? ");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        modelBite bite = List.get(position);

                        int bid = bite.getId();

                        int result = dbHelper.deleteBite(bid);

                        if(result > 0)
                        {
                            Toast.makeText(biteListActivity.this, "CLICKED COCKTAIL DELETED", Toast.LENGTH_SHORT).show();
                            List.remove(bite);
                            arrayAdapter.notifyDataSetChanged();
                        }
                        else
                        {
                            Toast.makeText(biteListActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
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
        List = dbHelper.getAllBites();
        arrayAdapter = new ArrayAdapter<modelBite>(this, android.R.layout.simple_list_item_1, List);
        lvBite.setAdapter(arrayAdapter);
    }
}
