package model;

/**
 * LABORATORIO 3: ENTRENAMIENTO POKÉMON
 * @author Johan Camilo Cortés Ocampo
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
//MÉTODOS
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * Constructor de la clase Pokemon.
	 * @param pokemonNumber - Número que identifica al pokemon seleccionado.
	 * @param caught - Indica si el pokemon está en una pokebola.
	 * @param directory - Directorio donde se encuentra la imagen del pokemon que se muestra en la interfaz gráfica.
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
	 * Cambia la imagen del pokemon en la interfaz gráfica.
	 * @param newDirectory - Directorio de la imagen.
	 */
	public void changeImage(String newDirectory) {
		img = null;
		img = new Image(newDirectory);
	}
	
	/**
	 * Cambia el valor de la variable caught cuando el pokemon es atrapado o liberado de su pokebola.
	 * @param value - Valor que se almacenará en la variable.
	 */
	public void setCaughtValue(boolean value) { caught = value; }
	
	/**
	 * Cambia la posición actual del pokemon en el eje X.
	 * @param value - Nueva coordenada en X.
	 */
	public void setCurrentXPositionValue(double value) { currentXPosition = value; }
	
	/**
	 * Devuelve el número que identifica al pokemon.
	 * @return número del pokemon.
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
	 * Indica si el pokemon está en su pokebola o no.
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
