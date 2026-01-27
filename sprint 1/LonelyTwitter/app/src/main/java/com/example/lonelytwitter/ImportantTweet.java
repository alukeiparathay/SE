package com.example.lonelytwitter;

import java.util.Date;

public class ImportantTweet extends Tweet {

    // Constructors for important tweet
    public ImportantTweet(String message) {
        super(message);
    }

    public ImportantTweet(Date date, String message) {
        super(date, message);
    }

    @Override
    public Boolean isImportant() {
        // we return true for important tweets
        return Boolean.TRUE;
    }
}