package com.example.apps1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.apps1.data.MydbHandler;
import com.example.apps1.model.Contact;

public class AddContact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        EditText name = findViewById(R.id.entername);
        EditText number = findViewById(R.id.enternumber);

        Button button = findViewById(R.id.save);

        MydbHandler db = new MydbHandler(AddContact.this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contact contact = new Contact();
                if(name.getText().toString().equals("") || number.getText().toString().equals("")){
                    Toast.makeText(AddContact.this, "Invalid or Missing Credentials", Toast.LENGTH_SHORT).show();
                }else{
                    contact.setName(name.getText().toString());
                    contact.setNumber(number.getText().toString());
                    db.addContact(contact);
                    Toast.makeText(AddContact.this, "Sucessfully Added", Toast.LENGTH_SHORT).show();
                    name.setText("");
                    number.setText("");
                }

            }
        });



    }
}