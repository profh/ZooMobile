package com.example.zoomobile;

import android.provider.BaseColumns;

public final class FeedReaderContract {
	// To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public FeedReaderContract() {}

    /* Inner class that defines the table contents */
    public static abstract class FeedAdventures implements BaseColumns {
        public static final String TABLE_NAME = "adventures";
        public static final String NAME = "name";
        public static final String STARTINGPOINT = "startingpoint";
    }
    
    public static abstract class FeedLocations implements BaseColumns {
    	public static final String TABLE_NAME = "locations";
    	public static final String ADVENTURE_KEY = "advkey";
    	public static final String CLUE = "clue";
    	public static final String TOKEN = "token";
    	public static final String FOUND = "found";
    	public static final String FEEDBACKGOOD = "feedbackgood";
    	public static final String FEEDBACKBAD = "feedbackbad";
    	public static final String POINTS = "points";
    }
    
    public static abstract class FeedHints implements BaseColumns {
    	public static final String TABLE_NAME = "hints";
    	public static final String LOCATION_KEY = "lockey";
    	public static final String TEXT = "text";
    	public static final String USED = "used";
    	public static final String PTDEDUCT = "ptdeduct";
    }
}

