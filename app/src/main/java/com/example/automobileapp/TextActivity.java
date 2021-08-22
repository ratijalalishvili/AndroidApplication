package com.example.automobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TextActivity extends AppCompatActivity {

    String description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);


        Car car = (Car)getIntent().getParcelableExtra("car");

        boolean isEdit = getIntent().getBooleanExtra("isEdit",true);

        EditText input = findViewById(R.id.photoLink);

        if(isEdit){
            input.setText(car.getDescription());
        }


        Button next3 = findViewById(R.id.next3);

        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                description = input.getText().toString();

                car.setDescription(description);

                Intent pass = new Intent(TextActivity.this,PhotoUpload.class);

                pass.putExtra("car",car);


                pass.putExtra("isEdit",isEdit);


                startActivity(pass);

            }
        });

    }
}