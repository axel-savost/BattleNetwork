package battlenetwork.model;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import battlenetwork.model.utility.*;

public class Mettaur extends Enemy {
	
	public Mettaur(Position position) {
		super(position);
		setHp(40);
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame game, int i) {
		super.update(gc, game, i);
		if (getHeading()==Direction.NONE && readyToMove()){
			Direction d=Direction.randomDirection();
			setHeading(d);
			setMoveDelay(5*Constants.MOVE_DELAY);
		}
		
		
	}
}
