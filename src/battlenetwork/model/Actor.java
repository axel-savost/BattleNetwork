package battlenetwork.model;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import battlenetwork.model.BattleModel.Key;
import battlenetwork.model.utility.Constants;
import battlenetwork.model.utility.Direction;
import battlenetwork.model.utility.Position;
import battlenetwork.model.utility.Side;
import battlenetwork.view.SoundBox;

/**
 * An actor is acting in battle. This means it's on the battlefield and can be affected by other actors.
 * 
 * @author Axel
 */
public abstract class Actor extends Entity {
	private int hp;
	private Direction heading;
	private int moveDelay = 0;
	private Side side;
	
	public Actor(Position p){
		super(p);
		
		heading = Direction.NONE;
		
		//TODO Tempfix
		hp = 200;
	}



	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public void takeDamage(int damage){
		hp -= damage;
		if (hp <= 0){
			die();
			SoundBox.play("death");
		} else {
			SoundBox.play("hit");
		}
		
		
	}
	
	public void die(){
		System.out.println(this + " is dead! May he/she/it rest in peace.");
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int i) {
		if (moveDelay > 0){
			moveDelay=moveDelay-i;
		}
		
	}

	public Direction getHeading() {
		return heading;
	}
	
	public void setHeading(Direction d) {
		heading = d;
	}
	
	public void setMoveDelay(int i) {
		moveDelay=i;
	}
	
	public boolean readyToMove(){
		return moveDelay <= 0;
	}

	public Side getSide() {
		return side;
	}

	public void setSide(Side side) {
		this.side = side;
	}

}
