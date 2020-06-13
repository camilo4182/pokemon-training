package control;

/**
 * LABORATORIO 3: ENTRENAMIENTO POKÉMON
 * Esta clase se encarga de controlar la animación de correr del pokemon.
 * @author Johan Camilo Cortés Ocampo
 * 16 / 09 / 2018
 */

import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;
import model.Pokemon;

public class PokemonController extends AnimationTimer{

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//ATRIBUTOS
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	private long previousTime;
	private ImageView pokemonImg, flag;
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//ASOCIACIÓN CON EL MODELO
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	private Pokemon chosenPokemon;
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//MÉTODOS
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * Constructor de la clase.
	 * @param chosenPokemon - Objeto Pokemon seleccionado.
	 * @param pokemonImg - Imagen que representa al Objeto Pokemon en la interfaz gráfica.
	 * @param flag - Imagen de la bandera.
	 */
	public PokemonController(Pokemon chosenPokemon, ImageView pokemonImg, ImageView flag) {
		this.chosenPokemon = chosenPokemon;
		this.pokemonImg = pokemonImg;
		this.flag = flag;
		previousTime = System.nanoTime();
	}
	
	@Override
	public void handle(long now) {
		if (flag.getLayoutX() >= chosenPokemon.getCurrentXPosition() || chosenPokemon.isCaught()){ stop(); }
		double elapseTime = (now - previousTime) / 1000000000.0;
		previousTime = now;
		double scale = elapseTime*chosenPokemon.getVelocity();
		chosenPokemon.setCurrentXPositionValue(chosenPokemon.getCurrentXPosition() - chosenPokemon.getCurrentXPosition()*scale);
		pokemonImg.setLayoutX(chosenPokemon.getCurrentXPosition());
	}
}
