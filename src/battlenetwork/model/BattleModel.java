package battlenetwork.model;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public class BattleModel {
	
	private List<Entity> entities;
	private List<Actor> players;
	private Field battleField;

	public BattleModel(){
		entities    = new ArrayList<Entity>();
		players    = new ArrayList<Actor>();
		battleField = new Field(new Position(256,256));
		
		//Add panels
		for (int i=0; i<battleField.getWidth(); i++){
			for (int j=0; j<battleField.getHeigth(); j++){
				addEntity(battleField.getPanel(i,j));
			}
		}
		//Add actors
		for (int i=0; i<battleField.getWidth(); i++){
			for (int j=0; j<battleField.getHeigth(); j++){
				if (battleField.getActor(i,j)!= null){
					addEntity(battleField.getActor(i,j));
				}
			}
		}
		
		//TODO Remove test
		addEntity(new Navi(battleField.getPosition(1, 1)));
		addEntity(new Enemy(battleField.getPosition(4, 1)));
		addEntity(new CustomGauge(new Position(640,64)));
		
	}
	
	public enum Key{
		LEFT, RIGHT, UP, DOWN, PRIMARY, SECONDARY, CUSTOMSCREEN, PAUSE;
		
		public Key opposite(){
			switch(this){
			case LEFT:
				return RIGHT;
			case RIGHT:
				return LEFT;
			case UP:
				return DOWN;
			case DOWN:
				return UP;
			default:
				return this;
			}
		}
	}
	
	public List<Entity> getEntityList(){
		return entities;
	}
	
	public void addEntity(Entity e){
		//TODO Fire entity-added-event
		if (e instanceof Navi){
			players.add((Navi)e);
		}
		
		entities.add(e);
		System.out.println("Added: " + e);
	}
	
	public void removeEntity(Entity e){
		//TODO Fire entity-removed-event
		entities.remove(e);
	}
	
	public void keyPressed(int playerID, Key key){
		System.out.println("Player " + playerID + " pressed " + key);
		players.get(playerID).pressKey(key);
		
	}
	
	public void keyReleased(int playerID, Key key){
		System.out.println("Player " + playerID + " released " + key);
		players.get(playerID).releaseKey(key);
	}
	
	
	
	public void update(GameContainer gc, StateBasedGame game, int i) {
		
		for (Actor p: players){
			if (p instanceof Navi){
				Navi n = (Navi)p;
				if (n.getHeading() != Direction.NONE /*&& n.readyToMove()*/){
					
					int[] pair = battleField.findActor(p);
					
					if (pair != null && battleField.accessAllowed(pair[0], pair[1], Side.LEFT)){
						battleField.move(p, p.getHeading());
					} else {
						n.setHeading(Direction.NONE);
					}
				}
				
			}

		}
		
		for (int j=0; j<entities.size();j++){
			entities.get(j).update(gc, game, i);
		}
		
	}

}
