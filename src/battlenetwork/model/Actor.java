package battlenetwork.model;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import battlenetwork.model.BattleModel.Key;

/**
 * An actor is acting in battle. This means it's on the battlefield and can be affected by other actors.
 * 
 * @author Axel
 */
public abstract class Actor extends Entity implements IControllable{
	private int hp;
	private Direction heading;
	private int moveDelay = 0;
	
	public Actor(Position p){
		super(p);
		
		heading = Direction.NONE;
	}

	@Override
	public void pressKey(Key key) {
		switch(key){
		case UP:
			if (heading == Direction.NONE && moveDelay <= 0){
				heading = Direction.UP;
				moveDelay = Constants.MOVE_DELAY;
			}
			break;
		case DOWN:
			if (heading == Direction.NONE && moveDelay <= 0){
				heading = Direction.DOWN;
				moveDelay = Constants.MOVE_DELAY;
			}
			break;
		case LEFT:
			if (heading == Direction.NONE && moveDelay <= 0){
				heading = Direction.LEFT;
				moveDelay = Constants.MOVE_DELAY;
			}
			break;
		case RIGHT:
			if (heading == Direction.NONE && moveDelay <= 0){
				heading = Direction.RIGHT;
				moveDelay = Constants.MOVE_DELAY;
			}
			break;
		case PRIMARY:
			
			break;
		case SECONDARY:
			
			break;
		default:
			break;
		}
		
	}

	@Override
	public void releaseKey(Key key) {
		// TODO Auto-generated method stub
		
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
		}
	}
	
	public void die(){
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int i) {
		if (moveDelay > 0){
			moveDelay--;
		}
		
	}
	
	
	

}
