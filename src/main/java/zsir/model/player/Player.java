package zsir.model.player;

import java.util.ArrayList;
import java.util.List;

import zsir.model.Card;
import zsir.model.Deck;

public interface Player {
	public Card call(Card c);
	public Card pass();
	public void draw(Deck d);
	public void addHistory(List<Card> addable) ;
}
