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
import com.example.theclubd.model.Liquar;

import java.util.List;

public class LiquarListActivity extends AppCompatActivity {


    ListView lvLiqures;
    List<Liquar> list;
    ArrayAdapter<Liquar > arrayAdapter;
    DBHelper dbHelper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liquar_list);
         lvLiqures = findViewById(R.id.lvliquar);

        getSupportActionBar().hide();
         dbHelper = new DBHelper(this);


         lvLiqures.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Liquar liquar = list.get(i);
                Intent intent = new Intent(LiquarListActivity.this,LiquarUpdateActivity.class);
                intent.putExtra("LIQUAR",liquar);
                startActivity(intent);



             }
         });

         lvLiqures.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
             @Override
             public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                 AlertDialog.Builder builder = new AlertDialog.Builder(LiquarListActivity.this);
                 builder.setMessage("Are You Sure To Delte ?");
                 builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialogInterface, int i) {

                     }
                 });

                 builder.setNegativeButton("No",null);
                 builder.show();


                 Liquar liquar = list.get(i);
                 int lid = liquar.getId();
                 int result = dbHelper.deleteStudent(lid);

                 if(result > 0 ){
                     Toast.makeText( LiquarListActivity.this, "Liquar Deleted Succesfilly", Toast.LENGTH_SHORT).show();
                     list.remove(liquar);
                     arrayAdapter.notifyDataSetChanged();
                 }
                 else{
                     Toast.makeText(LiquarListActivity.this, "Somrthing Went Wrong", Toast.LENGTH_SHORT).show();
                 }


                 return true;
             }
         });






    }

    @Override
    protected void onStart() {
        super.onStart();
        list = dbHelper.getAllStudent();
        arrayAdapter = new ArrayAdapter<Liquar>(this,android.R.layout.simple_list_item_1,list);
        lvLiqures.setAdapter(arrayAdapter);
    }
}
