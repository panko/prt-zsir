package zsir.model.player;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zsir.model.Card;
import zsir.model.Deck;
import zsir.model.Game;

/**
 * The Human Class.
 */
public class Human implements Player {
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Human [name=" + name + ", cards=" + cards + ", history=" + history + ", game=" + game + "]";
	}

	/** The logger. */
	private static Logger logger = LoggerFactory.getLogger(Human.class);
	
	/** The name. */
	String name;
	
	/** The cards. */
	private List<Card> cards;
	
	/** The history of cards. */
	private List<Card> history;
	
	/** The game object. */
	Game game;
	
	/**
	 * Instantiates a new human.
	 *
	 * @param game the game
	 */
	public Human(Game game) {
		cards = new ArrayList<Card>();
		history = new ArrayList<Card>();
		this.game = game;
	}
	

	/* (non-Javadoc)
	 * @see zsir.model.player.Player#call(zsir.model.Card)
	 */
	@Override
	public Card call(Card c) {
		cards.remove(c);
		return c;
	}
	
	/* (non-Javadoc)
	 * @see zsir.model.player.Player#pass()
	 */
	@Override
	public Card pass() {
		return null;
		
	}
	
	/* (non-Javadoc)
	 * @see zsir.model.player.Player#draw(zsir.model.Deck)
	 */
	@Override
	public void draw(Deck d) {
			Card c = d.draw();
			c.setCardParent(this);
			c.flip();
			c.setOnMouseClicked(event -> game.isItLegal(c));
			logger.debug("Human - draw - " + c.toString());
			cards.add(c);
			refreshCardLayout();


	}
	
  /**
   * Adds the card list to the player's history.
   *
   * @param addable the list of those cards that we add to our history list.
   */
	public void addHistory(List<Card> addable) {
		for (Card card : addable) {
			card.setVisible(false);
		}
		history.addAll(addable);
		int old = 0;
		try {
			old = Integer.valueOf(game.getBc().getMyScore().getText());
		}catch (NumberFormatException e) {
			logger.info("Human's score history initialized.");
		}
		game.getBc().getMyScore().setText( String.valueOf(old+addable.size()) );
		addable.clear();
	}
	
	/**
	 * Refreshes the card layout.
	 * Warning: It does NOT sort them, just puts them to the right place.
	 */
	private void refreshCardLayout() {
		for (Card card : cards) {
			card.setLayoutX(200 + cards.indexOf(card) * 100);
			card.setLayoutY(450);
		}
		
	}
	
	/**
	 * Gets the number of the player's card.
	 *
	 * @return the num of cards
	 */
	public int getNumOfCards() {
		return cards.size();
	}
	

}
