package trump;
import java.util.*;

public class Tester {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Category matches = new Matches();
		Category highscore = new Highscore();
		Category runs = new Runs();
		Category hundreds = new Hundreds();
		Category rank = new Rank();
		
		
		
		// Creating a deck of Trump Cards
		Deck deck = new Deck();
		
		System.out.print("Enter number of cards: ");
		int numberOfCards = sc.nextInt();
		
		for(int i = 0; i < numberOfCards; i++) {
			
			System.out.print("Enter Player " + (i + 1) + " name: ");
			Card card = new Card(sc.next());
			
			System.out.print("Matches: ");
			card.addCategory(matches, sc.nextInt());
			
			System.out.print("Highscore: ");
			card.addCategory(highscore, sc.nextInt());
			
			System.out.print("runs: ");
			card.addCategory(runs, sc.nextInt());
			
			System.out.print("Hundreds: ");
			card.addCategory(hundreds, sc.nextInt());
			
			System.out.print("Rank: ");
			card.addCategory(rank, sc.nextInt());
			
			deck.addCard(card);
		}
		
		System.out.println(deck);
		
		
		
		
		
		deck.shuffle();
		Hand myHand = new Hand(deck, numberOfCards/2);
		Hand pcHand = new Hand(deck, numberOfCards/2);
		
		int turn = 0;
		
		while(true) {
			
			if(myHand.getSize() == 0) {
				System.out.println("\nPC Won :(");
				break;
			}
			if(pcHand.getSize() == 0) {
				System.out.println("\nYou Won!!!");
				break;
			}
			
			
			System.out.println("\n\n\nRound" + (turn + 1));
			
			Card myCard = myHand.drawCard();
			Card pcCard = pcHand.drawCard();
			
			int categoryId;
			Category chosenCategory;
			
			System.out.println("Your Card: " + myCard);
			
			// Your turn
			if(turn % 2 == 0) {
				System.out.println("Your Turn\nSelect a category: \n1. Matches \n2. Highscore \n3. Runs \n4. Hundreds \n5. Rank");
				categoryId = sc.nextInt();
			}
			
			// PC's turn
			else {
				System.out.println("Computer's Turn");
				Random r = new Random();
				categoryId = r.nextInt(1, 6);
			}
			
			switch(categoryId) {
			case 1:
				chosenCategory = matches;
				break;
			case 2:
				chosenCategory = highscore;
				break;
			case 3:
				chosenCategory = runs;
				break;
			case 4:
				chosenCategory = hundreds;
				break;
			case 5:
				chosenCategory = rank;
				break;
			default:
				chosenCategory = rank;
			}
			
			System.out.println("Chosen Category: " + chosenCategory + "\n");
			System.out.println("Your Card: " + myCard);
			System.out.println("PC's Card: " + pcCard);
			
			
			
			
			int result = myCard.trumps(pcCard, chosenCategory);
			
			if(result == -1) {
				System.out.println("PC won the round!");
				pcHand.addCard(pcCard);
				pcHand.addCard(myCard);
			}
			else if(result == 1) {
				System.out.println("You have won the round!");
				myHand.addCard(pcCard);
				myHand.addCard(myCard);
			}
			else {
				System.out.println("Round ended as draw!");
				myHand.addCard(pcCard);
				pcHand.addCard(myCard);
			}
			
			turn += 1;
		}
		
		sc.close();
	}
}
