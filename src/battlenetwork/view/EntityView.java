package battlenetwork.view;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

import battlenetwork.model.Entity;

public class EntityView {
	private final Entity entity;
	private Image sprite;
	private Color color;

	public EntityView(Entity entity, Image sprite){
		this(entity,sprite,Color.white);
	}
	
	public EntityView(Entity entity, Image sprite, Color color){
		this.entity = entity;
		this.sprite = sprite;
		this.color  = color;
	}
	
	
	public Entity getEntity() {
		return entity;
	}
	
	
	public void render(GameContainer gc, StateBasedGame game, Graphics g) {
		g.drawImage(sprite, entity.getPosition().getX(), entity.getPosition().getY(), color);
		
	}

	

}
