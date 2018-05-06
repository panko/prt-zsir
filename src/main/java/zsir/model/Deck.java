package zsir.model;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import zsir.model.Deck.Card.Rank;
import zsir.model.Deck.Card.Suit;

public class Deck {
	public static ArrayList<Card> getCards() {
		return cards;
	}
	public static void setCards(ArrayList<Card> cards) {
		Deck.cards = cards;
	}
	public static ArrayList<Card> cards;
	
	public static class Card  extends ImageView {
		
		
		@Override
		public String toString() {
			return "Card [suit=" + suit + ", rank=" + rank + "]";
		}
		public static enum Suit {
			HEARTS, BELLS, ACORNS, LEAVES
		}
		public static enum Rank {
			SEVEN, EIGHT, NINE, TEN, UNDER, OVER, KING, ACE
		}
		public Card(Suit s, Rank r) {
			this.rank = r;
			this.suit = s;
			super.setImage(new Image("/pictures/Card_back_12.png"));
		}
		
		public Suit suit;
		public Rank rank;
	}
	public Deck() {
		cards = new ArrayList<Deck.Card>();
		System.out.println("In Deck().");
		for(Suit suit: Card.Suit.values()) {
			System.out.println(suit);
			for(Rank rank: Card.Rank.values()) {
				cards.add(new Card(suit, rank));
			}
		}
		System.out.println(cards); 
		
	}
	

}
