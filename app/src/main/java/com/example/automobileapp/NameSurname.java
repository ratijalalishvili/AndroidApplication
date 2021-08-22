package com.example.automobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NameSurname extends AppCompatActivity {

    String name;

    String surname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.namesurname);

        EditText nameInput = findViewById(R.id.nameInput);

        EditText surnameInput = findViewById(R.id.surnameInput);

        Button submit = findViewById(R.id.submit);

        Car car = (Car) getIntent().getParcelableExtra("car");


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = nameInput.getText().toString();

                car.setName(name);

                surname=surnameInput.getText().toString();

                car.setSurname(surname);

                Intent intent = new Intent(NameSurname.this, MainActivity.class);

                intent.putExtra("car",car);
                intent.putExtra("isEdit",false);
                startActivity(intent);


            }
        });
    }




}