package battlenetwork.model;

import java.awt.Color;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public class Panel extends Entity{
	private Side side;
	private Type type;

	public Panel(Position p, Side side) {
		super(p);
		this.side = side;
		this.type = Type.NORMAL;
	}
	
	public Panel(Position p){
		this(p,Side.NEUTRAL);
	}
	
	public enum Type{
		NORMAL, CRACKED, BROKEN, GRASS, LAVA, SAND, METAL, HOLY, POISON;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int i) {
		// TODO Auto-generated method stub
		
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Side getSide() {
		return side;
	}

	public void setSide(Side side) {
		this.side = side;
	}

}
