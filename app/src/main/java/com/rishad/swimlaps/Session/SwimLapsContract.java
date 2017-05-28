package com.rishad.swimlaps.Session;
import android.provider.BaseColumns;

public final class SwimLapsContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private SwimLapsContract() {
    }

    /* Inner class that defines the table contents */
    public static class SessionEntry implements BaseColumns {
        public static final String TABLE_NAME = "session";
        public static final String COLUMN_NAME_DATE = "date";
    }

    /* Inner class that defines the table contents */
    public static class LapEntry implements BaseColumns {
        public static final String TABLE_NAME = "lap";
        public static final String COLUMN_NAME_SESSIONID = "sessionId";
        public static final String COLUMN_NAME_LAPNUMBER = "lapNumber";
        public static final String COLUMN_NAME_TIME = "time";
    }

    public static final String SQL_CREATE_SESSION =
            "CREATE TABLE " + SessionEntry.TABLE_NAME + " (" +
                    SessionEntry._ID + " INTEGER PRIMARY KEY," +
                    SessionEntry.COLUMN_NAME_DATE + " DATE";

    public static final String SQL_DELETE_SESSION =
            "DROP TABLE IF EXISTS " + SessionEntry.TABLE_NAME;

    public static final String SQL_CREATE_LAP =
            "CREATE TABLE " + LapEntry.TABLE_NAME + " (" +
                    LapEntry._ID + " INTEGER PRIMARY KEY," +
                    LapEntry.COLUMN_NAME_SESSIONID + " INTEGER," +
                    LapEntry.COLUMN_NAME_LAPNUMBER + " INTEGER," +
                    LapEntry.COLUMN_NAME_TIME + " INTEGER," +
                    " FOREIGN KEY(" + LapEntry.COLUMN_NAME_SESSIONID + ") REFERENCES session(" + SessionEntry._ID + ")";

    public static final String SQL_DELETE_LAP =
            "DROP TABLE IF EXISTS " + LapEntry.TABLE_NAME;
}

