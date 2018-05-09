package zsir.model.player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import zsir.model.Card;
import zsir.model.Deck;
import zsir.model.Game;

public class Human implements Player {
	private static Logger logger = LoggerFactory.getLogger(Human.class);
	
	String name;
	private List<Card> cards;
	private List<Card> history;
	Game game;
	
	public Human(Game game) {
		cards = new ArrayList<Card>();
		history = new ArrayList<Card>();
		this.game = game;
	}
	

	@Override
	public Card call(Card c) {
		//c.slide();
		refreshCardLayout();
		
		cards.remove(c);
		return c;
	}
	@Override
	public Card pass() {
		return null;
		
	}
	
	@Override
	public void draw(Deck d) {
		while (cards.size() < 4) {
			Card c = d.draw();
			c.parent = this;
			c.flip();
			c.setOnMouseClicked(event -> game.isItLegal(c));
			logger.debug("Human - draw - " + c.toString());
			cards.add(c);
			refreshCardLayout();
		}


	}
	
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
	
	private void refreshCardLayout() {
		for (Card card : cards) {
			card.setLayoutX(200 + cards.indexOf(card) * 100);
			card.setLayoutY(450);
		}
		
	}
	
	

}
