package com.blackteam.tictactoextrem;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class JeuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jeu);

		this.refreshGrid();
		this.refreshStatus();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_jeu, menu);
		return true;
	}

	public void onClickButtonMenuPrincipal(View view) {
		Intent intent = new Intent(JeuActivity.this, MenuPrincipal.class);
		startActivity(intent);
		finish();
	}

	public void refreshGrid() {
		Button b;
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

		// On rafraichit la vue
		int x=0, y=0;
		for (int i = 0 ; i < idSquares.length ; i++) {
			b = (Button) findViewById(idSquares[i]);
			switch (grid.getCase(x, y)) {
			case 1:
				b.setBackgroundResource(R.drawable.croixfini);
				break;
			case 2:
				b.setBackgroundResource(R.drawable.rondfini);
				break;
			default:
				// Image par defaut : rien
			}
			y = (x == 2) ? y+1 : y;
			x = (x+1) % 3;
		}		
	}

	public void refreshStatus() {
		int winner = MainActivity.game.winner();
		TextView status = (TextView) findViewById(R.id.textView1);
		if (winner == -1) {
			String nickname_actuel = MainActivity.game.getPlayers()[MainActivity.game.getCurrentPlayer()].getNickName();
			status.setText(nickname_actuel + " à vous de jouer");
		} else {
			status.setText("Partie terminée");
		}
	}

	public void onClickButtonSquare(View view) {
		String tag = view.getTag().toString();
		int x = Integer.parseInt(""+tag.charAt(0));
		int y = Integer.parseInt(""+tag.charAt(1));
		int jouerId = MainActivity.game.put(x, y);

		// Ajout de l'image ou vibration
		if (jouerId != 0) {
			refreshGrid();
		} else {
			MainActivity.vi.vibrate(500);
		}
		refreshStatus();

		int winner = MainActivity.game.winner();
		if (winner != -1) {	
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
			alertDialogBuilder.setTitle("Partie terminée");
			String message = "";
			switch (winner) {
			case 0:
				// Match nul
				message = "Match nul";
				break;
			case 1:
				// Le joueur 1 est gagnant
				message = MainActivity.game.getPlayers()[0].getNickName() + " gagne !";
				break;
			case 2:
				// Le joueur 2 est gagnant
				message = MainActivity.game.getPlayers()[1].getNickName() + " gagne !";
				break;
			default:
				// Partie non terminée
			}
			alertDialogBuilder.setMessage(message)
			.setCancelable(false)
			.setPositiveButton("Menu principal", new DialogInterface.OnClickListener() {
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

			AlertDialog alertDialog = alertDialogBuilder.create();
			alertDialog.show();
		}
	}
}








