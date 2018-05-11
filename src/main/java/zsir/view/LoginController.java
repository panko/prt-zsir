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

/**
 * The login controller class.
 */
public class LoginController implements Initializable {
	
	/** The user field. */
	@FXML
	private TextField userField;
	
	/** The pass field. */
	@FXML
	private TextField passField;
	
	/** The login btn. */
	@FXML
	private Button loginBtn;
	
	/** The registration btn. */
	@FXML
	private Button regBtn;
	
	/** The error label. */
	@FXML
	private Label errLbl;

	/** The UserDAO. */
	private UserDAO ud;
	
	/**
	 * To registration view.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	private void toRegView() throws IOException {
		Main.getStage().setScene((new Scene( (Parent) FXMLLoader.load(getClass().getResource("/zsir/view/RegisterView.fxml")))));
	}
	
	/**
	 * On click login button.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	private void onClickLoginBtn() throws IOException {
        	
            UserValidator v = new UserValidator(ud);   
            
            if (v.loginValidate(userField.getText(), passField.getText())) {
            	Main.getStage().setScene((new Scene( (Parent) FXMLLoader.load(getClass().getResource("/zsir/view/BoardView.fxml")))));
            } else {
                errLbl.setText("A belépés sikertelen!");
            }
		
	}
	
    /* (non-Javadoc)
     * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
     */
    public void initialize(URL url, ResourceBundle rb) {

        ud = UserDAOFactory.getInstance().createDAO();

    }

}
