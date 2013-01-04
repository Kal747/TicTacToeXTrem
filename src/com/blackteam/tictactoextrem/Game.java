package com.blackteam.tictactoextrem;

import java.util.Arrays;

public class Game {
	
	private Grid grid;
	private Player[] players = new Player[2];
	private boolean gameLaunched = false;
	private int currentPlayer;
	private int lastWinner = 1;
	
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
	
	public boolean isGameLaunched() {
		return gameLaunched;
	}

	public void setGameLaunched(boolean gameLaunched) {
		this.gameLaunched = gameLaunched;
	}

	public int getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public void launch() {
		// Ajout des joueurs
		players[0] = new Player(1, "Joueur 1");
		players[1] = new Player(2, "Joueur 2");
		
		// Initialisation de la grille
		grid.init();
			
		// Le joueur actuel est le perdant
		currentPlayer = (lastWinner == 0) ? 1 : 0;
			
		gameLaunched = true;
	}
	
	public int put(int x, int y) {
		if (this.gameLaunched) {
			int player = players[currentPlayer].getId();
			if (this.grid.put(player, x, y)) {
				this.currentPlayer = (this.currentPlayer + 1) % 2;
				if (this.grid.isOver()) {
					this.gameLaunched = false;
				}
				return player;
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}

	public String toString() {
		String string = grid.toString();
		string += "<Players>\n";
		string += Arrays.toString(players) + "\n";
		string += "</Players>\n";
		string += "Current Player : " + this.currentPlayer + "\n";
		string += "Game Launched : " + this.gameLaunched + "\n";
		return string;
	}

}
