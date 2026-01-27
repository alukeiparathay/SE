package com.example.lonelytwitter;

import java.util.Date;

public abstract class Mood {
    private Date date;

    // Constructors for mood - normal and with date
    public Mood() {
        this.date = new Date();
    }

    public Mood(Date date) {
        // initializing date
        this.date = date;
    }

    // writing Getter and Setter for date
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        // assigning date
        this.date = date;
    }

    public abstract String getMood();
}