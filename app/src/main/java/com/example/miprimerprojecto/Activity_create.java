package com.example.miprimerprojecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.miprimerprojecto.setting.SQLiteConnection;
import com.example.miprimerprojecto.setting.Transactions;

public class Activity_create extends AppCompatActivity {

    EditText names,last_names,age,email;
    Button btn_insert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        names=findViewById(R.id.names);
        last_names=findViewById(R.id.last_names);
        age=findViewById(R.id.age);
        email=findViewById(R.id.email);

        btn_insert=(Button) findViewById(R.id.btn_insert);

        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add_person();
            }
        });
    }

    private void add_person(){//add_person=añadir persona
        SQLiteConnection conection=new SQLiteConnection(this, Transactions.name_database, null, 1);
        SQLiteDatabase db=conection.getWritableDatabase();
        ContentValues values=new ContentValues();//values=valores

        values.put(Transactions.names, names.getText().toString());
        values.put(Transactions.last_names, last_names.getText().toString());
        values.put(Transactions.age, age.getText().toString());
        values.put(Transactions.email, email.getText().toString());

        Long result=db.insert(Transactions.table_people, Transactions.id, values);
        Toast.makeText(getApplicationContext(), "Registro ingresado: "+result.toString(), Toast.LENGTH_LONG).show();
        db.close();
        clean_screen();//CleaScreen=Pantalla limpia
    }

    private void clean_screen(){
        names.setText("");
        last_names.setText("");
        age.setText("");
        email.setText("");
    }
}