package IHM;

import donnees.Modele;
import donnees.Plan;
import javafx.application.Application;
import javafx.stage.Stage;

public class main extends Application {

	private static Plan p;
	private static Modele m;

	public void start(Stage primaryStage) throws Exception {
		p.start(new Stage());
	}


	public static void main(String[] args) throws Exception {
		m = new Modele();
		p = new Plan(m, "ressources/apple.ply");
		Application.launch(args);
	}
}
