package com.example.zoomobile;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.zoomobile.FeedReaderContract.FeedAdventures;
import com.example.zoomobile.FeedReaderContract.FeedHints;
import com.example.zoomobile.FeedReaderContract.FeedLocations;

public class FeedReaderDbHelper extends SQLiteOpenHelper {
	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "QNAandPhotoPaths.db";

	private static final String TEXT_TYPE = " TEXT";
	private static final String INT_TYPE = " INTEGER";
	private static final String TOKEN_TYPE = " TEXT";
	private static final String BOOL_TYPE = " BIT";
	private static final String LOC_TYPE = " TEXT";
	private static final String COMMA_SEP = ",";
	
	private static final String SQL_CREATE_ADVENTURES =
			"CREATE TABLE " + FeedAdventures.TABLE_NAME + " (" +
			FeedAdventures._ID + " INTEGER PRIMARY KEY," +
			FeedAdventures.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
			FeedAdventures.COLUMN_NAME_STARTINGPOINT + LOC_TYPE +
			" )";
	private static final String SQL_CREATE_LOCATIONS =
	    "CREATE TABLE " + FeedLocations.TABLE_NAME + " (" +
	    FeedLocations._ID + " INTEGER PRIMARY KEY," +
	    FeedAdventures._ID + " INTEGER FOREIGN KEY REFERENCES " +
	    	FeedAdventures.TABLE_NAME + "(" + FeedAdventures._ID + ")" + COMMA_SEP +
	    FeedLocations.COLUMN_NAME_CLUE + TEXT_TYPE + COMMA_SEP +
	    FeedLocations.COLUMN_NAME_TOKEN + TOKEN_TYPE + COMMA_SEP +
	    FeedLocations.COLUMN_NAME_FOUND + BOOL_TYPE + COMMA_SEP +
	    FeedLocations.COLUMN_NAME_FEEDBACKGOOD + TEXT_TYPE + COMMA_SEP +
	    FeedLocations.COLUMN_NAME_FEEDBACKBAD + TEXT_TYPE + COMMA_SEP +
	    FeedLocations.COLUMN_NAME_POINTS + INT_TYPE +
	    " )";
	private static final String SQL_CREATE_HINTS =
		"CREATE TABLE " + FeedHints.TABLE_NAME + " (" +
		FeedHints._ID + " INTEGER PRIMARY KEY," +
		FeedHints.COLUMN_NAME_TEXT + TEXT_TYPE + COMMA_SEP +
		FeedHints.COLUMN_NAME_USED + BOOL_TYPE + COMMA_SEP +
		FeedHints.COLUMN_NAME_PTDEDUCT + INT_TYPE +
		" )";
	
	private static final String SQL_DELETE_ADVENTURES =
		    "DROP TABLE IF EXISTS " + FeedAdventures.TABLE_NAME;
	private static final String SQL_DELETE_LOCATIONS =
		    "DROP TABLE IF EXISTS " + FeedLocations.TABLE_NAME;
	private static final String SQL_DELETE_HINTS =
		    "DROP TABLE IF EXISTS " + FeedHints.TABLE_NAME;
	
	public FeedReaderDbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(SQL_CREATE_ADVENTURES);
		db.execSQL(SQL_CREATE_LOCATIONS);
		db.execSQL(SQL_CREATE_HINTS);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(SQL_DELETE_ADVENTURES);
		db.execSQL(SQL_DELETE_LOCATIONS);
		db.execSQL(SQL_DELETE_HINTS);
		onCreate(db);
	}
	
	public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}
