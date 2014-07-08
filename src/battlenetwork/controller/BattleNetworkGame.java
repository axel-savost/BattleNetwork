package battlenetwork.controller;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class BattleNetworkGame extends StateBasedGame{

	public BattleNetworkGame(String name) {
		super(name);
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		BattleState b = new BattleState();
		this.addState(b);
		this.enterState(b.getID());
		
	}
}
