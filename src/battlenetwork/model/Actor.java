package battlenetwork.model;

/**
 * An actor is acting in battle. This means it's on the battlefield and can be affected by other actors.
 * 
 * @author Axel
 */
public abstract class Actor extends Entity {
	private int hp;
	
	public Actor(Position p){
		super(p);
	}
	

}
