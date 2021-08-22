package com.example.automobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Checkboxactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkboxactivity);



        Car car = (Car)getIntent().getParcelableExtra("car");

        boolean isEdit = getIntent().getBooleanExtra("isEdit",true);
        CheckBox abs = findViewById(R.id.ABS);



        CheckBox elshushebi = findViewById(R.id.elshushebi);


        CheckBox luqi = findViewById(R.id.luqi);



        CheckBox bluetooth = findViewById(R.id.bluetooth);



        CheckBox signal = findViewById(R.id.signal);




        CheckBox parking = findViewById(R.id.parking);



        CheckBox navigation = findViewById(R.id.navigation);



        CheckBox bortcomputer = findViewById(R.id.bortcomputer);



        CheckBox multiwheel = findViewById(R.id.multiwheel);

        if(isEdit){

            abs.setChecked(car.isHasABS());
            elshushebi.setChecked(car.isHasElshushebi());
            luqi.setChecked(car.isHasLuqi());
            bluetooth.setChecked(car.isHasBluetooth());
            signal.setChecked(car.isHasSignal());
            parking.setChecked(car.isHasParking());
            navigation.setChecked(car.isHasNavigation());
            bortcomputer.setChecked(car.isHasBortComputer());
            multiwheel.setChecked(car.isHasMultiWheel());
        }



        Button next2 = findViewById(R.id.next2);

        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                car.setHasABS(abs.isChecked());

                car.setHasElshushebi(elshushebi.isChecked());

                car.setHasLuqi(luqi.isChecked());

                car.setHasBluetooth(bluetooth.isChecked());

                car.setHasSignal(signal.isChecked());

                car.setHasParking(parking.isChecked());

                car.setHasNavigation(navigation.isChecked());

                car.setHasBortComputer(bortcomputer.isChecked());

                car.setHasMultiWheel(multiwheel.isChecked());


                Intent passObject = new Intent(Checkboxactivity.this,TextActivity.class);

                passObject.putExtra("car",car);


                passObject.putExtra("isEdit",isEdit);

                startActivity(passObject);


            }
        });

    }
}