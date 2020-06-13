package control;

/**
 * LABORATORIO 3: ENTRENAMIENTO POKÉMON
 * @author Johan Camilo Cortés Ocampo
 * 16 / 09 / 2018
 */

import control.GameWindowController;
import view.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class PokemonSelectionController implements Initializable{
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//CONSTANTES
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public static String NAME_0 = "Pikachu", NAME_1 = "Bulbasaur", NAME_2 = "Jolteon"; //Nombres de los pokemons.
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//ATRIBUTOS	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
    @FXML
    private GridPane listOfPokemons; //GridPane que contiene las imagenes de los pokemons para elegir.
    private int typeOfTraining; //Tipo de entrenamiento.
    
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//MÉTODOS	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
    @Override
	public void initialize(URL location, ResourceBundle resources) {}
	
	/**
	 * Asigna un número a la variable para identificar el tipo de entrenamiento elegido por el usuario.
	 * @param type - tipo de entrenamiento.
	 */
    public void defineTypeOfTraining(int type) { typeOfTraining = type; }
    
    /**
     * Maneja el evento de hacer click izquierdo en una de la imagenes del menu de pokemones disponible.
     * @param event - Evento de ratón.
     */
    @FXML
    public void selectPokemon(MouseEvent event) {
    	boolean caughtValue = false;
    	String name = null;
    	if(typeOfTraining == 1) { caughtValue = true; }
    	for(int i = 0; i < listOfPokemons.getChildren().size(); i++) {
    		if(listOfPokemons.getChildren().get(i).equals((ImageView)event.getSource())) {
    			switch(i) {
	    			case 0: name = NAME_0;
	    				break;
	    			case 1: name = NAME_1;
	    				break;
	    			case 2: name = NAME_2;
	    				break;
    			}
    			FXMLLoader loader = new FXMLLoader();
    			loader.setLocation(getClass().getResource("/view/GameWindow.fxml"));
    			Parent scene = null;
    			try {
					scene = loader.load();
				} catch (IOException e) {
					e.printStackTrace();
				}
    			GameWindowController gameWindowController = loader.getController();
    			gameWindowController.configureScene(typeOfTraining, i, caughtValue, name);
    			Main.stage.setScene(new Scene(scene));
    			Main.stage.centerOnScreen();
    		}
    	}
    }
}
