package donnees;

import javafx.application.Application;
import javafx.stage.Stage;

public class main extends Application {

	private Plan p = new Plan(5, null);

	public void start(Stage primaryStage) throws Exception {
		p.start(new Stage());
	}


	public static void main(String[] args) {
		Application.launch(args);
	}
}