package battlenetwork.model;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public class Navi extends Actor{
	private final int playerID;

	public Navi(Position p, int playerID) {
		super(p);
		this.playerID = playerID;
	}
	
	public Navi(Position p){
		this(p,1);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int i) {
		// TODO Auto-generated method stub
		
	}

	public int getPlayerID() {
		return playerID;
	}


}
