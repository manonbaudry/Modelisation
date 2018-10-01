package donnees;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class Plan extends Application {

	private int size;
	private Modele m;
	private int[][][] plan;

	public Plan(int size, Modele m) {
		this.size = size;
		this.m = m;
		ChargeModele.chargeModele(m, new File("ressources/dolphin.ply"));
		this.plan = new int[this.size][this.size][this.size];
	}

	public int getSize() {
		return size;
	}

	@Override
	public void start(Stage arg0) throws Exception {
		Group root = new Group();
		Canvas canvas = new Canvas(300, 250);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		drawModele(gc);
		root.getChildren().add(canvas);
		Scene scene = new Scene(root);
		Stage s = new Stage();
		s.setScene(scene);
		s.setTitle("3D scene");
		s.show();	
	}
	
	public void drawModele(GraphicsContext gc) {
		for(int i=0;i<m.getSegments().size();i++) {
			Segment seg = m.getSegments().get(i);
			gc.strokeLine(seg.getPointA().getX(), seg.getPointA().getY(), seg.getPointB().getX(), seg.getPointB().getY());
		}
	}
}
