package com.example.automobileapp;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class AddCarActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcar);

        Car car = (Car)getIntent().getParcelableExtra("car");
        boolean isEdit = getIntent().getBooleanExtra("isEdit",true);

        Button next1 = (Button) findViewById(R.id.next1);



        next1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                Intent passObject = new Intent(AddCarActivity.this,Checkboxactivity.class);

                passObject.putExtra("car",car);

                passObject.putExtra("isEdit",isEdit);

                startActivity(passObject);


            }
        });

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter <CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.carBrands, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        if(isEdit){
            spinner.setSelection(adapter.getPosition(car.getCarBrand()));
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

         Car car = getIntent().getParcelableExtra("car");
         car.setCarBrand(adapterView.getItemAtPosition(i).toString());

        Toast.makeText(adapterView.getContext(),car.getCarBrand(),Toast.LENGTH_SHORT);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Car car = getIntent().getParcelableExtra("car");
        car.setCarBrand(null);
    }

}