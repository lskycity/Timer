package com.lskycity.timer.record;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by liuzhaofeng on 2016/1/30.
 */
public class Record implements Parcelable{
    public long id;
    public long total;
    public long normal;
    public long reminder;
    public long waring;

    protected Record(Parcel in) {
        id = in.readLong();
        total = in.readLong();
        normal = in.readLong();
        reminder = in.readLong();
        waring = in.readLong();
    }

    public Record(long total, long normal, long reminder, long waring) {
        id = -1;
        this.total = total;
        this.normal = normal;
        this.reminder = reminder;
        this.waring = waring;
    }

    public Record(long id, long total, long normal, long reminder, long waring) {
        this.id = id;
        this.total = total;
        this.normal = normal;
        this.reminder = reminder;
        this.waring = waring;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeLong(total);
        dest.writeLong(normal);
        dest.writeLong(reminder);
        dest.writeLong(waring);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Record> CREATOR = new Creator<Record>() {
        @Override
        public Record createFromParcel(Parcel in) {
            return new Record(in);
        }

        @Override
        public Record[] newArray(int size) {
            return new Record[size];
        }
    };

    @Override
    public String toString() {
        return total+", "+normal+", "+reminder+", "+waring;
    }




}
