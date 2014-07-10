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
import battlenetwork.model.Enemy;
import battlenetwork.model.Entity;
import battlenetwork.model.Navi;
import battlenetwork.model.CustomGauge;
import battlenetwork.model.panel.CrackedPanel;
import battlenetwork.model.panel.HolePanel;
import battlenetwork.model.panel.LavaPanel;
import battlenetwork.model.panel.Panel;
import battlenetwork.model.utility.Constants;

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
				i = new Image(Constants.IMAGE_FOLDER + "panel.png");
				
				if (e instanceof LavaPanel){
					i = new Image(Constants.IMAGE_FOLDER + "panellava.png");
				}
				if (e instanceof CrackedPanel){
					i = new Image(Constants.IMAGE_FOLDER + "panelcracked.png");
				}
				if (e instanceof HolePanel){
					i = new Image(Constants.IMAGE_FOLDER + "panelbroken.png");
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
				
				
			} else if (e instanceof CustomGauge){
				i = new Image(Constants.IMAGE_FOLDER + "customborder.png");
				c = Color.white;
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
