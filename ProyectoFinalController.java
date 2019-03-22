package proyectoFinal;

import java.io.File;
import java.net.MalformedURLException;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class ProyectoFinalController {
	
	@FXML
	private Pane paneCancha;

	private Avion avion;

	@FXML
	public void initialize() throws MalformedURLException{
		
		Rectangle clip = new Rectangle(0, 0, 0, 0);
		clip.widthProperty().bind(paneCancha.widthProperty());
		clip.heightProperty().bind(paneCancha.heightProperty());
		paneCancha.setClip(clip);

		avion = new Avion();
		anadirImagen();
		paneCancha.getChildren().add(avion);
	}

	public void anadirImagen() throws MalformedURLException {
		File fileP = new File("img/avion.png");
		String localUrlP = fileP.toURI().toURL().toString();
		Image imgAvion = new Image(localUrlP);
		avion.setFill(new ImagePattern(imgAvion));
	}

	@FXML
	public void botonSalir() {
		System.exit(0);
	}
	

	@FXML
	public void keyMoveHnd(KeyEvent ke) {
		double x = avion.getCenterX();
		double y = avion.getCenterY();

		switch (ke.getCode()) {
		case LEFT:
			x-=8;
			break;
		case RIGHT:
			x+=8;
		default:
			System.out.println("KeyMoveHnd:" + ke.getCode());
			break;
		}
		ke.consume();

		avion.setCenterX(x);
		avion.setCenterY(y);
	}
}