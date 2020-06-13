package control;

/**
 * LABORATORIO 3: ENTRENAMIENTO POKÉMON
 * @author Johan Camilo Cortés Ocampo
 * 16 / 09 / 2018
 */

import control.PokemonSelectionController;

//import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import view.Main;

public class MainWindowController implements Initializable{
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//CONSTANTES
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	private final int THROW_TRAINING = 1, CATCH_TRAINING = 2;

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//ATRIBUTOS
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
   
	@FXML
    private VBox container;
    @FXML
    private Button throwTrainingButton;
    @FXML
    private Button catchTrainingButton;
    
 //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 //MÉTODOS
 //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) { container.setStyle("-fx-background-color: #E0ECFF"); }
    
	/**
	 * Maneja el evento de hacer click en el botón del modo de entrenamiento 'Lanzar'.
	 * @param event - Evento de ratón.
	 */
    @FXML
    public void enterToCatchTraining(ActionEvent event) {
    	try {
			changeScene(CATCH_TRAINING);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    /**
     *  Maneja el evento de hacer click en el botón del modo de entrenamiento 'Atrapar'.
     * @param event - Evento de ratón.
     */
    @FXML
    public void enterToThrowTraining(ActionEvent event) {
    	try {
			changeScene(THROW_TRAINING);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    /**
     * Cambia el escenario.
     * @param training - tipo de entrenamiento.
     * @throws Exception
     */
	private void changeScene(int training) throws Exception {
		Parent scene = null;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/PokemonSelectionWindow.fxml"));
		scene = loader.load();
		PokemonSelectionController controller = loader.getController();
		controller.defineTypeOfTraining(training);
		Main.stage.setScene(new Scene(scene));
		Main.stage.centerOnScreen();
	}
}
