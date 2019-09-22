package com.example.theclubd.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.theclubd.model.Liquar;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "club.db";
    private static final int DATABASE_VERSION = 1;

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_TYPE = "type";
    private static final String KEY_BRAND = "brand";
    private static final String KEY_VOL = "vol";
    private static final String KEY_PER = "per";
    private static final String KEY_PRICE = "price";
    private static final String KEY_BATCH = "batch";


    private static final String TABLE_LIQ = "tbl_liqure";
    private static final String CREATE_TABLE_LIQ = "CREATE TABLE "+ TABLE_LIQ + "( "
            +KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            +KEY_NAME + " TEXT NOT NULL,"
            +KEY_BRAND + " TEXT NOT NULL,"
            +KEY_TYPE + " TEXT NOT NULL,"
            +KEY_VOL + " INTEGER NOT NULL,"
            +KEY_PER + " INTEGER NOT NULL,"
            +KEY_PRICE + " INTEGER NOT NULL,"
            +KEY_BATCH + " TEXT NOT NULL )" ;


    public DBHelper(Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_LIQ);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_LIQ);
        onCreate(sqLiteDatabase);
    }


    public boolean addLiq(Liquar liquar) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_NAME, liquar.getName());
        values.put(KEY_BRAND, liquar.getBrand());
        values.put(KEY_TYPE, liquar.getType());
        values.put(KEY_VOL, liquar.getVol());
        values.put(KEY_PER, liquar.getPer());
        values.put(KEY_PRICE, liquar.getPrice());
        values.put(KEY_BATCH, liquar.getBatch());

        long res =  sqLiteDatabase.insert(TABLE_LIQ,null, values);
        if(res == -1){
            return false;
        }
        else{
            return true;
        }

    }

    public List<Liquar> getAllStudent() {
        List<Liquar> liquarList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_LIQ,null );
        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String brand = cursor.getString(2);
                String type = cursor.getString(3);
                int vol = cursor.getInt(4);
                int per = cursor.getInt(5);
                int price = cursor.getInt(6);
                String batch = cursor.getString(7);

                Liquar liquar = new Liquar(id,name,brand,type,vol,per,price,batch);
                liquarList.add(liquar);



            }while(cursor.moveToNext());
        }
        return liquarList;

    }

    public int updateLiquar(Liquar liquar) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_NAME, liquar.getName());
        values.put(KEY_BRAND, liquar.getBrand());
        values.put(KEY_TYPE, liquar.getType());
        values.put(KEY_VOL, liquar.getVol());
        values.put(KEY_PER, liquar.getPer());
        values.put(KEY_PRICE, liquar.getPrice());
        values.put(KEY_BATCH, liquar.getBatch());

        return  sqLiteDatabase.update(TABLE_LIQ,values,"id=?",new String[]{String.valueOf(liquar.getId())});

    }

    public int deleteStudent(int lid) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.delete(TABLE_LIQ,"id=?",new String[]{String.valueOf(lid)});
    }
}
