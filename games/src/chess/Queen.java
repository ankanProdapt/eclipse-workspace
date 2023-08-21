package chess;

public class Queen extends Piece {

	public Queen(String colour, int row, String column) {
		super("Queen", colour, row, column);
	}

	@Override
	public boolean canMoveTo(int newRow, String newCol, Piece[][] chessBoard) {

		Rook tempR = new Rook(colour, row, column);
		Bishop tempB = new Bishop(colour, row, column);

		return tempR.canMoveTo(newRow, newCol, chessBoard) || tempB.canMoveTo(newRow, newCol, chessBoard);

	}

}