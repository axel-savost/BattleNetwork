package battlenetwork.model;



import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import battlenetwork.model.BattleModel.Key;
import battlenetwork.model.projectile.BusterShot;
import battlenetwork.model.utility.Constants;
import battlenetwork.model.utility.Direction;
import battlenetwork.model.utility.Position;
import battlenetwork.model.utility.Side;
import battlenetwork.view.SoundBox;

public class Navi extends Actor implements IControllable{
	private final int playerID;
	private int shootDelay = 0;
	private int attack;
	
	private int charge = 0;
	private BusterStatus busterStatus = BusterStatus.READY;
	
	

	public Navi(Position p, int playerID) {
		super(p);
		this.playerID = playerID;
		this.setSide(Side.LEFT);
		this.attack = 1;
	}
	
	public Navi(Position p){
		this(p,0);
	}
	
	/**
	 * This enum represents the buster status
	 * Ready: Buster is not used and is ready to be fired
	 * Charging: Buster is now charging up
	 * Firing: Buster is firing a bullet and is busy
	 * @author frax
	 *
	 */
	public enum BusterStatus{
		READY, CHARGING, FIRING;
		
		public BusterStatus next(){
			switch(this){
			case CHARGING:
				return FIRING;
			case FIRING:
				return READY;
			case READY:
				return CHARGING;
			default:
				return READY;
			}
		}
	}

	public int getPlayerID() {
		return playerID;
	}
	
	@Override
	public void pressKey(Key key) {
		switch(key){
		case UP:
			if (getHeading() == Direction.NONE && readyToMove()){
				setHeading(Direction.UP);
				setMoveDelay(Constants.MOVE_DELAY);
			}
			break;
		case DOWN:
			if (getHeading() == Direction.NONE && readyToMove()){
				setHeading(Direction.DOWN);
				setMoveDelay(Constants.MOVE_DELAY);
			}
			break;
		case LEFT:
			if (getHeading() == Direction.NONE && readyToMove()){
				setHeading(Direction.LEFT);
				setMoveDelay(Constants.MOVE_DELAY);
			}
			break;
		case RIGHT:
			if (getHeading() == Direction.NONE && readyToMove()){
				setHeading(Direction.RIGHT);
				setMoveDelay(Constants.MOVE_DELAY);
			}
			break;
		case PRIMARY:
			
			break;
		case SECONDARY:
			if (busterStatus == BusterStatus.READY){
				busterStatus = BusterStatus.CHARGING;
				SoundBox.play("charging.ogg");
			}
			break;
		default:
			break;
		}
		
	}

	@Override
	public void releaseKey(Key key) {
		switch(key){
		case UP:
			break;
		case DOWN:
			break;
		case LEFT:
			break;
		case RIGHT:
			break;
		case PRIMARY:
			break;
		case SECONDARY:
			if (shootDelay <= 0 && busterStatus == BusterStatus.CHARGING){
				shootDelay = 500;
				shoot(charge);
			}
			break;
		default:
			break;
		}
		
	}
	
	public void shoot(int power){
		busterStatus = BusterStatus.FIRING;
		charge = 0;
		shootDelay = 500;
		
		BusterShot shot;
		
		if (power >= Constants.CHARGE_TIME){
			SoundBox.play("powershot.ogg");
			shot = new BusterShot(this.getPosition(), attack * Constants.CHARGE_MULTIPLIER);
		} else {
			SoundBox.play("shoot.ogg");
			shot = new BusterShot(this.getPosition(), attack);
		}
	}
	
	public int getCharge(){
		return charge;
	}
	
	public BusterStatus getBusterStatus(){
		return busterStatus;
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame game, int i) {
		super.update(gc, game, i);
		
		if (busterStatus == BusterStatus.CHARGING){
			charge += i;
		}
	
		if (shootDelay > 0){
			shootDelay -= i;
			if (shootDelay <= 0){
				shootDelay = 0;
				busterStatus = BusterStatus.READY;
			}
		}
	}
}
