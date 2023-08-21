package chess;

public class King extends Piece {
    public King(String colour, int row, String column) {
        super("King", colour, row, column);
    }

    @Override
    public boolean canMoveTo(int newRow, String newCol, Piece[][] chessBoard) {
        int currentRow = row;
        String currentCol = column;
        int currentColIndex = getCol(currentCol);
        int newColIndex = getCol(newCol);

        // Check if the new position is within the board bounds
        if (newRow <= 0 || newRow > 8) {
            return false;
        }

        int rowDistance = Math.abs(newRow - currentRow);
        int colDistance = Math.abs(newColIndex - currentColIndex);
        
        // A king can move one square in any direction: horizontally, vertically, or diagonally
        return (rowDistance <= 1 && colDistance <= 1) && (chessBoard[newRow - 1][newColIndex] == null);
    }

	public static boolean isUnderCheck(Piece king, Piece[][] chessBoard) {
		for(int i = 0; i < 8; i++) {
			for(Piece p: chessBoard[i]) {
				if(p != null && p.colour != king.colour) {
					if(p.canCapturePieceAt(king.row, king.column, chessBoard)) {
						return true;
					}
				}
			}
		}
		return false;
	}
}