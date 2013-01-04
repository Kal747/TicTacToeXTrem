package com.blackteam.tictactoextrem;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
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
	//	onClickButtonMenuPrincipal

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
		}
		System.out.println(MainActivity.game);
	}
	
	 
	 
	   
	     
	

}
