package zsir.view;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;
import zsir.model.Main;

/**
 * The Class LogoController.
 */
public class LogoController {

	/** The university's logo. */
	@FXML
	protected ImageView debLogo;
	
	/** My logo. */
	@FXML
	protected ImageView myLogo;

	/** The root pane. */
	@FXML
	protected BorderPane rootPane;
	
	/** The sequential transition. */
	SequentialTransition seqT;

	/**
	 * The whole animation.
	 */
	public void fade() {
		seqT = new SequentialTransition();
		debFade();
		meFade();
		seqT.play();
		seqT.setOnFinished(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent ae) {
            	try {
					Main.getStage().setScene((new Scene( (Parent) FXMLLoader.load(getClass().getResource("/zsir/view/LoginView.fxml")))));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
		});
	}
	
	/**
	 * Universitiy of Debrecen's logo animation.
	 */
	private void debFade() {
		FadeTransition ft = new FadeTransition(Duration.seconds(2), debLogo);
		ft.setFromValue(0.0);
		ft.setToValue(1.0);
		FadeTransition fto = new FadeTransition(Duration.seconds(2), debLogo);
		fto.setFromValue(1.0);
		fto.setToValue(0.0);
		seqT.getChildren().addAll(ft, fto);
	}
	
	/**
	 * My logo's fade.
	 */
	private void meFade() {
		FadeTransition ft = new FadeTransition(Duration.seconds(2), myLogo);
		ft.setFromValue(0.0);
		ft.setToValue(1.0);
		FadeTransition fto = new FadeTransition(Duration.seconds(2), myLogo);
		fto.setFromValue(1.0);
		fto.setToValue(0.0);
		seqT.getChildren().addAll(ft, fto);
	}

}