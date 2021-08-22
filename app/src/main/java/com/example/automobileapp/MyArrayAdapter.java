package com.example.automobileapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MyArrayAdapter extends ArrayAdapter<Car>{
    public MyArrayAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public MyArrayAdapter(@NonNull Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public MyArrayAdapter(@NonNull Context context, int resource, @NonNull Car[] objects) {
        super(context, resource, objects);
    }

    public MyArrayAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull Car[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public MyArrayAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
    }

    public MyArrayAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List objects) {
        super(context, resource, textViewResourceId, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.arrayadapter, parent, false);
        }

        TextView nameSurname = view.findViewById(R.id.list_item_string);

        nameSurname.setText(MainActivity.carList.get(position).getName()+" "+MainActivity.carList.get(position).getSurname());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent passCar = new Intent(getContext(),IndividualCar.class);

                passCar.putExtra("car",MainActivity.carList.get(position));

                getContext().startActivity(passCar);
            }
        });

        Button deleteButton = view.findViewById(R.id.delete_btn);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.carList.remove(position);
                notifyDataSetChanged();
            }
        });

        Button editButton = view.findViewById(R.id.edit_btn);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(),AddCarActivity.class);

                intent.putExtra("car",MainActivity.carList.get(position));

                intent.putExtra("isEdit",true);


                getContext().startActivity(intent);

            }
        });


            return view;

    }
}
