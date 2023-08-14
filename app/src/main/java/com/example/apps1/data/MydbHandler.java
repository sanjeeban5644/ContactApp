package com.example.apps1.data;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.apps1.model.Contact;
import com.example.apps1.params.Parameters;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class MydbHandler extends SQLiteOpenHelper {
    public MydbHandler(Context context) {
        super(context, Parameters.DB_NAME, null, Parameters.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        String create = "CREATE TABLE" +Parameters.TABLE_NAME+ " ( "+
//                Parameters.KEY_ID"+ INTEGER + "PRIMARY KEY"+
//                Parameters.KEY_NAME+" TEXT"+
//                Parameters.KEY_NUMBER+" TEXT"+
//                " )";

//        String create = "CREATE TABLE"+Parameters.TABLE_NAME+"("+
//                Parameters.KEY_ID+" INTEGER PRIMARY KEY"+
//                Parameters.KEY_NAME+" TEXT"+
//                Parameters.KEY_NUMBER+" TEXT );";

        String create = "CREATE TABLE " + Parameters.TABLE_NAME + "(" +
                Parameters.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Parameters.KEY_NAME + " TEXT, " +
                Parameters.KEY_NUMBER + " TEXT);";

        //Log.d("hello", "this is my app"+create);
        db.execSQL(create);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Parameters.KEY_NAME,contact.getName());
        values.put(Parameters.KEY_NUMBER,contact.getNumber());

        db.insert(Parameters.TABLE_NAME,null,values);
        //Log.d("hello","successfully inserted data in db");
        db.close();
    }


    public List<Contact> getAllTableData(){
        List<Contact> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String select = " SELECT * FROM "+Parameters.TABLE_NAME;
        Cursor cursor = db.rawQuery(select,null);

        if(cursor.moveToFirst()){
            do{
                Contact contact = new Contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setNumber(cursor.getString(2));
                list.add(contact);
            }while(cursor.moveToNext());
        }
        return list;
    }


    public int updateTable(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Parameters.KEY_NAME,contact.getName());
        values.put(Parameters.KEY_NUMBER,contact.getNumber());

        return db.update(Parameters.TABLE_NAME,values,Parameters.KEY_ID+ "=?",
                new String[]{String.valueOf(contact.getId())});
    }

    public void deleteTable(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Parameters.TABLE_NAME,Parameters.KEY_ID+"=?",new String[]{String.valueOf(id)});
        db.close();
    }

    public int getCount(){
        String query = "SELECT * FROM "+Parameters.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        return cursor.getCount();
    }



}
