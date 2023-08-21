package tennis;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws MatchOverException{
		Scanner sc = new Scanner(System.in);
		
		Tennis game = new Tennis("A", "B");
		
		System.out.println(game);
		for(int i = 0; i < 1000; i++) {
			System.out.println("Enter the name of the player (A/B) who won the serve: ");
			String serveWinner = sc.nextLine();
			game.update(serveWinner);
			System.out.println(game);
		}
		
		sc.close();
	}
}
