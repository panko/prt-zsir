package zsir.view;

import java.util.List;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import zsir.model.Game;
import zsir.model.fsm.State;
import zsir.model.player.Player;
import zsir.model.Card;
import zsir.model.Deck;


public class BoardController {
	
	public Label getAiScore() {
		return aiScore;
	}



	public Label getMyScore() {
		return myScore;
	}



	public Button getReleaseBtn() {
		return releaseBtn;
	}



	public void setReleaseBtn(Button releaseBtn) {
		this.releaseBtn = releaseBtn;
	}



	public Button getBtn() {
		return btn;
	}



	public void setBtn(Button btn) {
		this.btn = btn;
	}



	@FXML
	private Button releaseBtn;
	
	@FXML
	private Button btn;
	
	@FXML
	private Label aiScore;
	
	@FXML
	private Label myScore;
	
	public Game game;
	
	
	
	@FXML
	private void onClickBtn() {
		System.out.println("in onClickBtn.");
		game = new Game(this);
		BorderPane bp = (BorderPane) btn.getParent().getParent();
		for(Card card: game.getDeck().getCards()) {
			bp.getChildren().add(card);
		}
		game.initialize();
		btn.setVisible(false);

	}
	
	@FXML
	private void onClickRelease(){

		game.switchPlayers();
		releaseBtn.setVisible(false);
		game.drawBoth();
		Player cp = game.getCurrentP();
		cp.addHistory(game.currentlyOnBoard);
		
		
		game.AIstrun();
	}

}
