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
		
		TextView status = (TextView) findViewById(R.id.textView1);
		String nickname_actuel = MainActivity.game.getPlayers()[MainActivity.game.getCurrentPlayer()].getNickName();
		status.setText(nickname_actuel);
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
		String tag = view.getTag().toString();
		int x = Integer.parseInt(""+tag.charAt(0));
		int y = Integer.parseInt(""+tag.charAt(1));
		int jouerId = MainActivity.game.put(x, y);

		// Ajout de l'image ou vibration
		if (jouerId != 0) {
			((Button)view).setBackgroundResource(backgroundOfPlayer(jouerId));
		} else {
			MainActivity.vi.vibrate(500);
		}

		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
		alertDialogBuilder.setTitle("Partie terminée");
		String message = "";

		int winner = MainActivity.game.winner();
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
			TextView status = (TextView) findViewById(R.id.textView1);
			String nickname_actuel = MainActivity.game.getPlayers()[MainActivity.game.getCurrentPlayer()].getNickName();
			status.setText(nickname_actuel + " à vous de jouer");
		}

		if (winner != -1) {		
			TextView status = (TextView) findViewById(R.id.textView1);
			status.setText("Partie terminée");
			
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








