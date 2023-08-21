package cards;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hand {
	private List<Card> hand = new ArrayList<Card>();
	
	public Hand(int N, Deck deck) {
		for(int i = 0 ; i < N ; i++) {
			hand.add(deck.drawRandom());
		}
	}
	
	public int size() {
		return hand.size();
	}
	
	public void addCard(Card card) {
		hand.add(card);
	}
	
	public Card drawTop() {
		if(hand.size() == 0) {
			return new Card(0, 0);
		}
		else {
			return hand.remove(hand.size() - 1);
		}
	}
	
	public Card drawBottom() {
		if(hand.size() == 0) {
			return new Card(0,0);
		}
		else {
			return hand.remove(0);
		}
	}
	
	public Card drawRandom() {
		if(hand.size() == 0) {
			return new Card(0, 0);
		}
		else {
			Random random = new Random();
			return hand.remove(random.nextInt(0, hand.size()-1));
		}
	}
	
	
	public void returnTop(Card card) {
		hand.add(card);
	}
	
	public void returnBottom(Card card) {
		hand.add(0, card);
	}
	
	public void returnToPosition(int pos, Card card) {
		hand.add(pos, card);
	}
	
	
	public void sortBySuit() {
		hand.sort((a,b) -> a.getSuit()-b.getSuit());
	}
	
	public void sortByRank() {
		hand.sort((a,b) -> a.getRank()-b.getRank());
	}
	
	@Override
	public String toString() {
		return hand.toString();
	}
}
