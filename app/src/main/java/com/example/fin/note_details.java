package com.example.fin;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class note_details implements Parcelable {

    private String id;
    private String details;

    public note_details() {

    }

    public note_details(String id, String details) {
        this.id = id;
        this.details = details;
    }



    protected note_details(Parcel in) {
        id = in.readString();
        details = in.readString();
    }

    public static final Creator<note_details> CREATOR = new Creator<note_details>() {
        @Override
        public note_details createFromParcel(Parcel in) {
            return new note_details(in);
        }

        @Override
        public note_details[] newArray(int size) {
            return new note_details[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(details);
    }
}
