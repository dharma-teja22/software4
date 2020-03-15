package com.example.software4;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="user.db";
    public static final String TABLE_NAME="books_table";
    public static final String COL1="id";
    public static final String COL2="name";
    public static final String COL3="available";
    public static final String COL4="issueDate";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME VARCHAR,AVAILABLE INTEGER,USERNAME VARCHAR,issuedate VARCHAR)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String name,String rollno,String mobile,String username,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL1,name);
        contentValues.put(COL2,rollno);
        contentValues.put(COL3,mobile);
        contentValues.put(COL4,username);
        //contentValues.put(COL5,password);
        long result=db.insert(TABLE_NAME,null,contentValues);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }
}
