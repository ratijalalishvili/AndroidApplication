package com.example.automobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Car> carList = new ArrayList<>();

    public static MyArrayAdapter carListAdapter;

    private static long id =0;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Car car = getIntent().getParcelableExtra("car");
        if (car != null) {

            boolean isEdit = getIntent().getBooleanExtra("isEdit",true);

            if (isEdit) {
                carList.forEach(currentCar -> {
                    if (currentCar.getId() == car.getId()) {
                        currentCar.updateValues(car);
                    }
                });
            } else {
                car.setId(id++);
                carList.add(car);
            }

        }

        ListView listView = findViewById(R.id.ListView);

        carListAdapter = new MyArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,carList);

        listView.setAdapter(carListAdapter);

        Button addCar =  findViewById(R.id.addcar);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent passCar = new Intent(MainActivity.this,IndividualCar.class);

                passCar.putExtra("car",carList.get(i));

                startActivity(passCar);

            }
        });
         addCar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 Intent passObject = new Intent(MainActivity.this,AddCarActivity.class);
                 Car newCar = new Car();

                 passObject.putExtra("isEdit",false);

                 passObject.putExtra("car",newCar);

                 startActivity(passObject);
             }
         });

    }
}