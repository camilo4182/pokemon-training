package threads;

/**
 * LABORATORIO 3: ENTRENAMIENTO POK�MON
 * @author Johan Camilo Cort�s Ocampo
 * 16 / 09 / 2018
 */

import control.GameWindowController;
import control.PokemonController;

public class MovementThread extends Thread{

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//ASOCIACIONES CON EL HILO DE LA ANIMACI�N Y EL CONTROLADOR DE LA VENTANA DE JUEGO
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	private GameWindowController game;
	private PokemonController pokemonControl;
	private RunningAnimationThread animation;

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//M�TODOS
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * Constructor de la clase.
	 * @param game asociaci�n con el controlador.
	 * @param pokemonControl - asociaci�n con el controlador del pokemon.
	 */
	public MovementThread(GameWindowController game, PokemonController pokemonControl) {
		this.game = game;
		this.pokemonControl = pokemonControl;
		animation = new RunningAnimationThread(game);
	}
	

	@Override
	public void run() {
		animation.start();
		while(!(game.getFlag().getLayoutX() >= game.getPokemon().getCurrentXPosition()) && !game.getPokemon().isCaught()) { pokemonControl.start(); }
		game.showDistance();
	}
}
