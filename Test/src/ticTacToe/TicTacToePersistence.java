package ticTacToe;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TicTacToePersistence {
	
	public static TicTacToe load(String fileName) throws InvalidMoveException{
		TicTacToe ticTacToe = new TicTacToe();
		
		try {
			List<String> moveCommands = Files.readAllLines(Paths.get(fileName));
			
			for(String command: moveCommands) {
				int player = (command.charAt(0) == 'X') ? -1 : 1;
				int row = Integer.valueOf(command.substring(1, 2));
				int col = Integer.valueOf(command.substring(2, 3));
				
				ticTacToe.makeMove(player, row, col);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return ticTacToe;
	}
}
