package com.example.software4;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class search extends AppCompatActivity implements
        AdapterView.OnItemClickListener {
    DatabaseHelper myDb;
    String name;
    SQLiteDatabase db5;
    Cursor c;
    int i=0,j,k,z=0,count1=0,p,y=0;
    Button b8;
    String sw;
    SearchView mySearchView;
    ListView myList;
    ArrayList<String> list = new ArrayList<>();;
    //ArrayAdapter<String> adapter;
    ArrayAdapter<String> ada;
    String[] books1;
     String[] books2= {"Material Science and Engineering", "Machinery", "Systems and Contol Engineering", "Software Design and Engineering", "Operating Systems", "Algorithms", "Power Systems",
            "Circuits", "Signal Processing", "Inorganic Chemistry", "Quantum chemistry", "Construction", "Structural Engineering", "Transportation"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Bundle b = getIntent().getExtras();
        name = b.getString("uname");
//        books1 = b.getStringArray("bo1");
        //list = b.getStringArrayList("bo1");
        //Toast.makeText(getApplicationContext(), "success4", Toast.LENGTH_LONG).show();
        b8=(Button)findViewById(R.id.add);
        //b8.setOnClickListener(this);
        b8.setVisibility(View.GONE);
        mySearchView = (SearchView) findViewById(R.id.searchView);
        myList = (ListView) findViewById(R.id.myList);

        //list.add("Material Science and Engineering","Machinery","Systems and Contol Engineering","Software Design and Engineering","Operating Systems","Algorithms","Power Systems",
        //"Circuits","Signal Processing","Inorganic Chemistry","Quantum chemistry","Construction","Structural Engineering","Transportation");
        //String[] books1={"Material Science and Engineering","Machinery","Systems and Contol Engineering","Software Design and Engineering","Operating Systems","Algorithms","Power Systems",
        // "Circuits","Signal Processing","Inorganic Chemistry","Quantum chemistry","Construction","Structural Engineering","Transportation"};

        // myList.setOnClickListener(this);


       // Toast.makeText(getApplicationContext(), "success4", Toast.LENGTH_LONG).show();
        db5 = openOrCreateDatabase("booksDB.db", Context.MODE_PRIVATE, null);
        db5.execSQL("CREATE TABLE IF NOT EXISTS books(id text,name text,available text,issuedate text);");
        c=db5.rawQuery("SELECT * FROM books ",null);
        //z=0;
        while(c.moveToNext()){
            sw=c.getString(1);

            if(!list.contains(sw)){
                list.add(sw);
            }

        }




        ada = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                list);
        myList.setAdapter(ada);

        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                ada.getFilter().filter(newText);

                return false;

            }
        });
        //Toast.makeText(getApplicationContext(), "success4", Toast.LENGTH_LONG).show();
        //myList.setOnItemClickListener(this);

       // c = db3.rawQuery("SELECT * FROM books", null);
        //Toast.makeText(getApplicationContext(),"success1", Toast.LENGTH_LONG).show();
        //Toast.makeText(getApplicationContext(), c.getCount() + "", Toast.LENGTH_SHORT).show();

       // if (c.getCount() > 0) {
           // Toast.makeText(getApplicationContext(), "success2", Toast.LENGTH_LONG).show();
        //} else {
            // Toast.makeText(getApplicationContext(), "success1", Toast.LENGTH_LONG).show();




        /*myList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txt = (TextView) v;
                Toast.makeText(getApplicationContext(), "You have selected : " + txt.getText(),
                        Toast.LENGTH_SHORT).show();

            }
        });*/

        //}
        myList.setOnItemClickListener(this);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for ( i = 0; i < 14; i++) {
                    String s = books2[i];
                    //

                    db5.execSQL("INSERT INTO books VALUES('" + i + "','" + s +
                            "','" + 1 + "','" + "null" + "');");}
                j=i-14;
                for (i = 14; i < 28; i++) {

                    String s = books2[j];
                    //

                    db5.execSQL("INSERT INTO books VALUES('" + i + "','" + s +
                            "','" + 1 + "','" + "null" + "');");
                    j++;}
                k=i-28;
                for (i = 28; i < 42; i++) {
                    String s = books2[k];
                    //

                    db5.execSQL("INSERT INTO books VALUES('" + i + "','" + s +
                            "','" + 1 + "','" + "null" + "');");
                    k++;}

                //c=db3.rawQuery("SELECT * FROM books WHERE name=" + s , null);
                String s1="Machinery";
                c=db5.rawQuery("SELECT * FROM books WHERE name=\'" + s1 + "\'",null);
                //Toast.makeText(getApplicationContext(), "success2", Toast.LENGTH_LONG).show();
                if(c.moveToFirst()){
                    Toast.makeText(getApplicationContext(), "success1", Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        TextView txt = (TextView) view;
        //Toast.makeText(getApplicationContext(), "You have selected : " + txt.getText().toString(),
              //  Toast.LENGTH_SHORT).show();
        Intent i = new Intent(search.this,Request.class);
        i.putExtra("bname",txt.getText().toString());
        i.putExtra("usname",name);
        startActivity(i);


    }



}