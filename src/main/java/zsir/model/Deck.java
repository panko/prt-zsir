package zsir.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import zsir.model.Card.Rank;
import zsir.model.Card.Suit;

public class Deck {
	
	Game game;
	public List<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}

	public List<Card> cards;

	public Deck(Game game) {
		this.game = game;
		this.fillUp();
		this.shuffle();

	}

	private void fillUp() {
		cards = new ArrayList<Card>();
		System.out.println("In Deck().");
		for (Suit suit : Card.Suit.values()) {
			for (Rank rank : Card.Rank.values()) {
				Card c = new Card(suit, rank, game);
				c.setLayoutY(225);
				cards.add(c);
			}
		}
		System.out.println("Deck - fillUp() - " + cards);
	}

	private void shuffle() {
		Collections.shuffle(cards);
	}

	public Card draw() {
		return cards.remove(cards.size() - 1);
	}

}
