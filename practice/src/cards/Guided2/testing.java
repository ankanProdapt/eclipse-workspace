package cards;
import java.util.*;

public class testing {
	public static void main(String[] args) {
		Card card = new Card(5, 2);
		System.out.println(card);
		
		Deck cards = new Deck();
		cards.shuffle();
		System.out.println(cards.drawTop());
		
		Hand hand1 = new Hand(10, cards);
		
		hand1.sortBySuit();
		System.out.println(hand1);
		
		hand1.sortByRank();
		System.out.println(hand1);
	}
}
