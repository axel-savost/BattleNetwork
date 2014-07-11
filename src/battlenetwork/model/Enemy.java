package battlenetwork.model;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import battlenetwork.model.utility.*;

public abstract class Enemy extends Actor {


	public Enemy(Position position) {
		super(position);
		this.setSide(Side.RIGHT);
	}

}
