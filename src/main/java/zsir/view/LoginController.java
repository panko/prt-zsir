package zsir.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import zsir.model.Main;
import zsir.model.UserDAO;
import zsir.model.UserDAOFactory;
import zsir.model.UserValidator;

public class LoginController implements Initializable {
	
	@FXML
	private TextField userField;
	
	@FXML
	private TextField passField;
	
	@FXML
	private Button loginBtn;
	
	@FXML
	private Button regBtn;
	
	@FXML
	private Label errLbl;

	private UserDAO ud;
	
	@FXML
	private void toRegView() throws IOException {
		Main.getStage().setScene((new Scene( (Parent) FXMLLoader.load(getClass().getResource("/zsir/view/RegisterView.fxml")))));
	}
	
	@FXML
	private void onClickLoginBtn() throws IOException {
        	
            UserValidator v = new UserValidator(ud);   
            
            if (v.loginValidate(userField.getText(), passField.getText())) {
            	Main.getStage().setScene((new Scene( (Parent) FXMLLoader.load(getClass().getResource("/zsir/view/GameView.fxml")))));
            } else {
                errLbl.setText("A belépés sikertelen!");
            }
		
	}
	
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ud = UserDAOFactory.getInstance().createDAO();

    }

}
