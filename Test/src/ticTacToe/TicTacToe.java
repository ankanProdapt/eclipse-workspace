package ticTacToe;

public class TicTacToe {
	private int[][] board = new int[3][3] ;    //  {-1, 0, 1} => {X, Empty, O}
	private final int SIZE = 3;
	
	private int moveNumber;
	private int prevPlayer;
	
	public TicTacToe() {
		prevPlayer = 0;
		moveNumber = 0;
		
		for(int row = 0; row < SIZE; row++) {
			for(int col = 0; col < SIZE; col++) {
				board[row][col] = 0;
			}
		}
	}
	
	public void makeMove(int player, int row, int col) throws InvalidMoveException{
		moveNumber++;
		
		if((row >= 0 && row < 3) && (col >= 0 && col < 3) &&
		  (board[row][col] == 0) && (prevPlayer != player)) {
			board[row][col] = player;
			prevPlayer = player;
		}
		else {
			throw new InvalidMoveException(String.format("You have made an INVALID move! (Move Number: {%d})", moveNumber));
		}
	}
	
	
	public int checkRows() {
		// check rows for win
		for (int row = 0; row < SIZE; row++) {
			if (board[row][0] != 0 && board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
				return board[row][0];
		    }
		}
		
		return 0;
	}
	
	public int checkCols() {
		// check columns for win
		for (int col = 0; col < SIZE; col++) {
			if (board[0][col] != 0 && board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
				return board[0][col];
			}
		}
		
		return 0;
	}
	
	public int checkDiagonals() {
		if (board[0][0] != 0 && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
			return board[0][0];
		}
		if (board[0][2] != 0 && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
			return board[0][2];
		}
		
		return 0;
	}
	
	
	public boolean isFull() {
		for(int row = 0; row < SIZE; row++) {
			for(int col = 0; col < SIZE; col++) {
				if(board[row][col] == 0) return false;
			}
		}
		
		return true;
	}
	
	public String decide() {
		if(checkRows() == -1 || checkCols() == -1 || checkDiagonals() == -1) {
			return "X";
		}
		if(checkRows() == 1 || checkCols() == 1 || checkDiagonals() == 1) {
			return "O";
		}
		
		if(isFull()) {
			return "Draw";
		}
		
		return "Ongoing";
	}

	
	
	@Override
	public String toString() {
		String view = "";
		
		for(int row = 0; row < SIZE; row++) {
			for(int col = 0; col < SIZE; col++) {
				if(board[row][col] == -1) {
					view += "X";
				}
				else if(board[row][col] == 1) {
					view += "O";
				}
				else {
					view += "_";
				}
				
				if(col != SIZE - 1) {
					view += "|";
				}
			}
			
			view += "\n";
		}
		
		return view;
	}
	
	
}
