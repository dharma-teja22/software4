package com.example.software4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Return extends AppCompatActivity {
    SQLiteDatabase db5,dtb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return);
        Toast.makeText(getApplicationContext(),"select the book to be returned",Toast.LENGTH_LONG).show();
        db5=openOrCreateDatabase("booksDB.db", Context.MODE_PRIVATE,null);
        db5.execSQL("CREATE TABLE IF NOT EXISTS books(id text,name text,available text,issueDate text);");
        dtb1 = openOrCreateDatabase("loginInfo", Context.MODE_PRIVATE, null);
        dtb1.execSQL("CREATE TABLE IF NOT EXISTS reg(name text,rollno text,mobile text,username text,password text,b1id text,b2id text,b3id text);");

    }
}
