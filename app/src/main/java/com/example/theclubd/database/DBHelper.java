package com.example.theclubd.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.theclubd.model.Liquar;
import com.example.theclubd.model.Owner;

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


    //dulitha


    private static final String KEY_IDS = "id";
    private static final String KEY_OwnerName = "OwnerName";
    private static final String KEY_email= "email";
    private static final String KEY_NIC= "NIC";
    private static final String KEY_ShopName = "ShopName";
    private static final String KEY_RegisterNo = "RegisterNo";
    private static final String KEY_ContactNo = "ContactNo";
    private static final String KEY_Address = "Address";

    private static final String TABLE_LIQ = "tbl_liqure";
    //dulitha
    private static final String TABLE_OWNER = "tbl_owner";

    private static final String CREATE_TABLE_LIQ = "CREATE TABLE "+ TABLE_LIQ + "( "
            +KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            +KEY_NAME + " TEXT NOT NULL,"
            +KEY_BRAND + " TEXT NOT NULL,"
            +KEY_TYPE + " TEXT NOT NULL,"
            +KEY_VOL + " INTEGER NOT NULL,"
            +KEY_PER + " INTEGER NOT NULL,"
            +KEY_PRICE + " INTEGER NOT NULL,"
            +KEY_BATCH + " TEXT NOT NULL )" ;


    //dulitha

    private static final String CREATE_TABLE_OWNER = "CREATE TABLE " + TABLE_OWNER + "( " + KEY_IDS + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_OwnerName + " TEXT NOT NULL," + KEY_email + " TEXT NOT NULL," + KEY_NIC + " TEXT NOT NULL," + KEY_ShopName + " TEXT NOT NULL,"
            + KEY_RegisterNo + " TEXT NOT NULL," + KEY_ContactNo + " TEXT NOT NULL," + KEY_Address + " TEXT NOT NULL )";



    public DBHelper(Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_LIQ);
        //dulitha
        sqLiteDatabase.execSQL(CREATE_TABLE_OWNER);



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_LIQ);
        //dulitha
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_OWNER);
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
    //dulitha
    public long addOwner(Owner owner){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_OwnerName, owner.getOwnerName());
        values.put(KEY_email, owner.getEmail());
        values.put(KEY_NIC,owner.getNIC());
        values.put(KEY_ShopName, owner.getShopName());
        values.put(KEY_RegisterNo, owner.getRegisterNo());
        values.put(KEY_ContactNo,owner.getContactNo());
        values.put(KEY_Address,owner.getAddress());

        return db.insert(TABLE_OWNER,null,values);

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


    public List<Owner> getALLOwner() {
        List<Owner> ownerList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * from " + TABLE_OWNER, null);
        if(cursor.moveToFirst()){
            do {
                int id = cursor.getInt(0);
                String OwnerName = cursor.getString(1);
                String email = cursor.getString(2);
                String NIC = cursor.getString(3);
                String ShopName = cursor.getString(4);
                String RegisterNo = cursor.getString(5);
                String ContactNo =  cursor.getString(6);
                String Address = cursor.getString(7);

                Owner owner = new Owner(id, OwnerName, email, NIC, ShopName, RegisterNo, ContactNo, Address);
                ownerList.add(owner);
            }while(cursor.moveToNext());
        }

        return ownerList;
    }

    public int updateOwner(Owner owner) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_OwnerName, owner.getOwnerName());
        values.put(KEY_email, owner.getEmail());
        values.put(KEY_NIC, owner.getNIC());
        values.put(KEY_ShopName, owner.getShopName());
        values.put(KEY_RegisterNo, owner.getRegisterNo());
        values.put(KEY_ContactNo, owner.getContactNo());
        values.put(KEY_Address, owner.getAddress());


        return db.update(TABLE_OWNER, values, "id=?", new String[]{String.valueOf(owner.getId())});

    }

    public int deleteOwner(int oid) {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(TABLE_OWNER,"id=?", new String[]{String.valueOf(oid)});

    }
    public int deleteOwner1(int oid) {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(TABLE_OWNER,"id=?", new String[]{String.valueOf(oid)});

    }
}
