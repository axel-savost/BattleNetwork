package battlenetwork.model;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import battlenetwork.model.utility.Direction;
import battlenetwork.model.utility.Position;
import battlenetwork.model.utility.Side;
import battlenetwork.view.SoundBox;

import battlenetwork.model.panel.Panel;

public class BattleModel {
	
	private List<Entity> entities;
	private List<Actor> players;
	private Field battleField;

	public BattleModel(){
		entities    = new ArrayList<Entity>();
		players    = new ArrayList<Actor>();
		battleField = new Field(new Position(256,256));
		/*
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
		}*/
		for (Actor a: battleField.getActorList()){
			if (a instanceof Navi) {
				players.add((Navi)a);
			}
		}
		
		addEntity(new CustomGauge(new Position(640,64)));
		
		SoundBox.playRandomMusic();
		
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
		List<Entity> allEntities = new ArrayList<Entity>();
		allEntities.addAll(entities);
		allEntities.addAll(battleField.getPanelList());
		allEntities.addAll(battleField.getActorList());
		return allEntities;
		
	}
	
	public void addEntity(Entity e){
		//TODO Fire entity-added-event
		/*if (e instanceof Navi){
			players.add((Navi)e);
		}*/
		
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
				if (n.getHeading() != Direction.NONE && n.readyToMove()){
					System.out.println("Moving");
					int[] pair = battleField.findActor(p);
					pair[0]=pair[0]+n.getHeading().getX();
					pair[1]=pair[1]+n.getHeading().getY();
					
					if (pair != null && battleField.accessAllowed(pair[0], pair[1], Side.LEFT)){
						battleField.move(p, p.getHeading());
					}
						n.setHeading(Direction.NONE);
				}
				
			}

		}
		for (Panel p:battleField.getPanelList()){
			p.update(gc, game, i);
		}
		for (Actor a:battleField.getActorList()){
			a.update(gc, game, i);
		}
		for (int j=0; j<entities.size();j++){
			entities.get(j).update(gc, game, i);
		}
		
	}

}
