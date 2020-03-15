package com.example.software4;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class addbooks extends AppCompatActivity {
Button b1;
EditText e1,e2;
boolean x1,x2;
int n1,n2,k,i,j,l;
SQLiteDatabase db5;
String name;
Cursor c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbooks);
        Bundle b = getIntent().getExtras();
        name = b.getString("uname");
        b1=(Button)findViewById(R.id.b1);
        e1=(EditText)findViewById(R.id.et1);
        e2=(EditText)findViewById(R.id.et2);
        db5 = openOrCreateDatabase("booksDB.db", Context.MODE_PRIVATE, null);
        db5.execSQL("CREATE TABLE IF NOT EXISTS books(id text,name text,available text,issuedate text);");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=e1.getText().toString();
                String s1=e2.getText().toString();
                n1=s.length();
                n2=Integer.parseInt(s1);
                if(x1=ch1(n1)){
                    if(x2=ch2(n2)){
                      c=db5.rawQuery("SELECT * FROM books",null);
                      k=c.getCount();
                      l=k+n2;
                      i=k-1;
                      for(j=i;j<l;j++){
                          db5.execSQL("INSERT INTO books VALUES('" + j + "','" + s +
                                  "','" + 1 + "','" + "null" + "');");
                      }
                        Toast.makeText(getApplicationContext(),"Successfully uploaded!"+k,Toast.LENGTH_LONG).show();
                      Intent i=new Intent(addbooks.this,admin.class);
                        i.putExtra("uname",name);
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"maximum limit : 8 copies and minimum:1 copy",Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),"minimum charecters of book name: 4",Toast.LENGTH_LONG).show();
                }


            }
        });

    }
    public boolean ch1(int a){
        if(a>=4){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean ch2(int a){
        if(a<=8 && a>=1){
            return true;
        }
        else{
            return false;
        }
    }


}
