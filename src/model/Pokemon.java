package model;

/**
 * LABORATORIO 3: ENTRENAMIENTO POK�MON
 * @author Johan Camilo Cort�s Ocampo
 * 16 / 09 / 2018
 */

import javafx.scene.image.Image;

public class Pokemon{
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//CONSTANTES	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public static final double INITIAL_X_POSITION = 615;
	public static final double INITIAL_Y_POSITION = 303;

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//ATRIBUTOS
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	private int velocity, pokemonNumber;
	private double currentXPosition;
	private boolean caught;
	private String name;
	private Image img;
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
//M�TODOS
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * Constructor de la clase Pokemon.
	 * @param pokemonNumber - N�mero que identifica al pokemon seleccionado.
	 * @param caught - Indica si el pokemon est� en una pokebola.
	 * @param directory - Directorio donde se encuentra la imagen del pokemon que se muestra en la interfaz gr�fica.
	 * @param name - Nombre del pokemon.
	 */
	public Pokemon(int pokemonNumber, boolean caught, String directory, String name) {
		currentXPosition = INITIAL_X_POSITION;
		this.caught = caught;
		this.name = name;
		this.pokemonNumber = pokemonNumber;
		img = new Image(directory);
		velocity = 1;
	}
	
	/**
	 * Cambia la imagen del pokemon en la interfaz gr�fica.
	 * @param newDirectory - Directorio de la imagen.
	 */
	public void changeImage(String newDirectory) {
		img = null;
		img = new Image(newDirectory);
	}
	
	/**
	 * Cambia el valor de la variable caught cuando el pokemon es atrapado o liberado de su pokebola.
	 * @param value - Valor que se almacenar� en la variable.
	 */
	public void setCaughtValue(boolean value) { caught = value; }
	
	/**
	 * Cambia la posici�n actual del pokemon en el eje X.
	 * @param value - Nueva coordenada en X.
	 */
	public void setCurrentXPositionValue(double value) { currentXPosition = value; }
	
	/**
	 * Devuelve el n�mero que identifica al pokemon.
	 * @return n�mero del pokemon.
	 */
	public int getPokemonNumber() { return pokemonNumber; }
	
	/**
	 * Devuelve la velocidad con la que se desplaza el pokemon.
	 * @return velocidad del pokemon.
	 */
	public int getVelocity() { return velocity; }
	
	/**
	 * Devuelve la coordenada actual en X del pokemon.
	 * @return coordenada actual en X.
	 */
	public double getCurrentXPosition() { return currentXPosition; }
	
	/**
	 * Indica si el pokemon est� en su pokebola o no.
	 * @return valor booleano.
	 */
	public boolean isCaught() { return caught; }
	
	/**
	 * Devuelve el nombre del pokemon.
	 * @return nombre del pokemon.
	 */
	public String getName() { return name; }
	
	/**
	 * Devuelve la imagen que representa al pokemon seleccionado.
	 * @return Imagen.
	 */
	public Image getPokemonImage() { return img; }
}
