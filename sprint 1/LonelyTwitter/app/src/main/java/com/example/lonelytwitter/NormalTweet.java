package com.example.lonelytwitter;

import java.util.Date;

public class NormalTweet extends Tweet {

    public NormalTweet(String message) {
        // calling super constructor with message only
        super(message);
    }

    public NormalTweet(Date date, String message) {
        // calling super constructor with date and message
        super(date, message);
    }

    @Override
    public Boolean isImportant() {
        // Returning false for normal tweets
        return Boolean.FALSE;
    }
}