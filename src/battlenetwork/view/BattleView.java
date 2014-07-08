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
		Image i = null;
		Color c;
		//Pick a sprite using data from the entity
		
		if (e instanceof Enemy){
			c = Color.red;
		} else if (e instanceof Navi){
			c = Color.blue;
		} else if (e instanceof Panel){
			c = Color.white;
		} else {
			c = Color.black;
		}
		
		try {
			//TODO Default
			i = new Image(Constants.IMAGE_FOLDER + "panel.png");
			
		} catch (SlickException e1) {
			
			e1.printStackTrace();
			System.out.println("Something went wrong. Check BattleView.assignSprite.");
		}
		
		
		entityMap.put(e, new EntityView(e,i,c));
	}

}
