package com.example.barvius.lb2;

import android.os.Parcel;
import android.os.Parcelable;

public class Author implements Parcelable {
    private String firstName;
    private String lastName;
    private String thirdName;
    private float avgValue;

    protected Author(Parcel in) {
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.thirdName = in.readString();
        this.avgValue = in.readFloat();
    }

    public static final Creator<Author> CREATOR = new Creator<Author>() {
        @Override
        public Author createFromParcel(Parcel in) {
            return new Author(in);
        }

        @Override
        public Author[] newArray(int size) {
            return new Author[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.firstName);
        dest.writeString(this.lastName);
        dest.writeString(this.thirdName);
        dest.writeFloat(this.avgValue);
    }

    public Author(String firstName, String lastName, String thirdName, float avgValue) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.thirdName = thirdName;
        this.avgValue = avgValue;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public float getAvgValue() {
        return avgValue;
    }
}
