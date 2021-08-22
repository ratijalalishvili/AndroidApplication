package com.example.automobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class IndividualCar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.individual_car);

        Car car = getIntent().getParcelableExtra("car");

        TextView description = findViewById(R.id.description);

        description.setText(car.getDescription());

        TextView topic = findViewById(R.id.topic);

        topic.setText(car.getName()+" "+car.getSurname());

        TextView iCarBrand = findViewById(R.id.iCarBrand);
        iCarBrand.setText(car.getCarBrand());

        CheckedTextView iABS = findViewById(R.id.iABS);

        iABS.setCheckMarkDrawable(car.isHasABS() ? R.drawable.ic_baseline_check_24 : R.drawable.ara);

        CheckedTextView iElshushebi = findViewById(R.id.iElshushebi);

        iElshushebi.setCheckMarkDrawable(car.isHasElshushebi() ? R.drawable.ic_baseline_check_24 : R.drawable.ara);


        CheckedTextView iLuqi = findViewById(R.id.iLuqi);

        iLuqi.setCheckMarkDrawable(car.isHasLuqi() ? R.drawable.ic_baseline_check_24 : R.drawable.ara);

        CheckedTextView iBluetooth = findViewById(R.id.iBluetooth);

       iBluetooth.setCheckMarkDrawable(car.isHasBluetooth() ? R.drawable.ic_baseline_check_24 : R.drawable.ara);

        CheckedTextView iSignal = findViewById(R.id.iSignal);

        iSignal.setCheckMarkDrawable(car.isHasSignal() ? R.drawable.ic_baseline_check_24 : R.drawable.ara);

        CheckedTextView iParking = findViewById(R.id.iParking);

        iParking.setCheckMarkDrawable(car.isHasParking() ? R.drawable.ic_baseline_check_24 : R.drawable.ara);

        CheckedTextView iNavigation = findViewById(R.id.iNavigation);

        iNavigation.setCheckMarkDrawable(car.isHasNavigation() ? R.drawable.ic_baseline_check_24 : R.drawable.ara);

        CheckedTextView iBortComputer = findViewById(R.id.iBortComputer);

        iBortComputer.setCheckMarkDrawable(car.isHasBortComputer() ? R.drawable.ic_baseline_check_24 : R.drawable.ara);

        CheckedTextView iMultiWheel = findViewById(R.id.iMultiWheel);

        iMultiWheel.setCheckMarkDrawable(car.isHasMultiWheel() ? R.drawable.ic_baseline_check_24 : R.drawable.ara);


        ImageView photo = findViewById(R.id.photo);
//        https://www.autocar.co.uk/sites/autocar.co.uk/files/images/car-reviews/first-drives/legacy/1_rangerover_tracking.jpg
        BitMapWrapper wrapper = new BitMapWrapper();
        Thread thread = new Thread(() -> {
            try {
                URL url = new URL(car.getImgURL());


                wrapper.setBitmap(BitmapFactory.decodeStream(url.openConnection().getInputStream()));



            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        try {
            thread.join();
            photo.setImageBitmap(wrapper.getBitmap());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static class BitMapWrapper {
        private Bitmap bitmap;

        public Bitmap getBitmap() {
            return bitmap;
        }

        public void setBitmap(Bitmap bitmap) {
            this.bitmap = bitmap;
        }
    }
}