package com.example.sample001activity;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.i("ACTIVITY","onCreate()");
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		
		Log.i("ACTIVITY","onStart()");
		
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		Log.i("ACTIVITY","onResume()");
		
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		
		Log.i("ACTIVITY","onPause()");
		
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		
		Log.i("ACTIVITY","onStop()");
		
	}
	
	@Override
	protected void onRestart() {
		super.onRestart();
		
		Log.i("ACTIVITY","onRestart()");
		
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		
		Log.i("ACTIVITY","onDestroy()");
		
	}
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.activity_main, menu);
//		return true;
//	}

}
