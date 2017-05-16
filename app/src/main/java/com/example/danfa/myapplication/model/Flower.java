package com.example.danfa.myapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by danfa on 14/05/2017.
 */

public class Flower implements Parcelable {

    @SerializedName("full_name")
    @Expose
    public String fullName;
    @SerializedName("owner")
    @Expose
    private Owner owner;

    protected Flower(Parcel in) {
        fullName = in.readString();
        owner = in.readParcelable(Owner.class.getClassLoader());
    }

    public static final Creator<Flower> CREATOR = new Creator<Flower>() {
        @Override
        public Flower createFromParcel(Parcel in) {
            return new Flower(in);
        }

        @Override
        public Flower[] newArray(int size) {
            return new Flower[size];
        }
    };

    public String getPhotoUrl() {
        return owner.avatarUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fullName);
        dest.writeParcelable(owner, flags);
    }
}
