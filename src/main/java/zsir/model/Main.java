package zsir.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import zsir.view.LogoController;

/**
 * Sya vilag.
 *
 */
public class Main extends Application {

	private static final String NAME = "Zsir";
	private static final String VERSION = "1.0";
	private static Stage stage;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Main.setStage(stage);
		stage.setTitle(NAME + VERSION);
		createLogoView();

	}

	private void createLogoView() throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../view/LogoView.fxml"));
		Scene scene = new Scene((BorderPane) loader.load());
		LogoController lc = loader.getController();
		getStage().setScene(scene);
		getStage().show();
		lc.fade();
	}
	
	
	@Override
	public void stop() throws Exception {
		super.stop();
		
	}

	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		Main.stage = stage;
	}
}
