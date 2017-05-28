package com.rishad.swimlaps.Session;

import java.util.Date;

public class Session {
    private int id;
    private Date date;

    public Session(int id, Date date)
    {
        this.id = id;
        this.date = date;
    }

    static public Session makeNew()
    {
        return new Session(99, new Date());
    }

    public int getId()
    {
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


