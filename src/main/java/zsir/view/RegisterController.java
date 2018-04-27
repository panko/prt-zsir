package zsir.view;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import zsir.model.Main;
import zsir.model.User;

public class RegisterController {
	
	@FXML
	private TextField userField;
	
	@FXML
	private TextField passField;
	
	@FXML
	private Button regBtn;
	
	@FXML
	private Button backBtn;
	
	public void onBackBtnClick() throws IOException {
		Main.getStage().setScene((new Scene( (Parent) FXMLLoader.load(getClass().getResource("../view/LoginView.fxml")))));
	}
	
	public void onRegBtnClick() {
		User user = new User(userField.getText(), passField.getText());
		
		user.setDate(new Date(System.currentTimeMillis()));
		
	}
	
	

}
