package zsir.model.player;

import java.util.ArrayList;
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

public class AI implements Player {
	@Override
	public String toString() {
		return "AI [name=" + name + ", cards=" + cards + ", history=" + history + ", game=" + game + "]";
	}

	private static Logger logger = LoggerFactory.getLogger(AI.class);

	final String name = "AI";
	List<Card> cards;
	List<Card> history;
	Game game;

	public AI(Game game) {
		cards = new ArrayList<Card>();
		history = new ArrayList<Card>();
		this.game = game;
	}

	@Override
	public Card pass() {
		// TODO Auto-generated method stub
		return null;
	}

	public Card call() {
		Card mine = cards.remove(0);
		mine.slideAndSave();
		// mine.setLayoutY(150);
		// mine.flip();
		logger.info("AI - call() - " + mine);
		return mine;
	}
	
	public boolean doIPass() {
		return true;
	}
	
	public Card callOnly() {
		Card mine = cards.remove(0);
		mine.slide();
		// mine.setLayoutY(150);
		// mine.flip();
		logger.info("AI - callOnly() - " + mine);
		return mine;
	}

	@Override
	public Card call(Card c) {
		for (Card card : cards) {
			if(c.rank == card.rank) {
				logger.info("AI hit hard.");
				cards.remove(card);
				card.slide();
				return card;
			}
		}
		return call();
		
		
	}

	@Override
	public void draw(Deck d) {
			Card c = d.draw();
			c.parent = this;
			c.flip();
			logger.debug("AI - draw - " + c.toString());
			cards.add(c);
			refreshCardLayout();

	}

	private void refreshCardLayout() {
		for (Card card : cards) {
			card.setLayoutX(200 + cards.indexOf(card) * 100);
			card.setLayoutY(0);
		}

	}

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
	
	public int getNumOfCards() {
		return cards.size();
	}
}
