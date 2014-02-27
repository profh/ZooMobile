package com.example.zoomobile;

import android.provider.BaseColumns;

public final class FeedReaderContract {
	// To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public FeedReaderContract() {}

    /* Inner class that defines the table contents */
    public static abstract class FeedAdventures implements BaseColumns {
        public static final String TABLE_NAME = "adventures";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_STARTINGPOINT = "startingpoint";
    }
    
    public static abstract class FeedLocations implements BaseColumns {
    	public static final String TABLE_NAME = "locations";
    	public static final String COLUMN_NAME_CLUE = "clue";
    	public static final String COLUMN_NAME_TOKEN = "token";
    	public static final String COLUMN_NAME_FOUND = "found";
    	public static final String COLUMN_NAME_FEEDBACKGOOD = "feedbackgood";
    	public static final String COLUMN_NAME_FEEDBACKBAD = "feedbackbad";
    	public static final String COLUMN_NAME_POINTS = "points";
    }
    
    public static abstract class FeedHints implements BaseColumns {
    	public static final String TABLE_NAME = "hints";
    	public static final String COLUMN_NAME_TEXT = "text";
    	public static final String COLUMN_NAME_USED = "used";
    	public static final String COLUMN_NAME_PTDEDUCT = "ptdeduct";
    }
}

