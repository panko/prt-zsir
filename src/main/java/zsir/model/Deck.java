package zsir.model;

import java.util.ArrayList;

import zsir.model.Deck.Card.Rank;
import zsir.model.Deck.Card.Suit;

public class Deck {
	public static ArrayList<Card> cards;
	
	static class Card {
		public  enum Suit {
			HEARTS, BELLS, ACORNS, LEAVES
		}
		public enum Rank {
			SEVEN, EIGHT, NINE, TEN, UNDER, OVER, KING, ACE
		}
		public Card(Suit s, Rank r) {
			this.rank = r;
			this.suit = s;
		}
		
		public Suit suit;
		public Rank rank;
	}
	public Deck() {
		System.out.println("In Deck().");
		for(Suit suit: Card.Suit.values()) {
			System.out.println(suit);
			for(Rank rank: Card.Rank.values()) {
				cards.add(new Card(suit, rank));
			}
		}
		
	}
	

}
