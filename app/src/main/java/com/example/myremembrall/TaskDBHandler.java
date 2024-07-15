package com.example.myremembrall;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;


public class TaskDBHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "tasksDB";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "tasks";
    private static final String COL_ID = "taskID";
    private static final String COL_NAME = "name";
    private static final String COL_MONDAY = "monday";
    private static final String COL_TUESDAY = "tuesday";
    private static final String COL_WEDNESDAY = "wednesday";
    private static final String COL_THURSDAY = "thursday";
    private static final String COL_FRIDAY = "friday";
    private static final String COL_SATURDAY = "saturday";
    private static final String COL_SUNDAY = "sunday";

    public TaskDBHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_NAME + " TEXT, "
                + COL_MONDAY + " BOOLEAN, "
                + COL_TUESDAY + " BOOLEAN, "
                + COL_WEDNESDAY + " BOOLEAN, "
                + COL_THURSDAY + " BOOLEAN, "
                + COL_FRIDAY + " BOOLEAN, "
                + COL_SATURDAY + " BOOLEAN, "
                + COL_SUNDAY + " BOOLEAN)";

        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void addTask(Tasks task) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL_NAME, task.getTaskName());
        values.put(COL_MONDAY, task.getMonday());
        values.put(COL_TUESDAY, task.getTuesday());
        values.put(COL_WEDNESDAY, task.getWednesday());
        values.put(COL_THURSDAY, task.getThursday());
        values.put(COL_FRIDAY, task.getFriday());
        values.put(COL_SATURDAY, task.getSaturday());
        values.put(COL_SUNDAY, task.getSunday());

        sqLiteDatabase.insert(TABLE_NAME, null, values);
        sqLiteDatabase.close();
    }
}
