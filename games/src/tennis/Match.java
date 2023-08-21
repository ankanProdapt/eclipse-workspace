package tennis;

public class Match {
	
	private static final int CUTOFF = 3;

	public static void updateMatch(Player winner, Player loser) {
		winner.setsWon++;

		// Reset the set
		winner.gamesWon = 0;
		loser.gamesWon = 0;
	}

	public static boolean isMatchOver(Player player1, Player player2) {
		return player1.setsWon >= CUTOFF || player2.setsWon >= CUTOFF;
	}

	public static Player getWinner(Player player1, Player player2) {
		if (player1.setsWon >= CUTOFF) {
			return player1;
		} else {
			return player2;
		}
	}
}
