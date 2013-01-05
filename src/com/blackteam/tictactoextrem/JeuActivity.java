package com.blackteam.tictactoextrem;

import java.util.HashMap;

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
		setContentView(R.layout.activity_jeu);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		
		// On raffraichit la vue
		Grid grid = MainActivity.game.getGrid();
		int [] idSquares = {
				R.id.square_0_0,
				R.id.square_1_0,
				R.id.square_2_0,
				R.id.square_0_1,
				R.id.square_1_1,
				R.id.square_2_1,
				R.id.square_0_2,
				R.id.square_1_2,
				R.id.square_2_2
		};
		
		int i=0, x=0, y=0;
		Button b;
		
		for (int id : idSquares) {
			if (grid.getCase(x, y) != 0) {
				b = (Button) findViewById(idSquares[i]);
				b.setBackgroundResource(backgroundOfPlayer(grid.getCase(x, y)));
			}
			i++;
			y = (x == 2) ? y+1 : y;
			x = (x+1) % 3;
		}		
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
	
	public int backgroundOfPlayer(int id) {
		switch (id) {
		case 1:
			return R.drawable.croixfini;
		case 2:
			return R.drawable.rondfini;
		default:
			return 0;
		}
	}

	public void onClickButtonSquare(View view) {
		System.out.println("onClickButtonMenuPrincipal");
		String tag= view.getTag().toString();
		int x = Integer.parseInt(""+tag.charAt(0));
		int y = Integer.parseInt(""+tag.charAt(1));
		// Si incorrect ou jeu fini : 0
		int jouerId = MainActivity.game.put(x, y);
		if(backgroundOfPlayer(jouerId) != 0) {
			((Button)view).setBackgroundResource(backgroundOfPlayer(jouerId));
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








