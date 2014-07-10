package battlenetwork.model.panel;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import battlenetwork.model.Actor;
import battlenetwork.model.Entity;
import battlenetwork.model.utility.Position;
import battlenetwork.model.utility.Side;

public abstract class Panel extends Entity{
	private Side side;

	public Panel(Position p, Side side) {
		super(p);
		this.side = side;
	}
	
	public Panel(Position p){
		this(p,Side.NEUTRAL);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int i) {
		// TODO Auto-generated method stub
		
	}

	public Side getSide() {
		return side;
	}

	public void setSide(Side side) {
		this.side = side;
	}
	
	/**
	 * Called when an Actor is placed on this panel
	 */
	public abstract void stepOn(Actor a);
	
	/**
	 * Called when an Actor steps off this panel
	 * @param a 
	 */
	public abstract void stepOff(Actor a);
	
	/**
	 * Returns the panel this panel changes to when an Actor enters.
	 * If null is returned, the panel won't change.
	 * @return Said panel
	 */
	public abstract Panel enteringChange();
	
	/**
	 * Returns the panel this panel changes to when an Actor leaves.
	 * If null is returned, the panel won't change.
	 * @return Said panel
	 */
	public abstract Panel leavingChange();
	
	
	
	

}
