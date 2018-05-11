package zsir.model;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zsir.model.player.AI;
import zsir.model.player.Human;
import zsir.model.player.Player;

/**
 * The Class Card. It represents a card on the window.
 */
public class Card extends ImageView {

  /** The logger. */
  private static Logger logger = LoggerFactory.getLogger(Card.class);

  /** The game. */
  private static Game game;

  /**
   * The Enum Suit. The card's suit.
   */
  public enum Suit {

    /** The hearts. */
    HEARTS,
    /** The bells. */
    BELLS,
    /** The leaves. */
    LEAVES,
    /** The acorns. */
    ACORNS
  }

  /**
   * The Enum Rank. The card's rank
   */
  public enum Rank {

    /** The ace. */
    ACE,
    /** The king. */
    KING,
    /** The over. */
    OVER,
    /** The under. */
    UNDER,
    /** The ten. */
    TEN,
    /** The nine. */
    NINE,
    /** The eight. */
    EIGHT,
    /** The seven. */
    SEVEN
  }

  /** The suit. */
  private Suit suit;

  /** The rank. */
  private Rank rank;

  /** The parent. */
  private Player cardParent = null;

  /** The Constant back. */
  static final Image BACK = new Image("/pictures/Card_back_12.png");

  /** The front. */
  private Image front;

  /**
   * Instantiates a new card.
   *
   * @param s
   *          the s
   * @param r
   *          the r
   */
  public Card(final Suit s, final Rank r) {
    this.game = null;
    this.setRank(r);
    this.suit = s;
    front = new Image(getFrontCardFileName(s, r));
    super.setImage(BACK);
  }

  /**
   * Instantiates a new card. Sets the front n back of the card.
   *
   * @param s
   *          the suit
   * @param r
   *          the rank
   * @param game
   *          the game object
   */
  public Card(final Suit s, final Rank r, final Game game) {
    this.game = game;
    this.setRank(r);
    this.suit = s;
    front = new Image(getFrontCardFileName(s, r));
    super.setImage(BACK);
  }

  /*
   * (non-Javadoc)
   * 
   * @see javafx.scene.Node#toString()
   */
  @Override
  public String toString() {
    return "Card [suit=" + suit + ", rank=" + getRank() + ", hash=" + hashCode() + "]";
  }

  /**
   * It flips the card, the back will be the front, the front will be the back.
   */
  public void flip() {
    if (super.getImage() == BACK) {
      super.setImage(front);
    } else {
      super.setImage(BACK);
    }
  }

  /**
   * Gets the front card filename.
   *
   * @param s
   *          the suit
   * @param r
   *          the rank
   * @return the front card file name
   */
  private String getFrontCardFileName(final Suit s, final Rank r) {
    StringBuilder sb = new StringBuilder();
    sb.append("/pictures/front/");
    sb.append(s.ordinal());
    sb.append("-");
    sb.append(r.ordinal());
    sb.append(".jpeg");
    return sb.toString();
  }

  /**
   * It slides the card then it calls the game.userClick() method.
   */
  public void clickSlide() {
    this.setMouseTransparent(true);
    Card cardd = this;
    TranslateTransition tt = new TranslateTransition(Duration.millis(500), this);
    if (cardParent.getClass() == Human.class) {
      tt.setByY(-150f);
    }
    if (cardParent.getClass() == AI.class) {
      tt.setByY(150f);
    }
    PauseTransition pt = new PauseTransition(Duration.millis(500));
    SequentialTransition st = new SequentialTransition(tt, pt);
    st.setOnFinished(new EventHandler<ActionEvent>() {

      @Override
      public void handle(final ActionEvent actionEvent) {
        cardd.game.userClick(cardd);
      }
    });
    st.play();

  }

  /**
   * Slide and regular mySave callback.
   */
  public void slideAndSave() {
    Card cardd = this;
    TranslateTransition tt = new TranslateTransition(Duration.millis(500), this);
    if (cardParent.getClass() == Human.class) {
      tt.setByY(-150f);
    }
    if (cardParent.getClass() == AI.class) {
      tt.setByY(150f);
    }
    PauseTransition pt = new PauseTransition(Duration.millis(500));
    SequentialTransition st = new SequentialTransition(tt, pt);
    st.setOnFinished(new EventHandler<ActionEvent>() {

      /*
       * (non-Javadoc)
       * 
       * @see javafx.event.EventHandler#handle(javafx.event.Event)
       */
      @Override
      public void handle(final ActionEvent actionEvent) {
        logger.debug("slideAndSave() - st.setOnFinished - handle");
        if (!cardd.game.getBc().getReleaseBtn().isVisible()) {
          cardd.game.myWinSave();
        }
      }
    });
    st.play();
  }

  /**
   * Slide and ai save callback.
   */
  public void slideAndAiSave() {
    Card cardd = this;
    TranslateTransition tt = new TranslateTransition(Duration.millis(500), this);
    if (cardParent.getClass() == Human.class) {
      tt.setByY(-150f);
    }
    if (cardParent.getClass() == AI.class) {
      tt.setByY(150f);
    }
    PauseTransition pt = new PauseTransition(Duration.millis(500));
    SequentialTransition st = new SequentialTransition(tt, pt);
    st.setOnFinished(new EventHandler<ActionEvent>() {

      @Override
      public void handle(final ActionEvent actionEvent) {
        logger.debug("slideAndAiSave() - st.setOnFinished - handle");
        if (!cardd.game.getBc().getReleaseBtn().isVisible()) {
          cardd.game.aiWinSave();
        }
      }
    });
    st.play();
  }

  /**
   * Slide animation.
   */
  public void slide() {
    Card cardd = this;
    TranslateTransition tt = new TranslateTransition(Duration.millis(500), this);
    if (cardParent.getClass() == Human.class) {
      tt.setByY(-150f);
    }
    if (cardParent.getClass() == AI.class) {
      tt.setByY(150f);
    }
    PauseTransition pt = new PauseTransition(Duration.millis(500));
    SequentialTransition st = new SequentialTransition(tt, pt);
    st.setOnFinished(new EventHandler<ActionEvent>() {

      @Override
      public void handle(final ActionEvent actionEvent) {
        logger.debug("slide() - st.setOnFinished - handle");
      }
    });
    st.play();

  }

  /**
   * Gets the rank.
   *
   * @return the rank
   */
  public Rank getRank() {
    return rank;
  }

  /**
   * Sets the rank.
   *
   * @param rank
   *          the new rank
   */
  public void setRank(final Rank rank) {
    this.rank = rank;
  }

  /**
   * Gets the card parent.
   *
   * @return the card parent
   */
  public Player getCardParent() {
    return cardParent;
  }

  /**
   * Sets the card parent.
   *
   * @param cardParent
   *          the new card parent
   */
  public void setCardParent(final Player cardParent) {
    this.cardParent = cardParent;
  }

  /**
   * Gets the game.
   *
   * @return the game
   */
  public static Game getGame() {
    return game;
  }

  /**
   * Sets the game.
   * @param game
   *          the new game
   */
  public static void setGame(final Game game) {
    Card.game = game;
  }
}
