package com.blackteam.tictactoextrem;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
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
	    Game game = new Game();
	    game.launch();
	    // Affichage de la nouvelle activité
	    // Masquer le menu principal (le détruire ?)
	}
	
	public void onClickButtonQuitter(View view) {
		_mHandler.postDelayed(_stop, 0);
	}

}
