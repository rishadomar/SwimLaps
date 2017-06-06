package com.rishad.swimlaps.Session;

import android.content.Context;

import java.util.Date;

public class Session {
    private long id;
    private Date date;

    public Session(long id, Date date)
    {
        this.id = id;
        this.date = date;
    }

    static public Session makeNew(Context applicationContext) {
        DatabaseHelper db = new DatabaseHelper(applicationContext);
        return db.createSession();
    }

    public long getId() {
        return this.id;
    }

    public Date getDate()
    {
        return this.date;
    }

    static public Session [] getAll()
    {
        Session[] allSessions = new Session[3];
        return allSessions;
    }

}


