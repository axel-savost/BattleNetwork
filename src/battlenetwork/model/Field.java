package battlenetwork.model;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public class Field extends Entity {
	private Panel[][] panelGrid = new Panel[Constants.TILES_H*2][Constants.TILES_V];
	private Actor[][] actorGrid = new Actor[Constants.TILES_H*2][Constants.TILES_V];
	
	//TODO: More customizable constructor
	public Field(Position p) {
		super(p);
		//Player panels
		for (int i=0;i<Constants.TILES_H;i++){
			for (int j=0;j<Constants.TILES_V;j++){
				panelGrid[i][j] = new Panel(new Position(p,Constants.PANEL_W*i+Constants.PANEL_W/2,Constants.PANEL_H*j+Constants.PANEL_H/2),Side.LEFT);
			}
		}
		
		//Enemy panels
		for (int i=0;i<Constants.TILES_H;i++){
			for (int j=0;j<Constants.TILES_V;j++){
				panelGrid[i+Constants.TILES_H][j] = 
						new Panel(new Position(p,Constants.PANEL_W*(i+Constants.TILES_H)+Constants.PANEL_W/2,Constants.PANEL_H*j+Constants.PANEL_H/2),Side.RIGHT);
			}
		}
		
		//Player and an enemy
		actorGrid[1][1]=new Navi(getPosition(1, 1));
		actorGrid[4][1]=new Enemy(getPosition(4, 1));
		
	}
	
	public int getWidth(){
		return panelGrid.length;
	}
	
	public int getHeigth(){
		return panelGrid[0].length;
	}
	
	public Panel getPanel(int x, int y){
		if (x >= 0 && y >= 0 && x < Constants.TILES_H*2 && y < Constants.TILES_V){
			return panelGrid[x][y];
		} else {
			return null;
		}
		
	}
	
	public Actor getActor(int x, int y){
		if (x >= 0 && y >= 0 && x < Constants.TILES_H*2 && y < Constants.TILES_V){
			return actorGrid[x][y];
		} else {
			return null;
		}
	}
	
	public Position getPosition(int x, int y){
		return getPanel(x,y).getPosition();
	}
	
	public boolean accessAllowed(int x, int y, Side side){
		Panel panel = getPanel(x,y);
		if (panel == null || panel.getSide() != side || getActor(x,y) != null){
			//Access denied if the panel doesn't exist, if the panel's owner doesn't match or if there's an actor on it.			
			return false;
		} else {
			return true;
		}
	}
	
	public void move(Actor a, Direction d){
		int[] coords = findActor(a);
		if (coords != null && accessAllowed(coords[0] + d.getX(), coords[1] + d.getY(), a.getSide())){
			actorGrid[coords[0]][coords[1]] = null;
			actorGrid[coords[0] + d.getX()][coords[1] + d.getY()] = a;
			a.setPosition(this.getPosition(coords[0] + d.getX(), coords[1] + d.getY()));
		}
	}
	
	public int[] findActor(Actor a){
		if (a == null){
			return null;
		}
		
		for (int i = 0; i<actorGrid.length; i++){
			for (int j = 0; j<actorGrid[0].length; j++){
				System.out.println("in the loop at "+i+" "+j+" where there is "+actorGrid[i][j]);
				if (a.equals(actorGrid[i][j])){
					int[] in = {i,j};
					return in;
				}
			}
		}
		return null;
	}
	
	public void update(GameContainer gc, StateBasedGame game, int i){
		for (Panel p:getPanelList()){
			p.update(gc, game, i);
		}
		for (Actor a:getActorList()){
			a.update(gc, game, i);
		}
		
	}

}
