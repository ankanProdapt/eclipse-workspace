package ticTacToe;

public class Main {
	public static void main(String[] args) {
		String[] fileNames = {"draw.txt", "invalid.txt", "ongoing.txt", "oWins.txt", "xWins.txt"};
		
		int gameNumber = 0;
		
		for(String fileName: fileNames) {
			gameNumber++;
			System.out.println("Game " + gameNumber + ":\n");
			
			
			try {
				TicTacToe ticTacToe = TicTacToePersistence.load(fileName);
				System.out.println(ticTacToe);
				System.out.println("Result: " + ticTacToe.decide());
			} catch (InvalidMoveException e) {
				e.printStackTrace();
			}
			
			System.out.println("\n\n");
		}
	}
}