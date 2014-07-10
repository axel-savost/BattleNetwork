package battlenetwork.model;

import java.util.Queue;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import battlenetwork.model.BattleModel.Key;
import battlenetwork.model.card.Card;
import battlenetwork.model.utility.Position;
import battlenetwork.model.utility.Side;

public class Navi extends Actor{
	private final int playerID;

	public Navi(Position p, int playerID) {
		super(p);
		this.playerID = playerID;
		this.setSide(Side.LEFT);
	}
	
	public Navi(Position p){
		this(p,0);
	}

	public int getPlayerID() {
		return playerID;
	}
	
	

}
