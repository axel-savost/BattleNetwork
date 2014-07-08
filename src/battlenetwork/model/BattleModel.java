package battlenetwork.model;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public class BattleModel {
	
	private List<Entity> entities;

	public BattleModel(){
		entities = new ArrayList<Entity>();
		
		//TODO Remove test
		addEntity(new Navi(new Position(0,0)));
		addEntity(new Enemy(new Position(128,128)));
		addEntity(new Panel(new Position(256,256)));
		
	}
	
	public List<Entity> getEntityList(){
		return entities;
	}
	
	public void addEntity(Entity e){
		//TODO Fire entity-added-event
		entities.add(e);
		System.out.println("Added: " + e);
	}
	
	public void removeEntity(Entity e){
		//TODO Fire entity-removed-event
		entities.remove(e);
	}
	
	
	
	public void update(GameContainer gc, StateBasedGame game, int i) {
		// TODO Auto-generated method stub
		
	}

}
