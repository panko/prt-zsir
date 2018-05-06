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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import zsir.model.Main;
import zsir.model.UserDAO;
import zsir.model.UserDAOFactory;
import zsir.model.UserValidator;

public class RegisterController implements Initializable {
	
	@FXML
	private TextField userField;
	
	@FXML
	private TextField passField;
	
	@FXML
	private Button regBtn;
	
	@FXML
	Label errLbl;
	
	@FXML
	private Button backBtn;
	
	private UserDAO ud;
	
	@FXML
	public void onBackBtnClick() throws IOException {
		Main.getStage().setScene((new Scene( (Parent) FXMLLoader.load(getClass().getResource("/zsir/view/LoginView.fxml")))));
	}
	@FXML
	public void onRegBtnClick() {
        UserValidator v = new UserValidator(ud);
        
        if (v.regValidate(userField.getText())) {           
            ud.createUser(userField.getText(), userField.getText());
            errLbl.setText("successful reg");
        } else {
        	errLbl.setText("reg failed");
        }
	}

    public void initialize(URL url, ResourceBundle rb) {
        setUd(UserDAOFactory.getInstance().createDAO());
    }
    
	public UserDAO getUd() {
		return ud;
	}
	public void setUd(UserDAO ud) {
		this.ud = ud;
	}
	

	

}
