package com.blackteam.tictactoextrem;

import java.util.Arrays;

public class Grid {
	
	private int[][] grid = new int[3][3];
	
	public Grid() {
		super();
		
		// Initialisation à 0
		this.init();
	}

	public int[][] getGrid() {
		return grid;
	}

	public void setGrid(int[][] grid) {
		this.grid = grid;
	}
	
	// Met la grille à 0 (case vide)
	public void init() {
		for (int[] line : grid) {
			for (int square : line) {
				square = 0;
			}
		}
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
		string += "</Grid>\n";
		return string;
	}
	
}
