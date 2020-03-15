package com.example.software4;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Home extends AppCompatActivity  {
   Button b9,b10,b11,b12;
    String name,sw;
    SQLiteDatabase db5;
    String[] books1=new String[100];
    ArrayList<String> list1 = new ArrayList<>();
    Cursor c;
    int cou=0,z;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Bundle b = getIntent().getExtras();
         name = b.getString("name");
        db5 = openOrCreateDatabase("booksDB.db", Context.MODE_PRIVATE, null);
        db5.execSQL("CREATE TABLE IF NOT EXISTS books(id text,name text,available text,issuedate text);");
        c=db5.rawQuery("SELECT * FROM books ",null);
        //z=0;
        while(c.moveToNext()){
            sw=c.getString(1);

            if(!list1.contains(sw)){
                list1.add(sw);
            }

        }
        //String pwd = b.getString("pwd");
        b9=(Button)findViewById(R.id.search);
        b10=(Button)findViewById(R.id.return1);
        b11=(Button)findViewById(R.id.logout);

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = name;
                Intent i3=new Intent(Home.this,search.class);
                i3.putExtra("uname",name);
                //i3.putExtra("bo1",list1);
                startActivity(i3);
            }
        });

        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "select the book to be returned", Toast.LENGTH_LONG).show();
                Intent i4=new Intent(Home.this,cart.class);
                i4.putExtra("name",name);
                startActivity(i4);
            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i5=new Intent(Home.this,MainActivity.class);
                startActivity(i5);
            }
        });

    }

}
