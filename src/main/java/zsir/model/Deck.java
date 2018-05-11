package zsir.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import zsir.model.Card.Rank;
import zsir.model.Card.Suit;

/**
 * The Class Deck.
 * It represents 32 cards in the beginning.
 */
public class Deck {
	
	/** The game. */
	Game game;
	
	/**
	 * Gets the list of the cards.
	 *
	 * @return the cards
	 */
	public List<Card> getCards() {
		return cards;
	}

	/**
	 * Sets the cards.
	 *
	 * @param cards the new cards
	 */
	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}

	/** The cards. */
	private List<Card> cards;

	/**
	 * Instantiates a new deck.
	 *
	 * @param game the game object
	 */
	public Deck(Game game) {
		this.game = game;
		this.fillUp();
		this.shuffle();

	}

	/**
	 * Fills up the deck.
	 */
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

	/**
	 * Shuffles the deck.
	 */
	private void shuffle() {
		Collections.shuffle(cards);
	}

	/**
	 * Draws one card from the deck.
	 *
	 * @return the card
	 */
	public Card draw() {
		return cards.remove(cards.size() - 1);
	}

}
