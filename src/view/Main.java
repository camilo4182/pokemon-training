package view;

/**
 * LABORATORIO 3: ENTRENAMIENTO POKÉMON
 * @author Johan Camilo Cortés Ocampo
 * 16 / 09 / 2018
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//ATRIBUTO
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public static Stage stage;
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//MÉTODOS
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@Override
	public void start(Stage stage) {
		try {
			Main.stage = stage;
			Parent root = FXMLLoader.load(getClass().getResource("/view/MainWindow.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Main.stage.setTitle("Entrenamiento Pokémon");
			Main.stage.setScene(scene);
			Main.stage.setResizable(false);
			Main.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Método principal.
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
