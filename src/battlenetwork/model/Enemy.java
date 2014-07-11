package battlenetwork.model;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import battlenetwork.model.utility.*;

public class Enemy extends Actor {

	public Enemy(Position position) {
		super(position);
		this.setSide(Side.RIGHT);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int i) {
		super.update(gc, game, i);
		if (getHeading()==Direction.NONE && readyToMove()){
			Direction d=Direction.randomDirection();
			setHeading(d);
			setMoveDelay(5*Constants.MOVE_DELAY);
			System.out.println("enemy dir: "+d);
		}
		
		
	}

}
