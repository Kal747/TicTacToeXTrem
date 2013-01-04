package com.blackteam.tictactoextrem;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.content.Intent;

public class SplashActivity extends Activity {

	private Handler mHandler = new Handler();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		mHandler = new Handler();
		mHandler.postDelayed(mUpdateTimeTask, 2000);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_splash, menu);
		return true;
	}
	
	private Runnable mUpdateTimeTask = new Runnable() {
		  public void run() {
			 Intent intent = new Intent(SplashActivity.this, MenuPrincipal.class);
			startActivity(intent);
		     finish();
		  }
		};

}
