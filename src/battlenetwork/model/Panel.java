package battlenetwork.model;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public class Panel extends Entity{

	public Panel(Position p) {
		super(p);
	}
	
	public enum Type{
		NORMAL, CRACKED, BROKEN, GRASS, LAVA, SAND, METAL, HOLY, POISON;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int i) {
		// TODO Auto-generated method stub
		
	}

}
