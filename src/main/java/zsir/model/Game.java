package zsir.model;

import javafx.animation.PauseTransition;
import javafx.util.Duration;
import zsir.model.player.AI;
import zsir.model.player.Human;
import zsir.model.player.Player;
import zsir.view.BoardController;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Game {
	public Player getCurrentP() {
		return currentP;
	}

	public void setCurrentP(Player currentP) {
		this.currentP = currentP;
	}

	public BoardController getBc() {
		return bc;
	}

	private static Logger logger = LoggerFactory.getLogger(Game.class);

	enum State {
		START, CALLED, HITTED, STOPPED
	}

	private Human me;
	private AI ai;
	private Player currentP;
	private State state;
	private Deck deck;
	private BoardController bc;
	public List<Card> currentlyOnBoard;

	public Game(BoardController bc) {
		currentlyOnBoard = new ArrayList<Card>();
		this.bc = bc;
		setState(State.START);
		System.out.println("In Game().initialize");
		deck = new Deck(this);
		me = new Human(this);
		ai = new AI(this);
		currentP = me;

	}

	public void initialize() {
		for (int i = 0; i < 4; i++) {
			drawBoth();
		}

	}

	public void play() {
		while (!deck.cards.isEmpty()) {
			Round r = new Round();
		}

	}

	public void userClick(Card c) {
		currentlyOnBoard.add(c);
		me.call(c);
		logger.info("UserCLick - " + c);
		if (currentP == me) {
			if (state == State.HITTED) {
				setState(State.CALLED);
				Card ais = ai.call(c);
				currentlyOnBoard.add(ais);
				if (isHit(c, ais)) {
					bc.getReleaseBtn().setVisible(true);
				} else {
					me.addHistory(currentlyOnBoard);
					drawBoth();
				}
			}
			if (state == State.START) {
				Card ais = ai.call(c);
				currentlyOnBoard.add(ais);
				if (isHit(c, ais)) {
					setState(State.HITTED);
					bc.getReleaseBtn().setVisible(true);

				} else {
					// myWinSave() will get callbacked.
				}
			}

		}

		AIstrun();
	}

	public void AIstrun() {
		if (currentP == ai) {
			if (state == State.CALLED) {
				logger.debug("state == State.CALLED");
				setState(State.START);
				aiWinSave();
			}
			if (state == State.HITTED) {
				setState(State.CALLED);
				Card ais = ai.callOnly();
				currentlyOnBoard.add(ais);
			}

			if (state == State.START) {
				setState(State.CALLED);
				Card ais = ai.callOnly();
				currentlyOnBoard.add(ais);
			}

		}
	}

	public void isItLegal(Card c) {
		if (currentP == me && state == State.START) {
			c.clickSlide();
		} else if (currentP == me && state == State.HITTED && isHit(currentlyOnBoard.get(0), c)) {
			c.clickSlide();
		} else if (currentP == ai && state == State.CALLED) {
			c.clickSlide();
		} else if (currentP == ai && state == State.HITTED && isHit(currentlyOnBoard.get(0), c)) {
			c.clickSlide();
		} else {
			logger.error("illegal step.");
		}

	}

	public void myWinSave() {
		me.addHistory(currentlyOnBoard);
		drawBoth();
	}

	public void aiWinSave() {
		ai.addHistory(currentlyOnBoard);
		drawBoth();
	}

	public void switchPlayers() {
		if (currentP == me) {
			currentP = ai;
		} else {
			currentP = me;
		}
		setState(State.START);
	}

	public void drawBoth() {
		logger.trace("BOTH DRAWED.");
		me.draw(deck);
		ai.draw(deck);
	}

	public boolean isHit(Card hivo, Card hivott) {
		if (Card.Rank.SEVEN == hivott.rank)
			return true;
		if (hivo.rank == hivott.rank)
			return true;
		return false;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		logger.info("Old state: " + this.state + " new state: " + state);
		this.state = state;
	}
}
