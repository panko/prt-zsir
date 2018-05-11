package zsir.model;

import zsir.model.player.AI;
import zsir.model.player.Human;
import zsir.model.player.Player;
import zsir.view.BoardController;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Game Class. It is our master class, everything begins here.
 */
public class Game {

  /**
   * Gets the current P.
   *
   * @return the current P
   */
  public Player getCurrentP() {
    return currentP;
  }

  /**
   * Sets the current P.
   *
   * @param currentP
   *          the new current P
   */
  public void setCurrentP(Player currentP) {
    this.currentP = currentP;
  }

  /**
   * Gets the bc.
   *
   * @return the bc
   */
  public BoardController getBc() {
    return bc;
  }

  /** The logger. */
  private static Logger logger = LoggerFactory.getLogger(Game.class);

  /**
   * The Enum State.
   */
  enum State {

    /** The start. */
    START,
    /** The called. */
    CALLED,
    /** The hitted. */
    HITTED,
    /** The stopped. */
    STOPPED
  }

  /** The me. */
  private Human me;

  /** The ai. */
  private AI ai;

  /** The current P. */
  private Player currentP;

  /** The state. */
  private State state;

  /** The deck. */
  private Deck deck;

  /** The bc. */
  private BoardController bc;

  /** The currently on board. */
  public List<Card> currentlyOnBoard;

  /**
   * Instantiates a new game.
   *
   * @param bc
   *          the bc
   */
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

  /**
   * Initialize.
   */
  public void initialize() {
    for (int i = 0; i < 4; i++) {
      drawBoth();
    }

  }

  /**
   * It gets called when the user clicks. We need this because of the animations,
   * to keep the game flow smooth.
   *
   * @param c
   *          the Card
   */
  public void userClick(Card c) {
    currentlyOnBoard.add(c);
    me.call(c);
    logger.info("UserCLick - " + c);
    if (currentP == me) {
      if (state == State.HITTED) {
        setState(State.CALLED);
        Card ais = ai.call(c);
        currentlyOnBoard.add(ais);
        if (isHitHappened(c, ais)) {
          bc.getReleaseBtn().setVisible(true);
          setState(State.HITTED);
        } else {
          bc.getReleaseBtn().setVisible(false);
          // myWinSave();
          return;
        }
      }
      if (state == State.START) {
        Card ais = ai.call(c);
        currentlyOnBoard.add(ais);
        if (isHitHappened(c, ais)) {
          setState(State.HITTED);
          bc.getReleaseBtn().setVisible(true);

        } else {
          // myWinSave() will get callbacked.
        }
      }

    }

    AIstrun();
  }

  /**
   * We have to call this when it's the AI's turn. It manages how the ai behaves
   * on some action.
   */
  public void AIstrun() {

    if (currentP == ai && state == State.CALLED) {
      int cursize = currentlyOnBoard.size();
      logger.debug("AI - state == State.CALLED");
      logger.debug("curreltyonboardssize: ", cursize);

      if (isHitHappened(currentlyOnBoard.get(cursize - 2), currentlyOnBoard.get(cursize - 1))) { // if i hit the AI
        if (ai.doIPass()) {
          myWinSave();
          switchPlayers();
        } else { // ai is confident
          // TODO
        }
      } else {
        aiWinSave();

        AIstrun();
      }
    }

    if (currentP == ai && state == State.HITTED) {
      setState(State.CALLED);
      Card ais = ai.callOnly();
      currentlyOnBoard.add(ais);
    }

    if (currentP == ai && state == State.START) {
      if (isItOver()) {
        return;
      }

      setState(State.CALLED);
      Card ais = ai.callOnly();
      currentlyOnBoard.add(ais);
    }

  }

  /**
   * Checks if is it legal to click on a card. Logs when it is not.
   *
   * @param c
   *          the Card
   */
  public void isItLegal(Card c) {
    if (currentP == me && state == State.START) {
      c.clickSlide();
    } else if (currentP == me && state == State.HITTED && isHitHappened(currentlyOnBoard.get(0), c)) {
      c.clickSlide();
    } else if (currentP == ai && state == State.CALLED) {
      c.clickSlide();
    } else if (currentP == ai && state == State.HITTED && isHitHappened(currentlyOnBoard.get(0), c)) {
      c.clickSlide();
    } else {

      logger.error("illegal step. currentP=" + currentP + " state: " + state);
    }

  }

  /**
   * Save the player's win.
   */
  public void myWinSave() {
    logger.debug("human wins.");
    me.addHistory(currentlyOnBoard);
    drawBoth();
    setState(State.START);
  }

  /**
   * Save the AI's win.
   */
  public void aiWinSave() {
    logger.debug("ai wins.");
    ai.addHistory(currentlyOnBoard);
    drawBoth();
    setState(State.START);
  }

  /**
   * Switch players. We use this when the caller becomes the called.
   */
  public void switchPlayers() {
    logger.debug("The new 'called' player: " + currentP);
    if (currentP == me) {
      currentP = ai;
    } else {
      currentP = me;
    }
    logger.debug("The new caller: " + currentP);
    setState(State.START);
  }

  /**
   * Both player draws one from the deck, we also checks gameOver.
   */
  public void drawBoth() {
    logger.trace("in drawBoth()");
    if (isItOver()) {
      doGameOver();
    }

    while (deck.getCards().size() != 0 && me.getNumOfCards() < 4) {
      me.draw(deck);
      ai.draw(deck);
    }

  }

  /**
   * Checks if the two cards are conflicting. Returns true if someone hits the
   * other one.
   *
   * @param caller
   *          is the one who currently playing.
   * @param called
   *          is the one who getting (out) played.
   * @return true, if hit happened.
   */
  public boolean isHitHappened(Card caller, Card called) {
    if (Card.Rank.SEVEN == called.getRank())
      return true;
    if (caller.getRank() == called.getRank())
      return true;
    return false;
  }

  /**
   * Gets the deck.
   *
   * @return the deck
   */
  public Deck getDeck() {
    return deck;
  }

  /**
   * Sets the deck.
   *
   * @param deck
   *          the new deck
   */
  public void setDeck(Deck deck) {
    this.deck = deck;
  }

  /**
   * Gets the state.
   *
   * @return the state
   */
  public State getState() {
    return state;
  }

  /**
   * Checks if is it over.
   *
   * @return true, if is it over
   */
  private boolean isItOver() {
    if (deck.getCards().size() == 0 && me.getNumOfCards() == 0 && ai.getNumOfCards() == 0) {
      return true;
    }
    return false;
  }

  /**
   * Do the game over.
   */
  private void doGameOver() {
    logger.debug("GAME IS OVER.");
    bc.getReleaseBtn().setVisible(false);
    bc.getBtn().setVisible(true);
  }

  /**
   * Sets the state. And logs the old state, and the current caller.
   *
   * @param state
   *          the new state
   */
  public void setState(State state) {
    logger.info("Old state: " + this.state + " new state: " + state);
    logger.debug("Current caller: " + currentP);
    this.state = state;
  }
}
