package com.example.lonelytwitter;

import java.util.Date;

public class SadMood extends Mood {

    // Writing constructors for sad mood
    public SadMood() {
        super();
    }

    public SadMood(Date date) {
        // calling super constructor with date
        super(date);
    }

    @Override
    public String getMood() {
        // we return sad for sad mood
        return "Sad"; 
    }
}