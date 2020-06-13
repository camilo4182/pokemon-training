package control;

/**
 * LABORATORIO 3: ENTRENAMIENTO POKÉMON
 * @author Johan Camilo Cortés Ocampo
 * 16 / 09 / 2018
 */

import model.Pokemon;
import threads.MovementThread;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class GameWindowController implements Initializable{
    
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//ATRIBUTOS
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	@FXML
    private Pane pane;
    @FXML
    private ImageView pokemonImg;
    @FXML
    private ImageView flag;
    private int typeOfTraining;
    
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//ASOCIACIÓN CON EL MODELO
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    private Pokemon chosenPokemon;
    
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//MÉTODOS
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) { pane.setStyle("-fx-background-image: url(/images/background.png)"); }
	
	/**
	 * Inicia la ventana de juego con el campo de entranamiento y las conficuraciones indicadas de acuerdo al tipo de entrenamiento que eligió el usuario.
	 * @param typeOfTraining - Valor que representa el tipo de entrnamiento.
	 * @param pokemonNumber - Número del pokemon.
	 * @param caughtValue - Indica si está en la pokebola.
	 * @param name - Nombre del pokemon.
	 */
	public void configureScene(int typeOfTraining, int pokemonNumber, boolean caughtValue, String name) {
		this.typeOfTraining = typeOfTraining;
		String directoryImage = null;
		switch(this.typeOfTraining) {
			case 1: directoryImage = "/images/pokeball.png";
				break;
			case 2: directoryImage = "/images/"+pokemonNumber+".png";
		}
		chosenPokemon = new Pokemon(pokemonNumber, caughtValue, directoryImage, name);
		pokemonImg.setImage(chosenPokemon.getPokemonImage());
		if(!caughtValue) { startTraining(); }
	}
	
	/**
	 * Instancia el hilo del movimiento y lo ejecuta y llama al método handle de la clase control del Pokemon. 
	 */
	private void startTraining() {
		PokemonController pokemonControl = new PokemonController(chosenPokemon, pokemonImg, flag);
		MovementThread pokemonMovementThread = new MovementThread(this, pokemonControl);
		pokemonMovementThread.start();
	}
	
	/**
	 * Cambia la imagen del pokemon a una en la que se encuentra parado cuando el hilo de movimiento se termina de ejecutar.
	 */
	public void stopRunningPokemon() {
		chosenPokemon.changeImage("/images/"+chosenPokemon.getPokemonNumber()+".png");
		pokemonImg.setImage(new Image("/images/"+chosenPokemon.getPokemonNumber()+".png"));
	}
	
	/**
	 * Método que maneja el evento de hacer click izquierdo sobre el pokemon.
	 * @param event - Evento de ratón.
	 */
	@FXML
    public void clickOnPokemon(MouseEvent event){
		switch(typeOfTraining) {
			case 1:
				if(chosenPokemon.isCaught()) {
					chosenPokemon.setCaughtValue(false);
					startTraining();
				}
				break;
			case 2:
				if(chosenPokemon.isCaught()) {}
				else{
					chosenPokemon.setCaughtValue(true);
					chosenPokemon.changeImage("/images/pokeball.png");
					pokemonImg.setImage(chosenPokemon.getPokemonImage());
					inputUserName();
				}
		}
    }
	
	/**
	 * Muestra un cuadro de dialogo en el que el usuario ingresa su nombre, y luego, crea un archivo de texto que contendrá el nombre escrito en el recuadro. 
	 */
	private void inputUserName() {
		File file = new File("username.txt");
		PrintWriter printer = null;
		try {
			printer = new PrintWriter(file);
			String userName = JOptionPane.showInputDialog("Haz atrapado a "+chosenPokemon.getName()+". Ingresa tu nombre.");
			printer.print(userName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			printer.close();
		}
	}
	
	/**
	 * Muestra un cuadro de dialogo con la distancia recorrida por el pokémon hasta llegar a la bandera.
	 */
	public void showDistance() {
		if(typeOfTraining == 1) {
			JOptionPane.showMessageDialog(null, chosenPokemon.getName()+" ha recorrido "+(Pokemon.INITIAL_X_POSITION - flag.getLayoutX()));
		}
		else if(typeOfTraining == 2 && flag.getLayoutX() >= chosenPokemon.getCurrentXPosition()) {
			JOptionPane.showMessageDialog(null, "No pudiste atrapar a "+chosenPokemon.getName()+".");
		}
	}
	/**
	 * Cambia la imagen del pokemon.
	 * @param directoryImg - Directorio con la nueva imagen.
	 */
	public void updateImage(String directoryImg) {
		pokemonImg.setImage(new Image(directoryImg));
		chosenPokemon.changeImage(directoryImg);
	}
	
	/**
	 * Devuelve el tipo de entrenamiento elegido.
	 * @return tipo de entrenamiento.
	 */
	public int getTypeOfTraining() { return typeOfTraining; }
	
	/**
	 * Devuelve el objeto Pokemon.
	 * @return pokemon seleccionado.
	 */
	public Pokemon getPokemon() { return chosenPokemon; }
	
	/**
	 * Devuelve la imagen que muestra bandera en el campo de entrenamiento.
	 * @return imagen de la bandera.
	 */
	public ImageView getFlag() { return flag; }
}
