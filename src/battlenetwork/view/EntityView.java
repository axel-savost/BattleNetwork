package battlenetwork.view;




import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

import battlenetwork.model.Entity;
import battlenetwork.model.Panel;
import battlenetwork.model.Position;

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
		Position p;
		if (entity instanceof Panel){
			p = convertToCenter(entity.getPosition());
		} else {
			p = convertToBottomCenter(entity.getPosition());
		}
		
		
		g.drawImage(sprite, p.getX(), p.getY(), color);
		
		//TODO Don't draw test rectangle
		g.setColor(Color.red);
		g.drawRect(entity.getPosition().getX() - 2, entity.getPosition().getY() - 2, 4, 4);
		
	}
	
	private Position convertToBottomCenter(Position p){
		return new Position(p.getX() - sprite.getWidth()/2, p.getY() - sprite.getHeight());
	}
	
	private Position convertToCenter(Position p){
		return new Position(p.getX() - sprite.getWidth()/2, p.getY() - sprite.getHeight()/2);
	}

	

}
