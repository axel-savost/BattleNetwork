package battlenetwork.model;



import battlenetwork.model.BattleModel.Key;
import battlenetwork.model.utility.Constants;
import battlenetwork.model.utility.Direction;
import battlenetwork.model.utility.Position;
import battlenetwork.model.utility.Side;

public class Navi extends Actor implements IControllable{
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
			
			break;
		default:
			break;
		}
		
	}

	@Override
	public void releaseKey(Key key) {
		// TODO Auto-generated method stub
		
	}
	

}
