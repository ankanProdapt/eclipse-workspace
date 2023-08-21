package tennis;

public class Game {

	private static final int MIN_SERVES_TO_WIN = 4;
	private static final int MIN_MARGIN = 2;
	private static final String[] scores = { "Love", "15", "30", "40", "Adv" };

	public static void updateGame(Player winner, Player loser) {
		winner.servesWon++;
		
		if ((winner.servesWon >= MIN_SERVES_TO_WIN) && (winner.servesWon - loser.servesWon >= MIN_MARGIN)) {
			Set.updateSet(winner, loser);
		}
		else {
			if (winner.servesWon == loser.servesWon && winner.servesWon == MIN_SERVES_TO_WIN) {
				winner.servesWon--;
				loser.servesWon--;
				winner.scoreString = scores[winner.servesWon];
				loser.scoreString = scores[loser.servesWon];
			} else {
				winner.scoreString = scores[winner.servesWon];
			}
		}
	}
}
