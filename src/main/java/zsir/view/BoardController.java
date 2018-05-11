package zsir.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import zsir.model.Game;
import zsir.model.player.Player;
import zsir.model.Card;

/**
 * The Controller of the board.
 */
public class BoardController {

	/**
	 * Gets the ai score.
	 *
	 * @return the ai score
	 */
	public Label getAiScore() {
		return aiScore;
	}

	/**
	 * Gets the my score.
	 *
	 * @return the my score
	 */
	public Label getMyScore() {
		return myScore;
	}

	/**
	 * Gets the release btn.
	 *
	 * @return the release btn
	 */
	public Button getReleaseBtn() {
		return releaseBtn;
	}

	/**
	 * Sets the release btn.
	 *
	 * @param releaseBtn
	 *            the new release btn
	 */
	public void setReleaseBtn(Button releaseBtn) {
		this.releaseBtn = releaseBtn;
	}

	/**
	 * Gets the btn.
	 *
	 * @return the btn
	 */
	public Button getBtn() {
		return btn;
	}

	/**
	 * Sets the btn.
	 *
	 * @param btn
	 *            the new btn
	 */
	public void setBtn(Button btn) {
		this.btn = btn;
	}

	/** The release btn. */
	@FXML
	private Button releaseBtn;

	/** The btn. */
	@FXML
	private Button btn;

	/** The ai score. */
	@FXML
	private Label aiScore;

	/** The my score. */
	@FXML
	private Label myScore;

	/** The game. */
	public Game game;

	/**
	 * On click btn.
	 */
	@FXML
	private void onClickBtn() {
		System.out.println("in onClickBtn.");
		game = new Game(this);
		BorderPane bp = (BorderPane) btn.getParent().getParent();
		for (Card card : game.getDeck().getCards()) {
			bp.getChildren().add(card);
		}
		game.initialize();
		btn.setVisible(false);

	}

	/**
	 * On click release.
	 */
	@FXML
	private void onClickRelease() {

		game.switchPlayers();
		releaseBtn.setVisible(false);
		game.drawBoth();
		Player cp = game.getCurrentP();
		cp.addHistory(game.currentlyOnBoard);
		game.AIstrun();
	}

}
