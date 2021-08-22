package com.example.automobileapp;

import android.os.Parcel;
import android.os.Parcelable;


public class Car implements Parcelable {

    public Car(){

    }


    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private   String carBrand;

    private boolean hasABS;

    private boolean hasElshushebi;

    private boolean hasLuqi;

    private boolean hasBluetooth;

    private boolean hasSignal;

    private boolean hasParking;

    private  boolean hasNavigation;

    private  boolean hasBortComputer;

    private  boolean hasMultiWheel;

    private String description;

    private String name;

    private String surname;

    private String imgURL;


    protected Car(Parcel in) {
        id = in.readLong();
        carBrand = in.readString();
        hasABS = in.readByte() != 0;
        hasElshushebi = in.readByte() != 0;
        hasLuqi = in.readByte() != 0;
        hasBluetooth = in.readByte() != 0;
        hasSignal = in.readByte() != 0;
        hasParking = in.readByte() != 0;
        hasNavigation = in.readByte() != 0;
        hasBortComputer = in.readByte() != 0;
        hasMultiWheel = in.readByte() != 0;
        description = in.readString();
        name = in.readString();
        surname = in.readString();
        imgURL = in.readString();
    }

    public static final Creator<Car> CREATOR = new Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel in) {
            return new Car(in);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public boolean isHasABS() {
        return hasABS;
    }

    public void setHasABS(boolean hasABS) {
        this.hasABS = hasABS;
    }

    public boolean isHasElshushebi() {
        return hasElshushebi;
    }

    public void setHasElshushebi(boolean hasElshushebi) {
        this.hasElshushebi = hasElshushebi;
    }

    public boolean isHasLuqi() {
        return hasLuqi;
    }

    public void setHasLuqi(boolean hasLuqi) {
        this.hasLuqi = hasLuqi;
    }

    public boolean isHasBluetooth() {
        return hasBluetooth;
    }

    public void setHasBluetooth(boolean hasBluetooth) {
        this.hasBluetooth = hasBluetooth;
    }

    public boolean isHasSignal() {
        return hasSignal;
    }

    public void setHasSignal(boolean hasSignal) {
        this.hasSignal = hasSignal;
    }

    public boolean isHasParking() {
        return hasParking;
    }

    public void setHasParking(boolean hasParking) {
        this.hasParking = hasParking;
    }

    public boolean isHasNavigation() {
        return hasNavigation;
    }

    public void setHasNavigation(boolean hasNavigation) {
        this.hasNavigation = hasNavigation;
    }

    public boolean isHasBortComputer() {
        return hasBortComputer;
    }

    public void setHasBortComputer(boolean hasBortComputer) {
        this.hasBortComputer = hasBortComputer;
    }

    public boolean isHasMultiWheel() {
        return hasMultiWheel;
    }

    public void setHasMultiWheel(boolean hasMultiWheel) {
        this.hasMultiWheel = hasMultiWheel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(id);
        parcel.writeString(carBrand);
        parcel.writeByte((byte) (hasABS ? 1 : 0));
        parcel.writeByte((byte) (hasElshushebi ? 1 : 0));
        parcel.writeByte((byte) (hasLuqi ? 1 : 0));
        parcel.writeByte((byte) (hasBluetooth ? 1 : 0));
        parcel.writeByte((byte) (hasSignal ? 1 : 0));
        parcel.writeByte((byte) (hasParking ? 1 : 0));
        parcel.writeByte((byte) (hasNavigation ? 1 : 0));
        parcel.writeByte((byte) (hasBortComputer ? 1 : 0));
        parcel.writeByte((byte) (hasMultiWheel ? 1 : 0));
        parcel.writeString(description);
        parcel.writeString(name);
        parcel.writeString(surname);
        parcel.writeString(imgURL);
    }

    public void updateValues(Car updated) {
        if (updated == null) {
            return;
        }
        carBrand = updated.carBrand;
        hasABS = updated.hasABS;
        hasElshushebi=updated.hasElshushebi;
        hasLuqi =updated.hasLuqi;
        hasBluetooth =updated.hasBluetooth;
        hasSignal = updated.hasSignal;
        hasParking = updated.hasParking;
        hasBortComputer = updated.hasBortComputer;
        hasMultiWheel = updated.hasMultiWheel;
        hasNavigation = updated.hasNavigation;

        description = updated.description;
        imgURL = updated.imgURL;

        //name da surname ar gvhirdeba magram mainc iyos.
        name =updated.name;
        surname = updated.surname;
    }
}
