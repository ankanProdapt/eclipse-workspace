package chess;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException, InvalidMoveException{
		ChessBoard c = new ChessBoard();
		System.out.println(c);
		
		Path p = Paths.get("pgn1.txt");
		List<String> lines = Files.readAllLines(p);
		int moveNumber = 1;
		
		for(String line: lines) {
			System.out.println("Move Number: " + moveNumber);
			moveNumber++;
			String[] moves = line.split(" ");
			System.out.println("Command: " + moves[0]);
			c.executeMove("white", moves[0]);
			System.out.println(c + "\n");
			
			System.out.println("Command: " + moves[1]);
			c.executeMove("black", moves[1]);
			System.out.println(c);
		}
	}
}
