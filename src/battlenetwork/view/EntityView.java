package battlenetwork.view;




import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import battlenetwork.model.Actor;
import battlenetwork.model.CardRack;
import battlenetwork.model.Entity;
import battlenetwork.model.CustomGauge;
import battlenetwork.model.Navi;
import battlenetwork.model.Navi.BusterStatus;
import battlenetwork.model.panel.Panel;
import battlenetwork.model.utility.Constants;
import battlenetwork.model.utility.Position;

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
		
		//Draw Shadow
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
		
		if (entity instanceof CardRack){
			CardRack rack = (CardRack)entity;
			g.setColor(Color.blue);
			g.fillRect(p.getX(),p.getY(),Constants.CUSTOM_GAUGE_W,Constants.CUSTOM_GAUGE_H);
			g.setColor(Color.yellow);
			if (!rack.isEmpty()){
				g.drawString(rack.seeCard().getName(),p.getX(),p.getY());
			}
		}
		
		//Draw the actual sprite!!!
		if (entity instanceof Navi && ((Navi)entity).getBusterStatus() == BusterStatus.FIRING){
			try {
				g.drawImage(new Image(Constants.IMAGE_FOLDER + "fighterfiring.png"), p.getX(), p.getY(), color);
			} catch (SlickException e) {
				e.printStackTrace();
				System.exit(1);
			}
		} else {
			g.drawImage(sprite, p.getX(), p.getY(), color);
		}
		
		//End of draw sprite
		
		
		//Draw Hitpoints for Actors
		if (entity instanceof Actor){
			g.setColor(Color.yellow);
			g.drawString("" + ((Actor)entity).getHp(), entity.getPosition().getX(), entity.getPosition().getY());
		}
		
		//Draw Hitpoints for Actors
		if (entity instanceof Actor){
			g.setColor(Color.yellow);
			g.drawString("" + ((Actor)entity).getMoveDelay(), entity.getPosition().getX(), entity.getPosition().getY() - 64);
		}
		
		if (entity instanceof Navi){
			g.setColor(Color.yellow);
			g.drawString(((Navi)entity).getCharge() + " " + ((Navi)entity).getBusterStatus(), entity.getPosition().getX() - 16, entity.getPosition().getY() + 16);
		}
		
		
		//Uncomment this to draw a square around every entity's position (0,0)
		//g.setColor(Color.red);
		//g.drawRect(entity.getPosition().getX() - 2, entity.getPosition().getY() - 2, 4, 4);
		
	}
	
	private Position convertToBottomCenter(Position p){
		if (p == null){
			throw new NullPointerException("Don't convert null positions please");
		}
		return new Position(p.getX() - sprite.getWidth()/2, p.getY() - sprite.getHeight());
	}
	
	private Position convertToCenter(Position p){
		return new Position(p.getX() - sprite.getWidth()/2, p.getY() - sprite.getHeight()/2);
	}

	

}
