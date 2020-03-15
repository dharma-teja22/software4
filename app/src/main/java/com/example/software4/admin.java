package com.example.software4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class admin extends AppCompatActivity {
    Button b20,b21,b22,b23,b24;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        Bundle b = getIntent().getExtras();
        name = b.getString("uname");
        b20=(Button)findViewById(R.id.upload);
        b21=(Button)findViewById(R.id.search1);
        b22=(Button)findViewById(R.id.return2);
        b23=(Button)findViewById(R.id.logout1);
        b20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(admin.this,addbooks.class);
                intent.putExtra("uname",name);
                startActivity(intent);

            }
        });
        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(admin.this,search.class);
                intent.putExtra("uname",name);
                startActivity(intent);

            }
        });
        b22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(admin.this,cart.class);
                intent.putExtra("name",name);
                startActivity(intent);

            }
        });
        b23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(admin.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
