package zsir.model.player;

import java.util.List;
import zsir.model.Card;
import zsir.model.Deck;


/**
 * The Interface Player.
 */
public interface Player {
	
	/**
	 * When the player calls something.
	 *
	 * @param c the c
	 * @return the card
	 */
	public Card call(Card c);
	
	/**
	 * When the player passes something.
	 *
	 * @return the card
	 */
	public Card pass();
	
	/**
	 * Draws from the deck as much as he/she can.
	 * Warning: It needs to be implemented, we don't use it yet, but we would if the ai would be more clever.
	 * @param d the deck
	 */
	public void draw(Deck d);
	
	/**
	 * Adds the card list to the player's history.
	 *
	 * @param addable the list of those cards that we add to our history list.
	 */
	public void addHistory(List<Card> addable) ;
}
