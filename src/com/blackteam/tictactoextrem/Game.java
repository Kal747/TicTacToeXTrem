package com.blackteam.tictactoextrem;

import java.util.Arrays;

public class Game {
	
	private Grid grid;
	private Player[] players = new Player[2];
	private boolean gameLaunched = false;
	
	public Game() {
		grid = new Grid();		
	}
	
	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}
	
	public void launch() {
		// Variables locales
		boolean stop = false;
		int lastWinner = 1; // Le gagnant ne commence pas
		int currentPlayer;
		
		// Ajout des joueurs
		players[0] = new Player(1, "Joueur 1");
		players[1] = new Player(2, "Joueur 2");
		
		// Affichage de la grille de jeu
		
		// Bouche infinie du jeu
		while (true) {
			
			// Initialisation de la grille
			grid.init();
			
			// Le joueur actuel est le perdant
			currentPlayer = (lastWinner == 0) ? 1 : 0;
			
			// Tant que la partir n'est pas terminée
			gameLaunched = true;
			while (!grid.isOver()) {
				System.out.println(this);
				
				// On recupère un evenement (onClick) : ATTENTION VERIFIER SI GAME LAUNCHED
			}
			gameLaunched = false;
			
			System.out.println(this);
			System.out.println("Partie terminée");
			
			stop = true;
			if (stop) {
				// On sort de la boucle
				break;
			}
		}
		
		// Masquer la grille de jeu
	}

	public String toString() {
		String string = grid.toString();
		string += "<Players>\n";
		string += Arrays.toString(players) + "\n";
		string += "</Players>\n";
		return string;
	}

}
