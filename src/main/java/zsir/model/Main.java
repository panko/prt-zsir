package zsir.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import zsir.view.LogoController;

// TODO: Auto-generated Javadoc
/**
 * A starter class of our application.
 *
 */
public class Main extends Application {

	/** The Constant NAME of our game. */
	private static final String NAME = "Zsir";
	
	/** The Constant VERSION of our game. */
	private static final String VERSION = "1.0";
	
	/** The primary stage. */
	private static Stage stage;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage stage) throws Exception {
		Main.setStage(stage);
		stage.setTitle(NAME + " " + VERSION);
		createLogoView();

	}

	/**
	 * Creates the logo view. And starts the animation.
	 *
	 * @throws Exception the exception
	 */
	private void createLogoView() throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/zsir/view/LogoView.fxml"));
		Scene scene = new Scene((BorderPane) loader.load());
		LogoController lc = loader.getController();
		getStage().setScene(scene);
		getStage().show();
		lc.fade();
	}
	
	
	/* (non-Javadoc)
	 * @see javafx.application.Application#stop()
	 */
	@Override
	public void stop() throws Exception {
		super.stop();
		UserDAOFactory.getInstance().close();
		
	}

	/**
	 * Gets the stage.
	 *
	 * @return the stage
	 */
	public static Stage getStage() {
		return stage;
	}

	/**
	 * Sets the stage.
	 *
	 * @param stage the new stage
	 */
	public static void setStage(Stage stage) {
		Main.stage = stage;
	}
}
