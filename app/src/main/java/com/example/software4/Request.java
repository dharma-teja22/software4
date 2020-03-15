package com.example.software4;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Request extends AppCompatActivity {
    TextView t1;
    SQLiteDatabase db5,dtb1,dt;
    Cursor c,c1;
    String name,av,id,bav,bname;
    Button b11,b12,b13,b14;
    int k;
    boolean check ;
    String formattedDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        Bundle b = getIntent().getExtras();
         bname=b.getString("bname");
        name = b.getString("usname");
        t1=(TextView)findViewById(R.id.avl);
        b11=(Button)findViewById(R.id.tb);
        b12=(Button)findViewById(R.id.gh);
        b13=(Button)findViewById(R.id.gc);
        b14=(Button)findViewById(R.id.cc);
        Date cc = Calendar.getInstance().getTime();
        Calendar cal = Calendar.getInstance();
        cal.setTime(cc);
        cal.add(Calendar.DATE,15);
        cc = cal.getTime();

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
         formattedDate = df.format(cc);

        db5=openOrCreateDatabase("booksDB.db", Context.MODE_PRIVATE,null);
        db5.execSQL("CREATE TABLE IF NOT EXISTS books(id text,name text,available text,issueDate text);");
        dtb1 = openOrCreateDatabase("loginInfo", Context.MODE_PRIVATE, null);
        dtb1.execSQL("CREATE TABLE IF NOT EXISTS reg(name text,rollno text,mobile text,username text,password text,b1id text,b2id text,b3id text);");
        dt=openOrCreateDatabase("cartdb", Context.MODE_PRIVATE,null);
        dt.execSQL("CREATE TABLE IF NOT EXISTS cartDB(user text,bookname text,returnDate text);");
        //c=db3.rawQuery("SELECT * FROM books where name='"+t1.getText().toString()+"'",null);
        //String s=t1.getText().toString();
        c=db5.rawQuery("SELECT * FROM books WHERE name='" + bname + "'",null);
        //check=false;
        while(c.moveToNext()){
            check=true;
            av=c.getString(2);
            if(av.equals("1")){
                id=c.getString(0);
                String test = "The book : "+ bname +
                        " is available ";
                t1.setText(test);
                check=false;
                break;
            }


        }
        if(check){
            Intent i6=new Intent(Request.this,Home.class);
            Toast.makeText(getApplicationContext(), "the book isn't available", Toast.LENGTH_LONG).show();
            i6.putExtra("name",name);
            startActivity(i6);
        }
        /*if(c.moveToFirst()) {
            String test = "the book  "+ bname +
                    " is available ";
            t1.setText(test);
        }
        else{
            /*String test = "the book  "+ bname +
                    " is not available ";
            t1.setText(test);*/
            //Toast.makeText(getApplicationContext(), "the book isn't available", Toast.LENGTH_LONG).show();
            //Intent i6=new Intent(Request.this,Home.class);
            //startActivity(i6);*/

        //}
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "hii"+name+"", Toast.LENGTH_LONG).show();
               // Log.d("manish","hello ");
                 c1 = dtb1.rawQuery("SELECT * FROM reg WHERE username='" + name + "'", null);
                if(c1.moveToFirst()){
                boolean flag1=true;
                for(int i=0;i<3;i++){
                    k=i+5;
                     bav=c1.getString(k);
                   //  Log.d("manish",bav+" ");
                    if(bav.equals("1000")){
                        if(k==5) {

                            String yt = id;
                            dtb1.execSQL("UPDATE reg SET b1id='" + id + "' WHERE username='" + name + "'");
                            db5.execSQL("UPDATE books SET available='" + 0 + "' WHERE id='" + id + "'");
                            db5.execSQL("UPDATE books SET issueDate='" + "12-03-2020" + "' WHERE id='" + id + "'");
                            flag1 = false;
                            Cursor c = db5.rawQuery("SELECT * FROM books WHERE id='" + id + "'", null);
                            String po = "error";
                            if (c.moveToFirst()) {
                                // Displaying record if found 
                                po = c.getString(3);
                            }


                           // Toast.makeText(getApplicationContext(), po, Toast.LENGTH_LONG).show();
                            dt.execSQL("INSERT INTO cartDB VALUES('" + name + "','" + bname +
                                    "','" + "12-03-2020" + "');");
                            AlertDialog.Builder alertDialog = new AlertDialog.Builder(Request.this);
                            // Setting Dialog Title
//                            alertDialog.setTitle("RENT DETAILS");
                            // Setting Dialog Message
                            alertDialog.setMessage(" Book name : " + bname + "\n Retrn Date : " + formattedDate + "\n Fine Details : 2 Rs/day from return date");
                            // Setting Icon to Dialog
//                            alertDialog.setIcon(R.drawable.ic_launcher_background);
                            // Setting Positive "Yes" Button
                            alertDialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(getApplicationContext(), "Thank You", Toast.LENGTH_SHORT).show();
                                }
                            });

                            // Setting Negative "NO" Button
                            alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // Write your code here to invoke NO event
                                    Toast.makeText(getApplicationContext(), "You clicked on NO :   " + which, Toast.LENGTH_SHORT).show();
                                    // dialog.cancel();
                                }
                            });
                            // Setting Netural "Cancel" Button
                            alertDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // User pressed Cancel button. Write Logic Here
                                    Toast.makeText(getApplicationContext(), "You clicked on Cancel :   " + which,
                                            Toast.LENGTH_SHORT).show();
                                }
                            });
                            AlertDialog ad = alertDialog.create();
                            ad.setTitle("RENT DETAILS");
                            // Showing Alert Message
                            ad.show();


                            /*Intent i9=new Intent(Request.this,cart.class);
                            i9.putExtra("bname",bname);
                            i9.putExtra("name",name);
                            i9.putExtra("fdate",formattedDate);
                            startActivity(i9);*/
                            //Toast.makeText(getApplicationContext(), "hii"+name+"", Toast.LENGTH_LONG).show();
                        }
                        else if(k==6){
                            String yt = id;
                            dtb1.execSQL("UPDATE reg SET b2id='" + id + "' WHERE username='" + name + "'");
                            db5.execSQL("UPDATE books SET available='" + 0 + "' WHERE id='" + id + "'");
                            db5.execSQL("UPDATE books SET issueDate='" + formattedDate + "' WHERE id='" + id + "'");
                            flag1 = false;
                            Cursor c = db5.rawQuery("SELECT * FROM books WHERE id='" + id + "'", null);
                            String po = "error";
                            if (c.moveToFirst()) {
                                // Displaying record if found 
                                po = c.getString(3);
                            }


                           // Toast.makeText(getApplicationContext(), po, Toast.LENGTH_LONG).show();
                            dt.execSQL("INSERT INTO cartDB VALUES('" + name + "','" + bname +
                                    "','" + formattedDate + "');");
                            AlertDialog.Builder alertDialog = new AlertDialog.Builder(Request.this);
                            // Setting Dialog Title
//                            alertDialog.setTitle("RENT DETAILS");
                            // Setting Dialog Message
                            alertDialog.setMessage(" Book name : " + bname + "\n Retrn Date : " + formattedDate + "\n Fine Details : 2 Rs/day from return date");
                            // Setting Icon to Dialog
//                            alertDialog.setIcon(R.drawable.ic_launcher_background);
                            // Setting Positive "Yes" Button
                            alertDialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(getApplicationContext(), "Thank You", Toast.LENGTH_SHORT).show();
                                }
                            });

                            // Setting Negative "NO" Button
                            alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // Write your code here to invoke NO event
                                    Toast.makeText(getApplicationContext(), "You clicked on NO :   " + which, Toast.LENGTH_SHORT).show();
                                    // dialog.cancel();
                                }
                            });
                            // Setting Netural "Cancel" Button
                            alertDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // User pressed Cancel button. Write Logic Here
                                    Toast.makeText(getApplicationContext(), "You clicked on Cancel :   " + which,
                                            Toast.LENGTH_SHORT).show();
                                }
                            });
                            AlertDialog ad = alertDialog.create();
                            ad.setTitle("RENT DETAILS");
                            // Showing Alert Message
                            ad.show();
                        }
                        else if(k==7){
                            String yt = id;
                            dtb1.execSQL("UPDATE reg SET b3id='" + id + "' WHERE username='" + name + "'");
                            db5.execSQL("UPDATE books SET available='" + 0 + "' WHERE id='" + id + "'");
                            db5.execSQL("UPDATE books SET issueDate='" + formattedDate + "' WHERE id='" + id + "'");
                            flag1 = false;
                            Cursor c = db5.rawQuery("SELECT * FROM books WHERE id='" + id + "'", null);
                            String po = "error";
                            if (c.moveToFirst()) {
                                // Displaying record if found 
                                po = c.getString(3);
                            }


                           // Toast.makeText(getApplicationContext(), po, Toast.LENGTH_LONG).show();
                            dt.execSQL("INSERT INTO cartDB VALUES('" + name + "','" + bname +
                                    "','" + "12-03-2020" + "');");
                            AlertDialog.Builder alertDialog = new AlertDialog.Builder(Request.this);
                            // Setting Dialog Title
//                            alertDialog.setTitle("RENT DETAILS");
                            // Setting Dialog Message
                            alertDialog.setMessage(" Book name : " + bname + "\n Retrn Date : " + formattedDate + "\n Fine Details : 2 Rs/day from return date");
                            // Setting Icon to Dialog
//                            alertDialog.setIcon(R.drawable.ic_launcher_background);
                            // Setting Positive "Yes" Button
                            alertDialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(getApplicationContext(), "Thank You", Toast.LENGTH_SHORT).show();
                                }
                            });

                            // Setting Negative "NO" Button
                            alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // Write your code here to invoke NO event
                                    Toast.makeText(getApplicationContext(), "You clicked on NO :   " + which, Toast.LENGTH_SHORT).show();
                                    // dialog.cancel();
                                }
                            });
                            // Setting Netural "Cancel" Button
                            alertDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // User pressed Cancel button. Write Logic Here
                                    Toast.makeText(getApplicationContext(), "You clicked on Cancel :   " + which,
                                            Toast.LENGTH_SHORT).show();
                                }
                            });
                            AlertDialog ad = alertDialog.create();
                            ad.setTitle("RENT DETAILS");
                            // Showing Alert Message
                            ad.show();
                        }

                        break;
                    }
                }
                if(flag1){
                    Toast.makeText(getApplicationContext(), "your cart is full(max 3 books)", Toast.LENGTH_LONG).show();
                }}

            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.equals("manish1616j")){
                    Intent i10=new Intent(Request.this,admin.class);
                    i10.putExtra("uname",name);
                    startActivity(i10);
                }
                else{
                Intent i7=new Intent(Request.this,Home.class);
                i7.putExtra("name",name);
                startActivity(i7);}
            }
        });
   b13.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i9=new Intent(Request.this,cart.class);
        //i9.putExtra("bname",bname);
        i9.putExtra("name",name);
        //i9.putExtra("fdate",formattedDate);
        startActivity(i9);
    }
});
   b14.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           Intent i=new Intent(Request.this,search.class);
           i.putExtra("uname",name);
           startActivity(i);
       }
   });

    }



}
