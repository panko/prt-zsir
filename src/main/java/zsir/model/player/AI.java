package zsir.model.player;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zsir.model.Card;
import zsir.model.Deck;
import zsir.model.Game;

/**
 * The AI Class, the computer.
 * It's very barbaric yet.
 */
public class AI implements Player {
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AI [name=" + name + ", cards=" + cards + ", history=" + history + ", game=" + game + "]";
	}

	/** The logger. */
	private static Logger logger = LoggerFactory.getLogger(AI.class);

	/** The name. */
	final String name = "AI";
	
	/** The cards. */
	List<Card> cards;
	
	/** The history. */
	List<Card> history;
	
	/** The game. */
	Game game;

	/**
	 * Instantiates a new ai.
	 *
	 * @param game the game object
	 */
	public AI(Game game) {
		cards = new ArrayList<Card>();
		history = new ArrayList<Card>();
		this.game = game;
	}

	/* (non-Javadoc)
	 * @see zsir.model.player.Player#pass()
	 */
	@Override
	public Card pass() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * The AI is calling a card. We remove one from her hand. And slides it.
	 *
	 * @return the called card
	 */
	public Card call() {
		Card mine = cards.remove(0);
		mine.slideAndSave();
		logger.info("AI - call() - " + mine);
		return mine;
	}
	
	/**
	 * Do the AI passed. We don't want to lose so it always return true.
	 *
	 * @return true, forever
	 */
	public boolean doIPass() {
		return true;
	}
	
	/**
	 * Call only. We don't save the game with the slide of the card.
	 *
	 * @return the card
	 */
	public Card callOnly() {
		Card mine = cards.remove(0);
		mine.slide();
		logger.info("AI - callOnly() - " + mine);
		return mine;
	}

	/* (non-Javadoc)
	 * @see zsir.model.player.Player#call(zsir.model.Card)
	 */
	@Override
	public Card call(Card c) {
		for (Card card : cards) {
			if(c.getRank() == card.getRank()) {
				logger.info("AI hit hard.");
				cards.remove(card);
				card.slide();
				return card;
			}
		}
		return call();
	}

	/* (non-Javadoc)
	 * @see zsir.model.player.Player#draw(zsir.model.Deck)
	 */
	@Override
	public void draw(Deck d) {
			Card c = d.draw();
			c.setCardParent(this);
			c.flip();
			logger.debug("AI - draw - " + c.toString());
			cards.add(c);
			refreshCardLayout();

	}

	/**
	 * Refreshes card layout.
	 */
	private void refreshCardLayout() {
		for (Card card : cards) {
			card.setLayoutX(200 + cards.indexOf(card) * 100);
			card.setLayoutY(0);
		}

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
			old = Integer.valueOf(game.getBc().getAiScore().getText());
		} catch (NumberFormatException e) {
			logger.info("AI's score history initialized.");
		}
		game.getBc().getAiScore().setText(String.valueOf(old + addable.size()));
		addable.clear();
	}
	
	/**
	 * Gets the number of the AI's card.
	 *
	 * @return the num of cards
	 */
	public int getNumOfCards() {
		return cards.size();
	}
}
