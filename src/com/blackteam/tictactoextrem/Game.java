package com.blackteam.tictactoextrem;

import java.util.Arrays;

public class Game {
	
	private Grid grid;
	private Player[] players = new Player[2];
	
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

	public String toString() {
		String string = grid.toString();
		string += "<Players>\n";
		string += Arrays.toString(players) + "\n";
		string += "</Players>\n";
		return string;
	}

}
