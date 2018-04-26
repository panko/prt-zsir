package zsir.view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import zsir.model.Main;

public class RegisterController {
	
	@FXML
	private TextField userField;
	
	@FXML
	private TextField passField;
	
	@FXML
	private Button regBtn;
	
	@FXML
	private Button backBtn;
	
	public void toLoginView() throws IOException {
		Main.getStage().setScene((new Scene( (Parent) FXMLLoader.load(getClass().getResource("../view/LoginView.fxml")))));
	}
	
	

}
