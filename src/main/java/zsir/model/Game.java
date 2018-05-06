package zsir.model;

import zsir.model.Deck.Card;

public class Game {
	
	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	private Deck deck;
	
	public Game() {
		System.out.println("In Game()");
		deck = new Deck();
		
	}

}
