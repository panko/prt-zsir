package zsir.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import zsir.model.Game;

public class GameController {
	
	@FXML
	private Button btn;
	
	public Game game;
	
	@FXML
	private void onClickBtn() {
		System.out.println("in onClickBtn.");
		game = new Game();
	}

}
