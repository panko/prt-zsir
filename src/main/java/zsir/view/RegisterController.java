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

/**
 * The Class RegisterController.
 */
public class RegisterController implements Initializable {

  /** The user field. */
  @FXML
  private TextField userField;

  /** The pass field. */
  @FXML
  private TextField passField;

  /** The registration button. */
  @FXML
  private Button regBtn;

  /** The error label. */
  @FXML
  Label errLbl;

  /** The back button. */
  @FXML
  private Button backBtn;

  /** The UserDAO. */
  private UserDAO ud;

  /**
   * When we click to the back button.
   *
   * @throws IOException
   *           Signals that an I/O exception has occurred.
   */
  @FXML
  public void onBackBtnClick() throws IOException {
    Main.getStage()
        .setScene((new Scene((Parent) FXMLLoader.load(getClass().getResource("/zsir/view/LoginView.fxml")))));
  }

  /**
   * When we click on the registration button.
   */
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

  /**
   * Runs when the controller initialized. Sets the UserDAO.
   * @param url The URL.
   * @param rb The ResourceBoundle
   */
  public void initialize(URL url, ResourceBundle rb) {
    setUd(UserDAOFactory.getInstance().createDAO());
  }

  /**
   * Gets the UserDAO.
   *
   * @return the ud
   */
  public UserDAO getUd() {
    return ud;
  }

  /**
   * Sets the UserDAO.
   *
   * @param ud
   *          the new ud
   */
  public void setUd(UserDAO ud) {
    this.ud = ud;
  }

}
