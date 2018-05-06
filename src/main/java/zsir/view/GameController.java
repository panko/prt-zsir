package zsir.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import zsir.model.Game;
import zsir.model.Deck;


public class GameController {
	
	@FXML
	private Button btn;
	
	public Game game;
	
	@FXML
	private void onClickBtn() {
		System.out.println("in onClickBtn.");
		game = new Game();
		game.getDeck();
		int size = 0;
		for(Deck.Card card: game.getDeck().getCards()) {
			BorderPane bp = (BorderPane) btn.getParent();
			card.setTranslateX(card.getTranslateX()+size);
			bp.getChildren().add(card);
			size += 10;
		}
	}

}
