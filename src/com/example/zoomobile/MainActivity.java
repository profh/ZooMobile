package com.example.zoomobile;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;

import com.example.zoomobile.FeedReaderContract.FeedAdventures;
import com.example.zoomobile.FeedReaderContract.FeedHints;
import com.example.zoomobile.FeedReaderContract.FeedLocations;

public class MainActivity extends Activity {

	SQLiteDatabase db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		FeedReaderDbHelper mDbHelper = new FeedReaderDbHelper(getBaseContext());
		
		db = mDbHelper.getWritableDatabase();
		propagate(db);
		
		setContentView(R.layout.activity_main);
		
		//propagate();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void propagate(SQLiteDatabase db) {
		// Create new maps of values, where column names are the keys
		int numAs = 1;
		int numLs = 2;
		int numHs = 4;
		ContentValues Avals[] = new ContentValues[numAs];
		ContentValues Lvals[] = new ContentValues[numLs];
		ContentValues Hvals[] = new ContentValues[numHs];
		
		Avals[0] = new ContentValues();
		Avals[0].put(FeedAdventures.NAME, "Pittsburgh Zoo");
		Avals[0].put(FeedAdventures.STARTINGPOINT, "LOC");

		Lvals[0] = new ContentValues();
		Lvals[0].put(FeedLocations.CLUE, "I'm the tallest land animal.");
		Lvals[0].put(FeedLocations.FEEDBACKBAD, "How'd you pass Kindergarten? Try again.");
		Lvals[0].put(FeedLocations.FEEDBACKGOOD, "Very good! Giraffes are also notorious for insurance fraud.");
		Lvals[0].put(FeedLocations.FOUND, false);
		Lvals[0].put(FeedLocations.POINTS, 5);
		Lvals[0].put(FeedLocations.TOKEN, "ABCDE");
		Lvals[0].put(FeedAdventures._ID, 0);
		
		Lvals[1] = new ContentValues();
		Lvals[1].put(FeedLocations.ADVENTURE_KEY, 0);
		Lvals[1].put(FeedLocations.CLUE, "I'm the largest land animal.");
		Lvals[1].put(FeedLocations.FEEDBACKBAD, "This is pathetic. Try again.");
		Lvals[1].put(FeedLocations.FEEDBACKGOOD, "Very good! Elephants never forget the wonderful life they knew before captivity.");
		Lvals[1].put(FeedLocations.FOUND, false);
		Lvals[1].put(FeedLocations.POINTS, 10);
		Lvals[1].put(FeedLocations.TOKEN, "FGHIJ");
		
		Hvals[0] = new ContentValues();
		Hvals[0].put(FeedHints.TEXT, "Keep your eyes upward.");
		Hvals[0].put(FeedHints.LOCATION_KEY, 0);
		Hvals[0].put(FeedHints.USED, false);
		Hvals[0].put(FeedHints.PTDEDUCT, 1);

		Hvals[1] = new ContentValues();
		Hvals[1].put(FeedHints.TEXT, "Starts with a 'G.'");
		Hvals[1].put(FeedHints.LOCATION_KEY, 0);
		Hvals[1].put(FeedHints.USED, false);
		Hvals[1].put(FeedHints.PTDEDUCT, 2);
		
		Hvals[2] = new ContentValues();
		Hvals[2].put(FeedHints.TEXT, "Has tusks.");
		Hvals[2].put(FeedHints.LOCATION_KEY, 1);
		Hvals[2].put(FeedHints.USED, false);
		Hvals[2].put(FeedHints.PTDEDUCT, 3);
		
		Hvals[3] = new ContentValues();
		Hvals[3].put(FeedHints.TEXT, "Starts with an 'E.'");
		Hvals[3].put(FeedHints.LOCATION_KEY, 1);
		Hvals[3].put(FeedHints.USED, false);
		Hvals[3].put(FeedHints.PTDEDUCT, 4);
		
		// Clear all existing rows
		db.delete(FeedAdventures.TABLE_NAME, null, null);
		db.delete(FeedLocations.TABLE_NAME, null, null);
		db.delete(FeedHints.TABLE_NAME, null, null);
		for(int i = 0; i < numAs; i++)
			db.insert(FeedAdventures.TABLE_NAME, null, Avals[i]);
		for(int i = 0; i < numLs; i++)
			db.insert(FeedLocations.TABLE_NAME, null, Lvals[i]);
		for(int i = 0; i < numHs; i++)
			db.insert(FeedHints.TABLE_NAME, null, Hvals[i]);
	}

}
