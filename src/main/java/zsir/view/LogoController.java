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
import javafx.stage.Stage;
import javafx.util.Duration;
import zsir.model.Main;

public class LogoController {

	@FXML
	protected ImageView debLogo;
	
	@FXML
	protected ImageView myLogo;

	@FXML
	protected BorderPane rootPane;
	SequentialTransition seqT;

	public void fade() {
		seqT = new SequentialTransition();
		debFade();
		meFade();
		seqT.play();
		seqT.setOnFinished(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent ae) {
            	try {
					Main.getStage().setScene((new Scene( (Parent) FXMLLoader.load(getClass().getResource("../view/LoginView.fxml")))));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
		});
	}
	
	private void debFade() {
		FadeTransition ft = new FadeTransition(Duration.seconds(2), debLogo);
		ft.setFromValue(0.0);
		ft.setToValue(1.0);
		FadeTransition fto = new FadeTransition(Duration.seconds(2), debLogo);
		fto.setFromValue(1.0);
		fto.setToValue(0.0);
		seqT.getChildren().addAll(ft, fto);
	}
	
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