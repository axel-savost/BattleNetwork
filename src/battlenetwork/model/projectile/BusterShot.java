package battlenetwork.model.projectile;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import battlenetwork.model.utility.Position;

public class BusterShot extends Projectile {
	private final int power;

	public BusterShot(Position p, int power) {
		super(p);
		this.power = power;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int i) {
		
		
	}

	

}
