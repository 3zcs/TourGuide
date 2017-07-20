package me.a3zcs.courtcounter.tourguide.model;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by root on 19/07/17.
 */

public class Place implements Parcelable{
    String Type;
    String Name;
    Location location;

    public Place(String type, String name, Location location) {
        Type = type;
        Name = name;
        this.location = location;
    }

    protected Place(Parcel in) {
        Type = in.readString();
        Name = in.readString();
        location = in.readParcelable(getClass().getClassLoader());
    }

    public static final Creator<Place> CREATOR = new Creator<Place>() {
        @Override
        public Place createFromParcel(Parcel in) {
            return new Place(in);
        }

        @Override
        public Place[] newArray(int size) {
            return new Place[size];
        }
    };

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Type);
        parcel.writeString(Name);
        parcel.writeParcelable(location,i);
    }
}
