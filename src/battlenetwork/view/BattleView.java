package battlenetwork.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import battlenetwork.controller.BattleController;
import battlenetwork.model.BattleModel;
import battlenetwork.model.Constants;
import battlenetwork.model.Enemy;
import battlenetwork.model.Entity;
import battlenetwork.model.Navi;
import battlenetwork.model.Panel;

public class BattleView {
	
	private BattleModel model;
	private BattleController controller;
	private Map<Entity,EntityView> entityMap;
	
	
	public BattleView(BattleModel model, BattleController controller) {
		this.model      = model;
		this.controller = controller;
		this.entityMap  = new HashMap<Entity,EntityView>();
	}

	public void render(GameContainer gc, StateBasedGame game, Graphics g) {
		for (Entity e: model.getEntityList()){
			//If this entity is not mapped to its own view, then map it
			if (!(entityMap.containsKey(e))){
				assignSprite(e);
			}
			
			//Render the EntityView
			entityMap.get(e).render(gc, game, g);
		}
	}
	
	public void assignSprite(Entity e){
		if (e == null){
			throw new NullPointerException("This should not be able to happen. Check assignSprite in BattleView.");
		}
		Image i = null;
		Color c = null;
		//Pick a sprite using data from the entity
		
		try {
			//TODO Default
			
			if (e instanceof Enemy){
				i = new Image(Constants.IMAGE_FOLDER + "enemy.png");
				c = Color.red;
			} else if (e instanceof Navi){
				i = new Image(Constants.IMAGE_FOLDER + "fighter.png");
				c = Color.blue;
			} else if (e instanceof Panel){
				//Choose sprite after panel type
				switch(((Panel)e).getType()){
					case NORMAL:
						i = new Image(Constants.IMAGE_FOLDER + "panel.png");
						break;
					case CRACKED:
						i = new Image(Constants.IMAGE_FOLDER + "panelcracked.png");
						break;
					case BROKEN:
						i = new Image(Constants.IMAGE_FOLDER + "panelbroken.png");
						break;
					default:
						i = new Image(Constants.IMAGE_FOLDER + "panel.png");
						break;
				}
				
				//Choose colour after panel side
				switch (((Panel)e).getSide()){
				case LEFT:
					c = Constants.LEFT_TEAM_COLOR;
					break;
				case RIGHT:
					c = Constants.RIGHT_TEAM_COLOR;
					break;
				default:
					c = Color.white;
					break;
				}
			} else {
				i = new Image(Constants.IMAGE_FOLDER + "error.png");
				c = Color.black;
			}
			
		} catch (SlickException e1) {
			
			e1.printStackTrace();
			System.out.println("Something went wrong. Check BattleView.assignSprite.");
		}
		
		
		entityMap.put(e, new EntityView(e,i,c));
	}

}
