package com.blackteam.tictactoextrem;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;

import android.view.Menu;

public class MainActivity extends Activity {

	 
	private Handler mHandler = new Handler();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mHandler = new Handler();
		mHandler.postDelayed(mUpdateTimeTask, 5000);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	private Runnable mUpdateTimeTask = new Runnable() {
		  public void run() {
			 Intent intent = new Intent(MainActivity.this, MenuPrincipal.class);
			 startActivity(intent);
		     finish();
		  }
	};
}
