package com.example.software4;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class register extends AppCompatActivity {
    String name, roll, mobil, usernam, passw, name1 = "manish", roll2 = "CB.EN.U4CSE17110", mobil1 = "8074190234", usernam1 = "mani123", passw1 = "1234567";
    EditText et1, et2, et3, et4, et5, et6;
    int count = 0, count1;
    Button reg;
    String substr;
    SQLiteDatabase dtb1;
    String regexStr = "^[0-9]$";
    Cursor c, c1;
    int l1, l2, l3, l4, l5, l6;
    boolean x1,x2,x3,x4,x5,x6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        et1 = (EditText) findViewById(R.id.name);
        et2 = (EditText) findViewById(R.id.rollno);
        et3 = (EditText) findViewById(R.id.mobileno);
        et4 = (EditText) findViewById(R.id.username);
        et5 = (EditText) findViewById(R.id.password);
        reg = (Button) findViewById(R.id.register);


        // roll=et2.getText().toString();


        final String[] roll1 = {
                "CB.EN.U4CSE", "CB.EN.U4ESE", "CB.EN.U4MEC", "CB.EN.U4CHE", "CB.EN.U4EEE", "CB.EN.U4CIV", "CB.EN.U4EIE"
        };

        dtb1 = openOrCreateDatabase("loginInfo", Context.MODE_PRIVATE, null);
        dtb1.execSQL("CREATE TABLE IF NOT EXISTS reg(name text,rollno text,mobile text,username text,password text,b1id text,b2id text,b3id text);");
        //Toast.makeText(getApplicationContext(),"enter roll number in valid format",Toast.LENGTH_LONG).show();
        //dtb1.execSQL("INSERT INTO reg VALUES('" + name1 + "','" + roll2 +
        //"','" + mobil1 + "','" + usernam1 + "','" + passw1 + "','" + 0 + "','" + 0 + "','" + 0 + "');");
        dtb1.execSQL("INSERT INTO reg VALUES('" + name1 + "','" + roll2 +
                "','" + mobil1 + "','" + usernam1 + "','" + passw1 + "','" + "1000" + "','" + "1000" + "','" + "1000" + "')");
        //Toast.makeText(getApplicationContext(), "enter roll number in valid format", Toast.LENGTH_LONG).show();
       reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=et1.getText().toString();
                l1=name.length();
                roll=et2.getText().toString();
                l2=roll.length();
                mobil=et3.getText().toString();
                l3=mobil.length();
                usernam=et4.getText().toString();
                l4=usernam.length();
                passw=et5.getText().toString();
                l5=passw.length();
                //Toast.makeText(getApplicationContext(),name,Toast.LENGTH_LONG).show();
               if((x1=check1(l1)) && (x2=check2(l2)) && (x3=check3(l3)) && (x4=check4(l4)) && (x5=check5(l5  )))
                {
                    //
                    substr=roll.substring(0,11);
                    //Toast.makeText(getApplicationContext(),"SUBSTRING"+substr+" ",Toast.LENGTH_LONG).show();
                    Log.d("Manish",substr);
                    count1=count;
                    for(int i=0;i<7;i++){
                        if(substr.equals(roll1[i])){
                            count++;
                        }
                    }
                    if(count==count1){
                        Toast.makeText(getApplicationContext(),"enter roll number in valid format",Toast.LENGTH_LONG).show();

                    }

                    //Toast.makeText(getApplicationContext(),"Username already exists",Toast.LENGTH_LONG).show();
                    else if(count>count1){c=dtb1.rawQuery("SELECT * FROM reg WHERE username='" + usernam + "'",null);
//                String.format("My Company name is %s %s", name,sjshaj);
                    if(c.moveToFirst()){
                        Toast.makeText(getApplicationContext(),"Username already exists" ,Toast.LENGTH_LONG).show();
                    }
                   /* else if(!c.moveToFirst()){
                        c1=dtb1.rawQuery("SELECT * FROM reg WHERE rollno='" + roll + "'",null);
                        if(c1.moveToFirst()){
                            Toast.makeText(getApplicationContext(),"Roll number already exists" ,Toast.LENGTH_LONG).show();
                        }
                    }*/
                    else{
                        dtb1.execSQL("INSERT INTO reg VALUES('" + name + "','" + roll +
                                "','" + mobil + "','" + usernam + "','" + passw + "','" + "1000" + "','" + "1000" + "','" + "1000" + "');");
                        Toast.makeText(getApplicationContext(),"record added",Toast.LENGTH_LONG).show();
                    }

                    }
                   // else {
                        //Toast.makeText(getApplicationContext(),"Evaru leru doripo",Toast.LENGTH_LONG).show();
                    //}
                    //Toast.makeText(getApplicationContext(),"enter the fields",Toast.LENGTH_LONG).show();



                }
                else{
                    Toast.makeText(getApplicationContext(),"enter all fields",Toast.LENGTH_LONG).show();
               }
            }
        });
        dtb1.execSQL("DELETE FROM reg WHERE rollno='" + roll1 + "'");

    }

    public boolean check1(int a){
        if(a!=0){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean check2(int a){
        if(a==16){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean check3(int a){
        if(a==10){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean check4(int a){
        if(a>=7){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean check5(int a){
       // int k2=a.length();
        //int c1=0,c2=0;
        if(a>=8 && a<=16){

            return true;
        }
        else{
            return false;
        }
    }



}