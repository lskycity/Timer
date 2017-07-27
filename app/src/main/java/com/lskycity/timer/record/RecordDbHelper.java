package com.lskycity.timer.record;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzhaofeng on 2016/1/29.
 */
public class RecordDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FetchRecord.db";

    public RecordDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(RecordEntry.SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(RecordEntry.SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(RecordEntry.SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void insert(long total, long normal, long reminder, long waring) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(RecordEntry.COLUMN_NAME_TOTAL, total);
        values.put(RecordEntry.COLUMN_NAME_NORMAL, normal);
        values.put(RecordEntry.COLUMN_NAME_REMINDER, reminder);
        values.put(RecordEntry.COLUMN_NAME_WARING, waring);

        db.insert(RecordEntry.TABLE_NAME, null, values);
    }
    public void insert(Record record) {
        insert(record.total, record.normal, record.reminder, record.waring);
    }

    public Cursor query() {
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                RecordEntry._ID,
                RecordEntry.COLUMN_NAME_TOTAL,
                RecordEntry.COLUMN_NAME_NORMAL,
                RecordEntry.COLUMN_NAME_REMINDER,
                RecordEntry.COLUMN_NAME_WARING
        };
        return db.query(RecordEntry.TABLE_NAME, projection, null, null, null, null, RecordEntry._ID+" DESC");
    }

    public List<Record> queryForList() {
        Cursor cur = query();

        List<Record> records = new ArrayList<>(cur.getCount());

        int idColumn = cur.getColumnIndex(RecordEntry._ID);
        int totalColumn = cur.getColumnIndex(RecordEntry.COLUMN_NAME_TOTAL);
        int normalColumn = cur.getColumnIndex(RecordEntry.COLUMN_NAME_NORMAL);
        int reminder = cur.getColumnIndex(RecordEntry.COLUMN_NAME_REMINDER);
        int waring = cur.getColumnIndex(RecordEntry.COLUMN_NAME_WARING);

        for(cur.moveToFirst();!cur.isAfterLast();cur.moveToNext()) {
           records.add(new Record(cur.getInt(idColumn),
                   cur.getLong(totalColumn),
                   cur.getLong(normalColumn),
                   cur.getLong(reminder),
                   cur.getLong(waring)
                   ));
        }

        return records;
    }

}
