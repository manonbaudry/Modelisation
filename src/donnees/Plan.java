package donnees;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class Plan extends Application {

	private int size;
	private Modele m;
	private Canvas canvas;

	public Plan(int size, Modele m, String image) {
		this.size = size;
		this.m = m;
		canvas = new Canvas(1000, 800);
		ChargeModele.chargeModele(m, new File(image));
	}

	public int getSize() {
		return size;
	}

	@Override
	public void start(Stage s) throws Exception {
		Group root = new Group();
		HBox commande = new HBox();
		
		Button gauche = new Button("<-");
		Button droite = new Button("->");
		Button plus = new Button("-");
		Button moins = new Button("+");
		Button rotateGauche = new Button("↶");
		Button rotateDroite = new Button("↷");
		
		commande.getChildren().addAll(gauche, moins, rotateGauche, rotateDroite, plus, droite);
		
		GraphicsContext gc = canvas.getGraphicsContext2D();
		root.getChildren().addAll(canvas, commande);
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
