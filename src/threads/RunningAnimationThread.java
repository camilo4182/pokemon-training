package threads;

/**
 * LABORATORIO 3: ENTRENAMIENTO POK�MON
 * @author Johan Camilo Cort�s Ocampo
 * 16 / 09 / 2018
 */

import control.GameWindowController;
import control.PokemonSelectionController;

public class RunningAnimationThread extends Thread{

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//ASOCIACI�N CON EL CONTROLADOR DE LA VENTANA DE JUEGO
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	private GameWindowController game;
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//M�TODOS
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	
	/**
	 * Constructor de la clase.
	 * @param game - asociaci�n con el controlador.
	 */
	public RunningAnimationThread(GameWindowController game) { this.game = game; }
	
	@Override
	public void run() {
		int limit = 3;
		String pokemonName = game.getPokemon().getName().toLowerCase();
		if(pokemonName.equalsIgnoreCase(PokemonSelectionController.NAME_0)) { limit = 6; }
		for(int i = 0; i <= limit && !(game.getFlag().getLayoutX() >= game.getPokemon().getCurrentXPosition()) && !game.getPokemon().isCaught(); i++) {
			game.getPokemon().changeImage("/images/"+pokemonName+"_frames/"+i+".png");
			game.updateImage("/images/"+pokemonName+"_frames/"+i+".png");
			if(i == limit) { i = 0; }
			try {
				if(pokemonName.equalsIgnoreCase(PokemonSelectionController.NAME_1) || pokemonName.equalsIgnoreCase(PokemonSelectionController.NAME_2)) { sleep(100); }
				else { sleep(30); }
			} catch (InterruptedException e) { e.printStackTrace(); }
		}
		if(!game.getPokemon().isCaught()) { game.stopRunningPokemon(); }
	}
}
