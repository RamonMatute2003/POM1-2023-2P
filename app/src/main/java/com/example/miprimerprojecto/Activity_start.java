package com.example.miprimerprojecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_start extends AppCompatActivity {

    Button btn_list_people, btn_create_people, btn_combo;//btn_list_people=lista de personas, btn_create_people=crear persona
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        btn_create_people=(Button) findViewById(R.id.btn_create_people);
        btn_list_people=(Button) findViewById(R.id.btn_list_people);
        btn_combo=(Button) findViewById(R.id.btn_combo);

        btn_create_people.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Activity_create.class);
                startActivity(intent);
            }
        });

        btn_list_people.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Activity_list.class);
                startActivity(intent);
            }
        });

        btn_combo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Activity_combo.class);
                startActivity(intent);
            }
        });
    }
}