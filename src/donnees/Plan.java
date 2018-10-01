package donnees;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class Plan extends Application {

	private int size;
	private Modele m;
	private int[][][] plan;
	private Canvas canvas;

	public Plan(int size, Modele m) {
		this.size = size;
		this.m = m;
		canvas = new Canvas(1000, 800);
		ChargeModele.chargeModele(m, new File("ressources/dolphin.ply"));
		this.plan = new int[this.size][this.size][this.size];
	}

	public int getSize() {
		return size;
	}

	@Override
	public void start(Stage s) throws Exception {
		Group root = new Group();
		
		GraphicsContext gc = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		Scene scene = new Scene(root);
		m.triFaces(m.getFaces());
		drawModele(gc);
		s.setScene(scene);
		s.setTitle("3D scene");
		s.show();	
	}
	
	public void drawModele(GraphicsContext gc) {
		for (int i = 0; i < m.getFaces().size(); i++) {
			double[] xPoints = m.getFaces().get(i).xPoints();
			double[] yPoints = m.getFaces().get(i).yPoints();
			for (int j = 0; j < yPoints.length; j++) {
				yPoints[j]+=canvas.getHeight()/2;
			}
			for (int j = 0; j < xPoints.length; j++) {
				xPoints[j]+=canvas.getWidth()/2;
			}
			gc.fillPolygon(xPoints, yPoints, 3);
			gc.setFill(Color.GRAY);
		}
		for(int i=0;i<m.getSegments().size();i++) {
			Segment seg = m.getSegments().get(i);
			gc.strokeLine(seg.getPointA().getX()+canvas.getWidth()/2, seg.getPointA().getY()+canvas.getHeight()/2, seg.getPointB().getX()+canvas.getWidth()/2, seg.getPointB().getY()+canvas.getHeight()/2);
		}
	}
}
