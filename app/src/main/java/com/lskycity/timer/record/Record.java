package com.lskycity.timer.record;

/**
 * Created by liuzhaofeng on 2016/1/30.
 */
public class Record {
    public long id;
    public long total;
    public long normal;
    public long reminder;
    public long waring;

    @Override
    public String toString() {
        return total+", "+normal+", "+reminder+", "+waring;
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

    public Record() {
    }
}
