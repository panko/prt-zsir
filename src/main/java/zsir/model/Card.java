package zsir.model;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;
import zsir.model.player.AI;
import zsir.model.player.Human;
import zsir.model.player.Player;

public class Card extends ImageView {
	private static Logger logger = LoggerFactory.getLogger(Card.class);

	public static Game game;

	public static enum Suit {
		HEARTS, BELLS, LEAVES, ACORNS
	}

	public static enum Rank {
		ACE, KING, OVER, UNDER, TEN, NINE, EIGHT, SEVEN
	}

	public Suit suit;
	public Rank rank;
	public Player parent = null;
	static final Image back = new Image("/pictures/Card_back_12.png");
	private Image front;

	public Card(Suit s, Rank r, Game game) {
		this.game = game;
		this.rank = r;
		this.suit = s;
		front = new Image(getFrontCardFileName(s, r));
		super.setImage(back);
	}

	@Override
	public String toString() {
		return "Card [suit=" + suit + ", rank=" + rank + ", hash=" + hashCode() + "]";
	}

	public void flip() {
		if (super.getImage() == back) {
			super.setImage(front);
		} else {
			super.setImage(back);
		}
	}

	private String getFrontCardFileName(Suit s, Rank r) {
		StringBuilder sb = new StringBuilder();
		sb.append("/pictures/front/");
		sb.append(s.ordinal());
		sb.append("-");
		sb.append(r.ordinal());
		sb.append(".jpeg");
		return sb.toString();
	}

	public void clickSlide() {
		this.setMouseTransparent(true);
		Card cardd = this;
		TranslateTransition tt = new TranslateTransition(Duration.millis(500), this);
		if (parent.getClass() == Human.class) {
			tt.setByY(-150f);
		}
		if (parent.getClass() == AI.class) {
			tt.setByY(150f);
		}
		PauseTransition pt = new PauseTransition(Duration.millis(500));
		SequentialTransition st = new SequentialTransition(tt, pt);
		st.setOnFinished(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent actionEvent) {
				cardd.game.userClick(cardd);
			}
		});
		st.play();
		
	}

	public void slideAndSave() {
		Card cardd = this;
		TranslateTransition tt = new TranslateTransition(Duration.millis(500), this);
		if (parent.getClass() == Human.class) {
			tt.setByY(-150f);
		}
		if (parent.getClass() == AI.class) {
			tt.setByY(150f);
		}
		PauseTransition pt = new PauseTransition(Duration.millis(500));
		SequentialTransition st = new SequentialTransition(tt, pt);
		st.setOnFinished(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent actionEvent) {
				logger.debug("slideAndSave() - st.setOnFinished - handle");
				if(!cardd.game.getBc().getReleaseBtn().isVisible()) cardd.game.myWinSave();
			}
		});
		st.play();
	}
	
	public void slideAndAiSave() {
		Card cardd = this;
		TranslateTransition tt = new TranslateTransition(Duration.millis(500), this);
		if (parent.getClass() == Human.class) {
			tt.setByY(-150f);
		}
		if (parent.getClass() == AI.class) {
			tt.setByY(150f);
		}
		PauseTransition pt = new PauseTransition(Duration.millis(500));
		SequentialTransition st = new SequentialTransition(tt, pt);
		st.setOnFinished(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent actionEvent) {
				logger.debug("slideAndAiSave() - st.setOnFinished - handle");
				if(!cardd.game.getBc().getReleaseBtn().isVisible()) cardd.game.aiWinSave();
			}
		});
		st.play();
	}
		
		public void slide() {
			Card cardd = this;
			TranslateTransition tt = new TranslateTransition(Duration.millis(500), this);
			if (parent.getClass() == Human.class) {
				tt.setByY(-150f);
			}
			if (parent.getClass() == AI.class) {
				tt.setByY(150f);
			}
			PauseTransition pt = new PauseTransition(Duration.millis(500));
			SequentialTransition st = new SequentialTransition(tt, pt);
			st.setOnFinished(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent actionEvent) {
					logger.debug("slide() - st.setOnFinished - handle");
				}
			});
			st.play();

	}
}
