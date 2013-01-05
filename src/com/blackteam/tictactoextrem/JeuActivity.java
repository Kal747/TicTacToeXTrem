package com.blackteam.tictactoextrem;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class JeuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//onSaveInstanceState(savedInstanceState);

		setContentView(R.layout.activity_jeu);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_jeu, menu);
		return true;
	}
	 

	public void onClickButtonMenuPrincipal(View view) {
		System.out.println("onClickButtonMenuPrincipal");
		Intent intent = new Intent(JeuActivity.this, MenuPrincipal.class);
		startActivity(intent);
		finish();

	}

	public void onClickButtonSquare(View view) {
		System.out.println("onClickButtonMenuPrincipal");
		String tag= view.getTag().toString();
		int x = Integer.parseInt(""+tag.charAt(0));
		int y = Integer.parseInt(""+tag.charAt(1));
		// Si incorrect ou jeu fini : 0
		int jouerId = MainActivity.game.put(x, y);
		if(jouerId != 0) {

			if(jouerId==1)
				((Button)view).setBackgroundResource(R.drawable.  croixfini);
			else 
				((Button)view).setBackgroundResource(R.drawable.  rondfini);
		} else {
			MainActivity.vi.vibrate(500);
		}
		System.out.println(MainActivity.game);

		if(    MainActivity.game.winner()==1 ||  MainActivity.game.winner()==2 ){
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
			// set title
			alertDialogBuilder.setTitle("Your Title");
			// set dialog message
			alertDialogBuilder
			.setMessage("Joueur "+MainActivity.game.winner() + " a gagné")
			.setCancelable(false)
			.setPositiveButton("Menu principal",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int id) {
					Intent intent = new Intent(JeuActivity.this, MenuPrincipal.class);
					startActivity(intent);
					finish();
				}
			})
			.setNegativeButton("Rejouer",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int id) {
					MainActivity.game.launch();
					Intent intent = new Intent(JeuActivity.this, JeuActivity.class);
					startActivity(intent);
					finish();
				}
			});
			// create alert dialog
			AlertDialog alertDialog = alertDialogBuilder.create();
			// show it
			alertDialog.show();
		}
	}
}








