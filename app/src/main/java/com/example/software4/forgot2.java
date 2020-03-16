package com.example.software4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class forgot2 extends AppCompatActivity {
String name;
Button b8;
EditText e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot2);
        Bundle b = getIntent().getExtras();
        //bname=b.getString("bname");
        name=b.getString("uname");
        b8=(Button)findViewById(R.id.bb);
        e2=(EditText)findViewById(R.id.etv);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=e2.getText().toString();
                if(s.equals("4488")){
                    Intent i=new Intent(forgot2.this,forgot3.class);
                    i.putExtra("uname",name);
                    startActivity(i);
                }
                //Toast.makeText(getApplicationContext(),"hii",Toast.LENGTH_LONG).show();
            }
        });
    }
}
