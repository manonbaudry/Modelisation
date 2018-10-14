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
import math.CalculMatrice;
import math.Matrice;

public class Plan extends Application {

	private Modele m;
	private Canvas canvas;
	private int x ;
	private int y;

	public Plan(Modele m, String image) {
		this.m = m;
		canvas = new Canvas(1000, 800);
		ChargeModele.chargeModele(m, new File(image));
		x = 0;
		y = 0;
	}

	@Override
	public void start(Stage s) throws Exception {
		Group root = new Group();
		HBox commande = new HBox();
		
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		Button gauche = new Button("<-");
		gauche.setOnAction(e->{
			for (int i = 0; i < m.getPoints().size(); i++) {
				Point p = m.getPoints().get(i);
				Matrice mt = CalculMatrice.translation(CalculMatrice.vecteur(-10, 0, 0), CalculMatrice.vecteur(p.getX(), p.getY(), p.getZ()));
				p.setX(mt.getCoord(0, 0));
				p.setY(mt.getCoord(1, 0));
				p.setZ(mt.getCoord(2, 0));
			}
			m.triFaces(m.getFaces());
			drawModele(gc);
		});
		Button droite = new Button("->");
		droite.setOnAction(e->{
			for (int i = 0; i < m.getPoints().size(); i++) {
				Point p = m.getPoints().get(i);
				Matrice mt = CalculMatrice.translation(CalculMatrice.vecteur(10, 0, 0), CalculMatrice.vecteur(p.getX(), p.getY(), p.getZ()));
				p.setX(mt.getCoord(0, 0));
				p.setY(mt.getCoord(1, 0));
				p.setZ(mt.getCoord(2, 0));
			}
			m.triFaces(m.getFaces());
			drawModele(gc);
		});
		Button haut = new Button("↑");
		haut.setOnAction(e->{
			for (int i = 0; i < m.getPoints().size(); i++) {
				Point p = m.getPoints().get(i);
				Matrice mt = CalculMatrice.translation(CalculMatrice.vecteur(0, -10, 0), CalculMatrice.vecteur(p.getX(), p.getY(), p.getZ()));
				p.setX(mt.getCoord(0, 0));
				p.setY(mt.getCoord(1, 0));
				p.setZ(mt.getCoord(2, 0));
			}
			m.triFaces(m.getFaces());
			drawModele(gc);
		});
		Button bas = new Button("↓");
		bas.setOnAction(e->{
			for (int i = 0; i < m.getPoints().size(); i++) {
				Point p = m.getPoints().get(i);
				Matrice mt = CalculMatrice.translation(CalculMatrice.vecteur(0, 10, 0), CalculMatrice.vecteur(p.getX(), p.getY(), p.getZ()));
				p.setX(mt.getCoord(0, 0));
				p.setY(mt.getCoord(1, 0));
				p.setZ(mt.getCoord(2, 0));
			}
			m.triFaces(m.getFaces());
			drawModele(gc);
		});
		Button plus = new Button("-");
		plus.setOnAction(e->{
			for (int i = 0; i < m.getPoints().size(); i++) {
				Point p = m.getPoints().get(i);
				Matrice mt = CalculMatrice.chgmtEchelle(CalculMatrice.vecteur(0.5, 0.5, 0.5), CalculMatrice.vecteur(p.getX(), p.getY(), p.getZ()));
				p.setX(mt.getCoord(0, 0));
				p.setY(mt.getCoord(1, 0));
				p.setZ(mt.getCoord(2, 0));
			}
			m.triFaces(m.getFaces());
			drawModele(gc);
		});
		Button moins = new Button("+");
		moins.setOnAction(e->{
			for (int i = 0; i < m.getPoints().size(); i++) {
				Point p = m.getPoints().get(i);
				Matrice mt = CalculMatrice.chgmtEchelle(CalculMatrice.vecteur(2, 2, 2), CalculMatrice.vecteur(p.getX(), p.getY(), p.getZ()));
				p.setX(mt.getCoord(0, 0));
				p.setY(mt.getCoord(1, 0));
				p.setZ(mt.getCoord(2, 0));
			}
			m.triFaces(m.getFaces());
			drawModele(gc);
		});
		Button rotateGauche = new Button("↶");
		rotateGauche.setOnAction(e->{
			for (int i = 0; i < m.getPoints().size(); i++) {
				Point p = m.getPoints().get(i);
				Matrice mt = CalculMatrice.rotationZ(CalculMatrice.vecteur(p.getX(), p.getY(), p.getZ()), Math.PI/16);
				p.setX(mt.getCoord(0, 0));
				p.setY(mt.getCoord(1, 0));
				p.setZ(mt.getCoord(2, 0));
			}
			m.triFaces(m.getFaces());
			drawModele(gc);
		});
		Button rotateDroite = new Button("↷");
		rotateDroite.setOnAction(e->{
			for (int i = 0; i < m.getPoints().size(); i++) {
				Point p = m.getPoints().get(i);
				Matrice mt = CalculMatrice.rotationZ(CalculMatrice.vecteur(p.getX(), p.getY(), p.getZ()), -Math.PI/16);
				p.setX(mt.getCoord(0, 0));
				p.setY(mt.getCoord(1, 0));
				p.setZ(mt.getCoord(2, 0));
			}
			m.triFaces(m.getFaces());
			drawModele(gc);
		});
		
		canvas.setOnScroll(e->{
			if (e.getDeltaY() > 0) {
				for (int i = 0; i < m.getPoints().size(); i++) {
					Point p = m.getPoints().get(i);
					Matrice mt = CalculMatrice.chgmtEchelle(CalculMatrice.vecteur(2, 2, 2), CalculMatrice.vecteur(p.getX(), p.getY(), p.getZ()));
					p.setX(mt.getCoord(0, 0));
					p.setY(mt.getCoord(1, 0));
					p.setZ(mt.getCoord(2, 0));
				}
				m.triFaces(m.getFaces());
				drawModele(gc);
			}else {
				for (int i = 0; i < m.getPoints().size(); i++) {
					Point p = m.getPoints().get(i);
					Matrice mt = CalculMatrice.chgmtEchelle(CalculMatrice.vecteur(0.5, 0.5, 0.5), CalculMatrice.vecteur(p.getX(), p.getY(), p.getZ()));
					p.setX(mt.getCoord(0, 0));
					p.setY(mt.getCoord(1, 0));
					p.setZ(mt.getCoord(2, 0));
				}
				m.triFaces(m.getFaces());
				drawModele(gc);
			}
		});
		
		canvas.setOnMouseClicked(e->{
			x = (int) e.getX();
			y = (int) e.getY();
		});
		
		canvas.setOnMouseDragged(e->{
			float xTemp = (float)e.getX();
			int nb = 1;
			if ((xTemp-x)<0) {
				nb = -1;
			}
			float yTemp = (float)e.getY();
			int nbY = 1;
			if ((yTemp-y)<0) {
				nbY = -1;
			}
			if (nb > 0 && xTemp != x) {
				for (int i = 0; i < m.getPoints().size(); i++) {
					Point p = m.getPoints().get(i);
					Matrice mt = CalculMatrice.rotationY(CalculMatrice.vecteur(p.getX(), p.getY(), p.getZ()), Math.PI/32);
					p.setX(mt.getCoord(0, 0));
					p.setY(mt.getCoord(1, 0));
					p.setZ(mt.getCoord(2, 0));
				}
				m.triFaces(m.getFaces());
				drawModele(gc);
			}else if(xTemp != x) {
				for (int i = 0; i < m.getPoints().size(); i++) {
					Point p = m.getPoints().get(i);
					Matrice mt = CalculMatrice.rotationY(CalculMatrice.vecteur(p.getX(), p.getY(), p.getZ()), -Math.PI/32);
					p.setX(mt.getCoord(0, 0));
					p.setY(mt.getCoord(1, 0));
					p.setZ(mt.getCoord(2, 0));
				}
				m.triFaces(m.getFaces());
				drawModele(gc);
			}
			if (nbY > 0 && yTemp != y) {
				for (int i = 0; i < m.getPoints().size(); i++) {
					Point p = m.getPoints().get(i);
					Matrice mt = CalculMatrice.rotationX(CalculMatrice.vecteur(p.getX(), p.getY(), p.getZ()), Math.PI/32);
					p.setX(mt.getCoord(0, 0));
					p.setY(mt.getCoord(1, 0));
					p.setZ(mt.getCoord(2, 0));
				}
				m.triFaces(m.getFaces());
				drawModele(gc);
			}else if (yTemp != y) {
				for (int i = 0; i < m.getPoints().size(); i++) {
					Point p = m.getPoints().get(i);
					Matrice mt = CalculMatrice.rotationX(CalculMatrice.vecteur(p.getX(), p.getY(), p.getZ()), -Math.PI/32);
					p.setX(mt.getCoord(0, 0));
					p.setY(mt.getCoord(1, 0));
					p.setZ(mt.getCoord(2, 0));
				}
				m.triFaces(m.getFaces());
				drawModele(gc);
			}
		});
		
		commande.getChildren().addAll(gauche, haut, moins, rotateGauche, rotateDroite, plus, bas, droite);
		
		root.getChildren().addAll(canvas, commande);
		Scene scene = new Scene(root);
		m.triFaces(m.getFaces());
		drawModele(gc);
		s.setScene(scene);
		s.setTitle("3D scene");
		s.show();	
	}
	
	public void drawModele(GraphicsContext gc) {
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
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
