package com.example.cice.mistrastos.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by CICE on 12/1/16.
 */
public class Trasto implements Parcelable {

    private String name, info;
    private float price;
    private boolean onSale;
    private Bitmap image;
    private ArrayList<String> stores;

    /**
     *
     * CONSTRUCTORS
     *
     */

    public Trasto() {
    }

    public Trasto(String name, boolean onSale) {
        this.name = name;
        this.onSale = onSale;
        this.info = "No hay descripción";
    }



    /**
     *
     * GETTERS Y SETTERS
     *
     */
    public ArrayList<String> getStores() {
        return stores;
    }

    public void setStores(ArrayList<String> stores) {
        this.stores = stores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    /**
     *
     * PARCELABLE
     *
     */

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(info);
        dest.writeFloat(price);
        dest.writeByte((byte) (onSale ? 1 : 0));
        //dest.writeParcelable(image, flags);
        dest.writeStringList(stores);
    }

    protected Trasto(Parcel in) {
        name = in.readString();
        info = in.readString();
        price = in.readFloat();
        onSale = in.readByte() != 0;
        //image = in.readParcelable(Bitmap.class.getClassLoader());
        stores = in.createStringArrayList();
    }

    public static final Creator<Trasto> CREATOR = new Creator<Trasto>() {
        @Override
        public Trasto createFromParcel(Parcel in) {
            return new Trasto(in);
        }

        @Override
        public Trasto[] newArray(int size) {
            return new Trasto[size];
        }
    };


}
