package com.rishad.swimlaps.Session;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

// ref: https://developer.android.com/training/basics/data-storage/databases.html
// http://www.androidhive.info/2013/09/android-sqlite-database-with-multiple-tables/

public class DatabaseHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "swimlaps.db";

    private static final String TABLE_SESSION = "session";
    private static final String COLUMN_SESSION_ID = "id";
    private static final String COLUMN_SESSION_DATE = "date";
    private static final String CREATE_TABLE_SESSION =
            "CREATE TABLE " + TABLE_SESSION +
            "(" + COLUMN_SESSION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_SESSION_DATE + " DATETIME)";

    private static final String TABLE_LAP = "lap";
    private static final String COLUMN_LAP_ID = "id";
    private static final String COLUMN_LAP_SESSIONID = "sessionId";
    private static final String COLUMN_LAP_LAPNUMBER = "lapNumber";
    private static final String COLUMN_LAP_TIME = "time";
    private static final String COLUMN_LAP_CREATED = "created";
    private static final String CREATE_TABLE_LAP =
            "CREATE TABLE " + TABLE_LAP +
                    "(" + COLUMN_LAP_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_LAP_SESSIONID + " INTEGER," +
                    COLUMN_LAP_LAPNUMBER + " INTEGER," +
                    COLUMN_LAP_TIME + " INTEGER," +
                    COLUMN_LAP_CREATED + " DATETIME)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_SESSION);
        db.execSQL(CREATE_TABLE_LAP);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SESSION);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LAP);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    /**
     * Creating a Session
     */
    public Session createSession() {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        values.put(COLUMN_SESSION_DATE, dateFormat.format(date));
        long id = db.insert(TABLE_SESSION, null, values);
        return new Session(id, date);
    }

    // closing database
    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }

    /**
     * get datetime
     * */
    private Date getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        return new Date();
    }
}
