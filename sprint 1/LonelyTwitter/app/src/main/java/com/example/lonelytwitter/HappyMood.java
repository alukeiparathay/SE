package com.example.lonelytwitter;

import java.util.Date;

public class HappyMood extends Mood {

    // Writing constructors for normal and with date
    public HappyMood() {
        super();
    }

    public HappyMood(Date date) {
        super(date);
    }

    @Override
    public String getMood() {
        // returning happy for happy mood
        return "Happy";
    }
}