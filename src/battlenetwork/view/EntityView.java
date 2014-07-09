package battlenetwork.view;




import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import battlenetwork.model.Actor;
import battlenetwork.model.Constants;
import battlenetwork.model.Entity;
import battlenetwork.model.Panel;
import battlenetwork.model.Position;
import battlenetwork.model.CustomGauge;

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
		
		if (entity instanceof Actor){
			try {
				g.drawImage(new Image(Constants.SHADOW_IMAGE), p.getX(), p.getY() + 80, color);
			} catch (SlickException e) {
				System.out.println("Shadow doesn't exist! Check EntityView's render method!");
				System.exit(3);
			}
		}
		
		if (entity instanceof CustomGauge) {
			g.setColor(Constants.CUSTOM_GAUGE_BACKGROUND_COLOR);
			g.fillRect(p.getX(),p.getY(),Constants.CUSTOM_GAUGE_W,Constants.CUSTOM_GAUGE_H);
			g.setColor(Constants.CUSTOM_GAUGE_FILL_COLOR);
			g.fillRect(p.getX(),p.getY(),Constants.CUSTOM_GAUGE_W*((CustomGauge)entity).getFullness()/Constants.CUSTOM_GAUGE_MAX_FULLNESS,Constants.CUSTOM_GAUGE_H);
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
