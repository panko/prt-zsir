package prt.ppeter.zsir;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class Main extends Application
{
	private static final String NAME = "Zsir";
	private static final String VERSION = "0.1";
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static final int MARGIN = 10;

    
    public static void main( String[] args )
    {
    	launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle(NAME + " " + VERSION);
		GridPane root = new GridPane();
        root.setStyle("-fx-background-color: black;");
        root.setHgap(MARGIN);
        root.setVgap(MARGIN);
        root.setPadding(new Insets(MARGIN));
        
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
		
		
        primaryStage.show();
		
	}
}
