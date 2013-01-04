package com.blackteam.tictactoextrem;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MenuPrincipal extends Activity {

	private Handler _mHandler = new Handler();

	// Quitte l'application
	private Runnable _stop = new Runnable() {
		public void run() {
			System.exit(RESULT_OK);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_principal);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_menu_principal, menu);
		return true;
	}

	public void onClickButtonJouerEnLocal(View view) {
		System.out.println("onClickButtonJouerEnLocal");
		MainActivity.game.launch();
		Intent intent = new Intent(MenuPrincipal.this, JeuActivity.class);
		startActivity(intent);
		finish();
	}

	public void onClickButtonJouerEnBluetooth(View view) {
		System.out.println("onClickButtonJouerEnBluetooth");
		
		if (MainActivity.mBluetoothAdapter != null) {
			if (!MainActivity.mBluetoothAdapter.isEnabled()) {
			    Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
			    startActivityForResult(enableBtIntent, 1);
			}
		}

	}

	public void onClickButtonQuitter(View view) {
		_mHandler.postDelayed(_stop, 0);
	}

}
