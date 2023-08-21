package tennis;

public class Player {
	public String name;
	public int servesWon;
	public int gamesWon;
	public int setsWon;
	public String scoreString;

	public Player(String name) {
		this.name = name;
		servesWon = 0;
		gamesWon = 0;
		setsWon = 0;
		scoreString = "LOVE";
	}

	public void wonServeAgainst(Player other) {
		Game.updateGame(this, other);
	}
	
}