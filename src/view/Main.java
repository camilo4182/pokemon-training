package view;

/**
 * LABORATORIO 3: ENTRENAMIENTO POK�MON
 * @author Johan Camilo Cort�s Ocampo
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
//M�TODOS
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@Override
	public void start(Stage stage) {
		try {
			Main.stage = stage;
			Parent root = FXMLLoader.load(getClass().getResource("/view/MainWindow.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Main.stage.setTitle("Entrenamiento Pok�mon");
			Main.stage.setScene(scene);
			Main.stage.setResizable(false);
			Main.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * M�todo principal.
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
