package battlenetwork.model;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public abstract class Entity {
	private Position position;
	
	public Entity(Position p){
		this.position = p;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	
	/**
	 * Runs once every frame
	 * @param gc
	 * @param game
	 * @param i
	 */
	public abstract void update(GameContainer gc, StateBasedGame game, int i);

}
