package com.example.software4;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    RelativeLayout rellay1,rellay2;
    TextView textView;
    Handler handler=new Handler();
    SQLiteDatabase dtb;
    Button b1,b2,b3,b4;
    EditText e1,e2;
    String un,pw,s1="manish1616j";
     Cursor c;
     DatabaseHelper myDb;
    Runnable runnable=new Runnable(){
        public void run(){
            rellay1.setVisibility(View.VISIBLE);
            rellay2.setVisibility(View.VISIBLE);
            textView.setVisibility(View.VISIBLE);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb=new DatabaseHelper(this);
        //Firebase.setAndroidContext(this);
        rellay1=(RelativeLayout) findViewById(R.id.rellay1);
        rellay2=(RelativeLayout) findViewById(R.id.rellay2);
        textView = findViewById(R.id.logo_name);

        handler.postDelayed(runnable,2000);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        e1=(EditText)findViewById(R.id.et1);
        e2=(EditText)findViewById(R.id.et2);
        dtb=openOrCreateDatabase("loginInfo", Context.MODE_PRIVATE,null);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
    }
    public void onClick(View view) {
        if (view.getId() == R.id.b1) {
            un = e1.getText().toString();
            pw = e2.getText().toString();
            c = dtb.rawQuery("SELECT * FROM reg WHERE username=\'" + un + "\' and password=\'" + pw + "\'", null);
            boolean l1,l2;
            l1=un.equals("manish1616j");
            l2=pw.equals("manishmanish");
            if(l1 && l2) {
                Intent in=new Intent(MainActivity.this,admin.class);
                in.putExtra("uname",s1);
                startActivity(in);
            }

//                String.format("My Company name is %s %s", name,sjshaj);
           else if (c.moveToFirst()) {
                Intent i1=new Intent(MainActivity.this,Home.class);
                i1.putExtra("name",un);
                //i1.putExtra("pwd",pw);
                startActivity(i1);
                //Toast.makeText(getApplicationContext(), "success" + " " , Toast.LENGTH_LONG).show();
                //Toast.makeText(this,"Button 1 Clicked", Toast.LENGTH_LONG).show();

            }
           else{
                Toast.makeText(this,"invalid details", Toast.LENGTH_LONG).show();
            }
        }
        else if (view.getId() == R.id.b2) {
                Intent i = new Intent(MainActivity.this, register.class);
                startActivity(i);
            } else if (view.getId() == R.id.b3) {
                Intent intent = new Intent(MainActivity.this, forgot1.class);
                startActivity(intent);

            }

        }


    }


