package com.example.software4;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class forgot1 extends AppCompatActivity {
    EditText e;
    String s;
    SQLiteDatabase db5,dtb1,dt;
    Cursor c1,c2;
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot1);
        dtb1 = openOrCreateDatabase("loginInfo", Context.MODE_PRIVATE, null);
        dtb1.execSQL("CREATE TABLE IF NOT EXISTS reg(name text,rollno text,mobile text,username text,password text,b1id text,b2id text,b3id text);");
         e=(EditText)findViewById(R.id.un1);
        Button b=(Button)findViewById(R.id.gen1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=e.getText().toString();
                c1 = dtb1.rawQuery("SELECT * FROM reg WHERE username='" + s + "'", null);

                if(c1.moveToFirst()){
                    //c2 = dtb1.rawQuery("SELECT * FROM reg WHERE username='" + s + "'", null);
                    String s=c1.getString(2);
                    Log.d("manish",s);
                    Intent intent=new Intent(getApplicationContext(),forgot2.class);
                    PendingIntent pi= PendingIntent.getActivity(getApplicationContext(), 0, intent,0);
//Get the SmsManager instance and call the sendTextMessage method to send message
                    SmsManager sms=SmsManager.getDefault();
                    sms.sendTextMessage(s, null, "4488", pi,null);
                    Toast.makeText(getApplicationContext(), "Message Sent successfully!",
                            Toast.LENGTH_LONG).show();



                    /*SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(s, null, "Test message", null, null);
                    sendSMS(s ,"5567");*/

                    intent.putExtra("uname",s);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"username doen't exist",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void sendSMS(String phoneNumber, String message)
    {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, null, null);
    }
}
