package com.example.apps1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayContact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contact);


        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String number = intent.getStringExtra("number");

        TextView display_name = findViewById(R.id.displayname);
        display_name.setText("Name: "+name);

        TextView display_number = findViewById(R.id.displaynumber);
        display_number.setText("Number: "+number);


    }
}