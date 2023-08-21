package chess;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ChessTester {
	
	public ChessBoard c = new ChessBoard();
	
	@BeforeEach
	public void setUp() throws Exception{
		Path p = Paths.get("pgn1.txt");
		List<String> lines = Files.readAllLines(p);
		
		for(String line: lines) {
			String[] moves = line.split(" ");
			c.executeMove("white", moves[0]);
			c.executeMove("black", moves[1]);
		}
	}
	
	@Test
	public void testPawnMove() throws Exception{
		String command = "c2-c4";
		c.executeMove("white", command);
		assertTrue(c.chessBoard[3][2].name.equals("Pawn"));
	}
	
	@Test
	public void testKingMove() throws Exception{
		String command = "Ke1-Kd1";
		c.executeMove("white", command);
		assertTrue(c.chessBoard[0][3].name.equals("King"));
		
		command = "Ke8-Kd8";
		c.executeMove("black", command);
		assertTrue(c.chessBoard[7][3].name.equals("King"));
		
	}
	
	@Test
	public void testException(){
		String command = "e4-e5";
		assertThrows(InvalidMoveException.class, () -> c.executeMove("white", command));
	}

}
