package dad;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinApp extends Application {

	int numero = (int) (Math.random() * 100) + 1;
	Label titulo;
	Button boton;
	TextField texto;
	int cont = 0;

	@Override
	public void start(Stage primaryStage) throws Exception {

		titulo = new Label("Introduce un número de 1 al 100");
		boton = new Button("comprobar");
		texto = new TextField();

		boton.setOnAction(e -> verificar(e));

		texto.setMaxWidth(120);

		VBox caja = new VBox(9, titulo, texto, boton);
		caja.setAlignment(Pos.CENTER);

		Scene scene = new Scene(caja, 320, 220);
		primaryStage.setTitle("AdivinApp");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void verificar(ActionEvent e) {
		cont++;
		int valor;
		Alert alerta = new Alert(null);
		alerta.setTitle("AdivinApp");
		try {
			valor = Integer.parseInt(texto.getText());
			if (valor == numero) {
				alerta.setAlertType(AlertType.INFORMATION);
				alerta.setHeaderText("¡Has ganado!");
				alerta.setContentText("Solo has necesitado " + cont + " intento\n vuelve intentarlo");
			} else {
				String comparar;
				if (valor < numero) {
					comparar = "mayor";
				} else {
					comparar = "menor";
				}
				alerta.setAlertType(AlertType.WARNING);
				alerta.setHeaderText("¡Has fallado!");
				alerta.setContentText("El número a adivinar es " + comparar + " que " + valor);
			}
		} catch (Exception e2) {
			alerta.setAlertType(AlertType.ERROR);
			alerta.setHeaderText("Error");
			alerta.setContentText("El número introfucido no es valido");
		}
		alerta.showAndWait();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
