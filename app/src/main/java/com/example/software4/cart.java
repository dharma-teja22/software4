package com.example.software4;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class cart extends AppCompatActivity /*implements View.OnClickListener*/{
    String bname,name,fdate,nDate,fDate1,nDate1;
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9;
    String bav,s1,s2,s3;
    Button b30,b31,b32,b5,b6;
    boolean x1,x2;
    String a,b10;
    Button b15;
    String fDate;
    SQLiteDatabase dtb1,db5,dt;
    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

    Cursor c1,st1,st2,st3,k1;
    int k;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        Bundle b = getIntent().getExtras();
        //bname=b.getString("bname");
        name=b.getString("name");
        //fdate=b.getString("fdate");
        Date cc = Calendar.getInstance().getTime();
        Calendar cal = Calendar.getInstance();
        cal.setTime(cc);
        cal.add(Calendar.DATE,0);
        cc.getTime();
        fDate = df.format(cc);
       // a = df.format(cc);
        //b10 = df.format(cc);
        //cal.add(Calendar.DATE,0);
        nDate = df.format(cc);
        nDate1=nDate.toString();
        t1=(TextView)findViewById(R.id.t1);
        t2=(TextView)findViewById(R.id.t2);
        t3=(TextView)findViewById(R.id.t3);
        t4=(TextView)findViewById(R.id.t4);
        t5=(TextView)findViewById(R.id.t5);
        t6=(TextView)findViewById(R.id.t6);
        t7=(TextView)findViewById(R.id.t7);
        t8=(TextView)findViewById(R.id.t8);
        t9=(TextView)findViewById(R.id.t9);
        b30=(Button)findViewById(R.id.br1);
        b31=(Button)findViewById(R.id.br2);
        b32=(Button)findViewById(R.id.br3);
        b5=(Button)findViewById(R.id.b5);
        b6=(Button)findViewById(R.id.b6);
        b30.setVisibility(View.GONE);
        b31.setVisibility(View.GONE);
        b32.setVisibility(View.GONE);

        dtb1 = openOrCreateDatabase("loginInfo", Context.MODE_PRIVATE, null);
        dtb1.execSQL("CREATE TABLE IF NOT EXISTS reg(name text,rollno text,mobile text,username text,password text,b1id text,b2id text,b3id text);");
        db5=openOrCreateDatabase("booksDB.db", Context.MODE_PRIVATE,null);
        db5.execSQL("CREATE TABLE IF NOT EXISTS books(id text,name text,available text,issueDate text);");
        //c1=dtb1.rawQuery("SELECT * FROM reg WHERE username=\'" + name + "\'",null);
        dt=openOrCreateDatabase("cartdb", Context.MODE_PRIVATE,null);
        dt.execSQL("CREATE TABLE IF NOT EXISTS cartDB(user text,bookname text,returnDate text);");
        c1=dtb1.rawQuery("SELECT * FROM reg WHERE username='" + name + "'", null);
        if(c1.moveToFirst()){
            boolean flag1=true;
            for(int k=5;k<8;k++){

                bav=c1.getString(k);
                boolean q=bav.equals("1000");
                if(!q){
                    st1=db5.rawQuery("SELECT * FROM books WHERE id='" + bav + "'", null);
                    if(st1.moveToFirst()){
                        s1=st1.getString(1);
                        s2=st1.getString(3);
                        if(k==5){
                            t1.setText("Name : "+s1);
                            t4.setText("ID : "+bav);
                            t7.setText("Return Date : "+s2);
                            b30.setVisibility(View.VISIBLE);
                        }
                        else if(k==6){
                            t2.setText("Name : "+s1);
                            t5.setText("ID : "+bav);
                            t8.setText("Return Date : "+s2);
                            b31.setVisibility(View.VISIBLE);
                        }
                        else if(k==7){
                            t3.setText("Name : "+s1);
                            t6.setText("ID : "+bav);
                            t9.setText("Return Date : "+s2);
                            b32.setVisibility(View.VISIBLE);
                        }
                    }
                    else{
                        Toast.makeText(this,"cart is empty", Toast.LENGTH_LONG).show();
                    }


                    }}}
        //b15=(Button)findViewById(R.id.show);
        //b15.setOnClickListener(this);

        /*b15=(Button)findViewById(R.id.bh);

        if(t1.getText().toString().trim().length()==0){
            t1.setText(bname);
        }
        else if(t2.getText().toString().trim().length()==0){
            t2.setText(bname);
        }
        else{
            t3.setText(bname);
        }
b15.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(cart.this,search.class);
        intent.putExtra("uname",name);
        startActivity(intent);
    }
});*/

        b30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //st1=db5.rawQuery("SELECT * FROM books WHERE name=\'" + t1.getText().toString() + "\'",null);
                //Toast.makeText(getApplicationContext(),nDate, Toast.LENGTH_LONG).show();
                //Toast.makeText(cart.this,"updated", Toast.LENGTH_LONG).show();
                String m=t4.getText().toString();
                //Log.d("manish",m);
                String lu=m.substring(5,m.length());
                db5.execSQL("UPDATE books SET available='" + 1 + "' WHERE id='" + lu + "'");
                dtb1.execSQL("UPDATE reg SET b1id='" + "1000" + "' WHERE username='" + name + "'");
                clearText(t1);
                clearText(t4);
                clearText(t7);
                b30.setVisibility(View.GONE);
               // Toast.makeText(cart.this,"Book Returned!", Toast.LENGTH_LONG).show();
//                Toast.makeText(cart.this,"Book Returned!", Toast.LENGTH_LONG).show();
                        //Toast.makeText(cart.this,"updated", Toast.LENGTH_LONG).show();

                Cursor c = db5.rawQuery("SELECT * FROM books WHERE id='" + lu + "'", null);
                String po="error";
                //Log.d("manish",c.moveToFirst()+"");
                if (c.moveToFirst()) {
                    // Displaying record if found 
                    fDate1 = c.getString(3 );
                    Log.d("manish",fDate1);
                }
                //Log.d("manish"," "+c);

                if(chkfine(nDate1,fDate1)) {
                    int fine=findAmount(nDate1,fDate1);
                    Log.d("manish",fine+" ");
                    Toast.makeText(cart.this,"fine to be paid :Rs."+fine+"", Toast.LENGTH_LONG).show();

                    }
                else{
                    Toast.makeText(cart.this,"Thank You for visiting Library(submitted on time!)", Toast.LENGTH_LONG).show();
                }
            }
        });


        b31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String n=t5.getText().toString();
                String lu=n.substring(5,n.length());
                db5.execSQL("UPDATE books SET available='" + 1 + "' WHERE id='" + lu + "'");
                dtb1.execSQL("UPDATE reg SET b2id='" + "1000" + "' WHERE username='" + name + "'");
                clearText(t2);
                clearText(t5);
                clearText(t8);
                b31.setVisibility(View.GONE);
              //  Toast.makeText(cart.this,"Book Returned!", Toast.LENGTH_LONG).show();
                k1=db5.rawQuery("SELECT * FROM books WHERE id='" + n + "'", null);

                if(k1.moveToFirst()){
                    fDate=k1.getString(3);
                }
                if(x1=chkfine(nDate1,fDate1)) {
                    int fine=findAmount(nDate1,fDate1);

                    Toast.makeText(cart.this,"fine to be paid :Rs."+fine, Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(cart.this,"Thank You for visiting Library(submitted on time!)", Toast.LENGTH_LONG).show();
                }
            }
        });
        b32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o=t6.getText().toString();
                String lu=o.substring(5,o.length());
                db5.execSQL("UPDATE books SET available='" + 1 + "' WHERE id='" + lu + "'");
                dtb1.execSQL("UPDATE reg SET b3id='" + "1000" + "' WHERE username='" + name + "'");
                clearText(t3);
                clearText(t6);
                clearText(t9);
                b32.setVisibility(View.GONE);
              //  Toast.makeText(cart.this,"Book Returned!", Toast.LENGTH_LONG).show();
                k1=db5.rawQuery("SELECT * FROM books WHERE id='" + o + "'", null);

                if(k1.moveToFirst()){
                    fDate=k1.getString(3);
                }
                if(x1=chkfine(nDate1,fDate1)) {
                    int fine=findAmount(nDate1,fDate1);

                    Toast.makeText(cart.this,"fine to be paid :Rs."+fine, Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(cart.this,"Thank You for visiting Library(submitted on time!)", Toast.LENGTH_LONG).show();
                }
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.equals("manish1616j")){
                    Intent i10=new Intent(cart.this,admin.class);
                    i10.putExtra("uname",name);
                    startActivity(i10);
                }
                else{
                Intent i10=new Intent(cart.this,Home.class);
                i10.putExtra("name",name);
                startActivity(i10);}
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(cart.this,search.class);
                i.putExtra("uname",name);
                startActivity(i);
            }
        });

    }
   /* public void onClick(View view) {
        if(view.getId() == R.id.show){
            dt=openOrCreateDatabase("cartdb", Context.MODE_PRIVATE,null);
            dt.execSQL("CREATE TABLE IF NOT EXISTS cartDB(user text,bookname text,returnDate text);");
            Cursor c=dt.rawQuery("SELECT * FROM cartDB",null);
            if (c.getCount() == 0) {
                showMessage("Error", "No records found");
                return;
            }
            StringBuffer buffer = new StringBuffer();
            while (c.moveToNext())
            {
                buffer.append("Username : " + c.getString(0) + "\n");
                buffer.append("book name : " + c.getString(1) + "\n");
                buffer.append("return date : " + c.getString(2) + "\n\n");
            }
            // Displaying all records 
            showMessage("Student Details", buffer.toString());


        }
            //Toast.makeText(this,"Button 1 Clicked", Toast.LENGTH_LONG).show();


    }
    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
*/
   public void clearText(TextView t){
       t.setText("");
   }
  public boolean chkfine(String a,String b) {
     Log.d("manish",a+" "+b+" ");
       /*int l,m,n,o,p,q,r;
       l=Integer.parseInt(a.substring(0,2));
       m=Integer.parseInt(b.substring(0,2));
       n=Integer.parseInt(a.substring(3,5));
       o=Integer.parseInt(b.substring(3,5));
       p=Integer.parseInt(a.substring(6,10));
       q=Integer.parseInt(b.substring(6,10));
       if( p>q ||((l>m) && (n>=o) && (p>=q))){
           return true;
       }
       else{
           return false;
       }*/
       try{
      Date cc = Calendar.getInstance().getTime();
      Calendar cal = Calendar.getInstance();
      cal.setTime(cc);
      cc.getTime();
      //a = df.format(cc);
      // a = df.format(cc);
      //b10 = df.format(cc);
      //cal.add(Calendar.DATE,0);
      //b = df.format(cc);
      SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
      //a=sdf.format(cc);
      Date d1=sdf.parse(a);

      Date d2=sdf.parse(b);
      if(d1.compareTo(d2)<0){
          return false;
      }
      else{
      return true;}}
       catch(Exception e){
           return false;
      }
  }
   public int findAmount(String a,String b){
       SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
       Date d1;
       Date d2;
       try{
        d1=sdf.parse(a);
        d2=sdf.parse(b);
           long diffInMillies = Math.abs(d1.getTime() - d2.getTime());
           long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
           int k=(int)diff;
           return (k*2);}
       catch(Exception e){
           return -1;
       }

   }

}
