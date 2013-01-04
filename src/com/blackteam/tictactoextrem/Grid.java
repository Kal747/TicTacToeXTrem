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

	public boolean hasWinnerLine() {
		return
				((this.grid[0][0] != 0) && (this.grid[0][0] == this.grid[0][1] && this.grid[0][1] == this.grid[0][2])) ||
				((this.grid[1][0] != 0) && (this.grid[1][0] == this.grid[1][1] && this.grid[1][1] == this.grid[1][2])) ||
				((this.grid[2][0] != 0) && (this.grid[2][0] == this.grid[2][1] && this.grid[2][1] == this.grid[2][2])) 
				;
	}

	public boolean hasWinnerColumn() {
		return
				((this.grid[0][0] != 0) && (this.grid[0][0] == this.grid[1][0] && this.grid[1][0] == this.grid[2][0])) ||
				((this.grid[0][1] != 0) && (this.grid[0][1] == this.grid[1][1] && this.grid[1][1] == this.grid[2][1])) ||
				((this.grid[0][2] != 0) && (this.grid[0][2] == this.grid[1][2] && this.grid[1][2] == this.grid[2][2])) 
				;
	}

	public boolean hasWinnerDiagonal() {
		return (this.grid[1][1] != 0) ?
				(this.grid[0][0] == this.grid[1][1] && this.grid[1][1] == this.grid[2][2]) ||
				(this.grid[0][2] == this.grid[1][1] && this.grid[1][1] == this.grid[2][0])
				: false;
	}

	public boolean isOver() {
		return (this.hasWinnerLine() || this.hasWinnerColumn() || this.hasWinnerDiagonal());
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
