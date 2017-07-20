package me.a3zcs.courtcounter.tourguide.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by root on 19/07/17.
 */

public class Location implements Parcelable{
    String location;

    public Location(String location) {
        this.location = location;
    }

    protected Location(Parcel in) {
        location = in.readString();
    }

    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(location);
    }
}
