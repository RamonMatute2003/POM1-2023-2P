package com.example.miprimerprojecto;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.miprimerprojecto.models.People;
import com.example.miprimerprojecto.setting.SQLiteConnection;
import com.example.miprimerprojecto.setting.Transactions;

import java.util.ArrayList;

public class Activity_combo extends AppCompatActivity {

    SQLiteConnection connection;
    Spinner combo_people;//combo_people=combo de personas
    EditText names, last_names, email;
    ArrayList<String> people_list;
    ArrayList<People> list;

    //Git
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combo);

         connection=new SQLiteConnection(this, Transactions.name_database, null, 1);
         combo_people=(Spinner) findViewById(R.id.spinner);
         names=(EditText) findViewById(R.id.cb_name);
         last_names=(EditText) findViewById(R.id.cb_last_name);
         email=(EditText) findViewById(R.id.cb_email);
         get_table();
         ArrayAdapter<CharSequence> adapter=new ArrayAdapter(this, android.R.layout.simple_spinner_item, people_list);
         combo_people.setAdapter(adapter);

         combo_people.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 try{
                     names.setText(list.get(position).getNames());
                     last_names.setText(list.get(position).getLast_names());
                     email.setText(list.get(position).getEmail());
                 }catch(Exception ex){
                     ex.toString();
                 }
             }

             @Override
             public void onNothingSelected(AdapterView<?> parent) {

             }
         });
    }

    private void get_table(){//get_table=obtener tabla
        SQLiteDatabase db=connection.getReadableDatabase();
        People person=null;//person=persona
        list=new ArrayList<People>();

        //cursor de base de datos
        Cursor cursor =db.rawQuery(Transactions.select_table_people, null);

        while(cursor.moveToNext()){
            person=new People();
            person.setId(cursor.getInt(0));
            person.setNames(cursor.getString(1));
            person.setLast_names(cursor.getString(2));
            person.setAge(cursor.getInt(3));
            person.setEmail(cursor.getString(4));

            list.add(person);
        }

        cursor.close();

        fill_list();
    }

    private void fill_list(){//fill_list=rellenar lista
        people_list=new ArrayList<String>();

        for (int i = 0; i < list.size(); i++) {
            people_list.add(list.get(i).getId()+" - "+list.get(i).getNames()+" - "+list.get(i).getLast_names());
        }
    }
}