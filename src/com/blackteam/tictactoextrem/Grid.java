package com.blackteam.tictactoextrem;

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
		for (int i = 0 ; i <= 2 ; i++) {
			for (int j = 0 ; j <= 2 ; j++) {
				this.grid[i][j] = 0;
			}
		}
	}

	public int getCase(int x, int y) {
		return this.grid[x][y];
	}

	public int winner() {
		if (this.hasWinnerLine()) {
			if ((this.grid[0][0] != 0) && (this.grid[0][0] == this.grid[0][1] && this.grid[0][1] == this.grid[0][2])) {
				return this.grid[0][0];
			} else if ((this.grid[1][0] != 0) && (this.grid[1][0] == this.grid[1][1] && this.grid[1][1] == this.grid[1][2])) {
				return this.grid[1][0];
			} else {
				return this.grid[2][0];
			}
		} else if (this.hasWinnerColumn()) {
			if ((this.grid[0][0] != 0) && (this.grid[0][0] == this.grid[1][0] && this.grid[1][0] == this.grid[2][0])) {
				return this.grid[0][0];
			} else if ((this.grid[0][1] != 0) && (this.grid[0][1] == this.grid[1][1] && this.grid[1][1] == this.grid[2][1])) {
				return this.grid[0][1];
			} else {
				return this.grid[0][2];
			}
		} else if (this.hasWinnerDiagonal()) {
			return this.grid[1][1];
		} else {
			return 0;
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
		return (this.hasWinnerLine() || this.hasWinnerColumn() || this.hasWinnerDiagonal() || this.isCompleted());
	}

	public boolean isCompleted() {
		for(int i=0 ; i < 3 ; i++){
			for(int j=0 ; j < 3 ; j++){
				if(this.grid[i][j] == 0){	
					return false;
				}
			}
		}
		return true;
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

	public boolean isempty(int x, int y) {
		return this.grid[x][y] == 0;
	}

	public boolean put(int id, int x, int y) {
		if (this.isempty(x, y)) {
			this.grid[x][y] = id;
			return true;
		} else {
			return false;
		}
	}

}
