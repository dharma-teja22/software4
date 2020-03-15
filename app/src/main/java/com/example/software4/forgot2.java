package com.example.software4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                Toast.makeText(getApplicationContext(),"hii",Toast.LENGTH_LONG).show();
            }
        });
    }
}
