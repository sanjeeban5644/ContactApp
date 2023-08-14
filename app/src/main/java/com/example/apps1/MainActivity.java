package com.example.apps1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.apps1.adapter.RecyclerViewAdapter;
import com.example.apps1.data.MydbHandler;
import com.example.apps1.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private ArrayList<Contact> contactList;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Button button = findViewById(R.id.addButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AddContact.class);
                startActivity(intent);
            }
        });





        MydbHandler db = new MydbHandler(MainActivity.this);

//        Contact c1 = new Contact();
//        c1.setName("test");
//        c1.setNumber("9000");
//        db.addContact(c1);
//
//        Contact c2 = new Contact();
//        c2.setName("Monica");
//        c2.setNumber("9001");
//        db.addContact(c2);
//
//        Contact c3 = new Contact();
//        c3.setName("Joey");
//        c3.setNumber("9002");
//        db.addContact(c3);
//
//        Log.d("hello", "this is my app"+c3.getNumber());
//
//        c3.setId(12);
//        c3.setName("CHANDLER");
//        c3.setNumber("8000");
//        int affectedRows = db.updateTable(c3);
//
//        Log.d("hello","No of affected rows are: "+affectedRows);
//
//        db.deleteTable(1);
//        db.deleteTable(7);
//        db.deleteTable(10);

        contactList = new ArrayList<>();

        List<Contact> list = db.getAllTableData();
        for(Contact contact : list){
            Log.d("hello","id: "+contact.getId()+" name: "+
                    contact.getName()+" number: "+contact.getNumber());
            contactList.add(contact);
        }

        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this,contactList);
        recyclerView.setAdapter(recyclerViewAdapter);

        Log.d("hello ","Total records : "+db.getCount());



    }
}