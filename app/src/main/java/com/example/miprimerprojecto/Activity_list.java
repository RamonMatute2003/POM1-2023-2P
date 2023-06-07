package com.example.miprimerprojecto;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.miprimerprojecto.models.People;
import com.example.miprimerprojecto.setting.SQLiteConnection;
import com.example.miprimerprojecto.setting.Transactions;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class Activity_list extends AppCompatActivity {

    SQLiteConnection connection;//connection=conexion
    ListView people_list;//people list=lista de personas
    ArrayList<People> list;//list=lista
    ArrayList<String> array_people;//array_people=arreglo de personas

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        connection=new SQLiteConnection(this, Transactions.name_database, null, 1);
        people_list=(ListView) findViewById(R.id.list_people);

        get_table();

        ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,array_people);//adapter=adaptador
        people_list.setAdapter(adapter);

        people_list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                String selected_item=(String) parent.getItemAtPosition(position);//selected_item=item seleccionado
                Toast.makeText(getApplicationContext(), "Seleccionaste: "+selected_item, Toast.LENGTH_SHORT).show();
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
        array_people=new ArrayList<String>();

        for (int i = 0; i < list.size(); i++) {
            array_people.add(list.get(i).getId()+" - "+list.get(i).getNames()+" - "+list.get(i).getLast_names());
        }
    }
}