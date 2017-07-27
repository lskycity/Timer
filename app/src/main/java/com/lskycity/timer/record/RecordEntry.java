package com.lskycity.timer.record;

import android.provider.BaseColumns;

/**
 * Created by liuzhaofeng on 2016/1/29.
 */
public class RecordEntry implements BaseColumns{
    private static final String LONG_TYPE = " LONG";
    private static final String COMMA_SEP = ",";

    public static final String TABLE_NAME = "timer_record";
    public static final String COLUMN_NAME_TOTAL = "total";
    public static final String COLUMN_NAME_NORMAL = "normal";
    public static final String COLUMN_NAME_REMINDER = "reminder";
    public static final String COLUMN_NAME_WARING = "waring";


    /*package*/ static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    _ID + " INTEGER PRIMARY KEY," +
                    COLUMN_NAME_TOTAL + LONG_TYPE + COMMA_SEP +
                    COLUMN_NAME_NORMAL + LONG_TYPE + COMMA_SEP +
                    COLUMN_NAME_REMINDER + LONG_TYPE + COMMA_SEP +
                    COLUMN_NAME_WARING + LONG_TYPE +
                    " )";
    /*package*/ static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;
}
