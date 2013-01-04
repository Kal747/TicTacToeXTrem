package com.blackteam.tictactoextrem;

import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;

import android.view.Menu;

public class MainActivity extends Activity {
 
	
	private Handler mHandler = new Handler();
	
	static Vibrator vi;
	static BluetoothAdapter mBluetoothAdapter;
 
	public static Game game;

 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		MainActivity.vi = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		MainActivity.mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		MainActivity.game = new Game();
		mHandler = new Handler();
		mHandler.postDelayed(mUpdateTimeTask, 2000);
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
