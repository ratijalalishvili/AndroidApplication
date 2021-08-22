package com.example.automobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PhotoUpload extends AppCompatActivity {

    String theLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photoupload);



        Car car = (Car) getIntent().getParcelableExtra("car");
        boolean isEdit = getIntent().getBooleanExtra("isEdit",true);
        EditText photoLink = findViewById(R.id.photoLink);

        if(isEdit){
            photoLink.setText(car.getImgURL());
        }


        Button next4 = findViewById(R.id.next4);

        next4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                theLink =photoLink.getText().toString();

                car.setImgURL(theLink);

                if(!isEdit) {
                    Intent pass = new Intent(PhotoUpload.this, NameSurname.class);


                    pass.putExtra("car", car);

                    startActivity(pass);
                }
                else{
                    Intent editFinished = new Intent(PhotoUpload.this,MainActivity.class);

                    editFinished.putExtra("isEdit",true);

                    editFinished.putExtra("car",car);

                    startActivity(editFinished);

                }

            }
        });


    }
}