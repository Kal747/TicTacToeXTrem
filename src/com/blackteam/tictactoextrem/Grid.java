package com.blackteam.tictactoextrem;

import java.util.Arrays;

public class Grid {
	
	private int[][] grid = new int[3][3];
	private Player[] players = new Player[2];
	
	public Grid() {
		super();
		
		// Initialisation à 0
		for (int[] line : grid) {
			for (int square : line) {
				square = 0;
			}
		}
	}

	public int[][] getGrid() {
		return grid;
	}

	public void setGrid(int[][] grid) {
		this.grid = grid;
	}

	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}

	@Override
	public String toString() {
		String string = "<Grid>\n";
		for (int[] line : grid) {
			for (int square : line) {
				string += "" + square + " ";
			}
			string += "\n";
		}
		string += Arrays.toString(players) + "\n";
		string += "</Grid>\n";
		return string;
	}
	
}
