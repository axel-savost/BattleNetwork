package battlenetwork.model;

import java.util.ArrayList;
import java.util.List;

import battlenetwork.model.panel.*;
import battlenetwork.model.utility.*;

public class Field {
	private Panel[][] panelGrid = new Panel[Constants.TILES_H*2][Constants.TILES_V];
	private Actor[][] actorGrid = new Actor[Constants.TILES_H*2][Constants.TILES_V];
	
	//TODO: More customizable constructor
	public Field(Position p){
		//Player panels
		for (int i=0;i<Constants.TILES_H;i++){
			for (int j=0;j<Constants.TILES_V;j++){
				panelGrid[i][j] = new NormalPanel(new Position(p,Constants.PANEL_W*i+Constants.PANEL_W/2,Constants.PANEL_H*j+Constants.PANEL_H/2),Side.LEFT);
			}
		}
		
		//Enemy panels
		for (int i=0;i<Constants.TILES_H;i++){
			for (int j=0;j<Constants.TILES_V;j++){
				panelGrid[i+Constants.TILES_H][j] = 
						new NormalPanel(new Position(p,Constants.PANEL_W*(i+Constants.TILES_H)+Constants.PANEL_W/2,Constants.PANEL_H*j+Constants.PANEL_H/2),Side.RIGHT);
			}
		}
		
		//Player and an enemy
		actorGrid[1][1]=new Navi(getPosition(1, 1));
		actorGrid[4][1]=new Enemy(getPosition(4, 1));
		
		//TODO TEMP
		changePanel(2,1,new LavaPanel(getPosition(2,1),getPanel(2,1).getSide()));
		changePanel(2,2,new LavaPanel(getPosition(2,2),getPanel(2,2).getSide()));
		changePanel(2,0,new LavaPanel(getPosition(2,0),getPanel(2,0).getSide()));
		changePanel(0,1,new LavaPanel(getPosition(0,1),getPanel(0,1).getSide()));
		
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
			System.out.println("Access allowed!");
			return true;
		}
	}
	
	public void move(Actor a, Direction d){
		int[] coords = findActor(a);
		if (coords != null && accessAllowed(coords[0] + d.getX(), coords[1] + d.getY(), a.getSide())){
			leaveCell(coords[0], coords[1]);
			enterCell(coords[0] + d.getX(), coords[1] + d.getY(), a);
			a.setPosition(this.getPosition(coords[0] + d.getX(), coords[1] + d.getY()));
			System.out.println("Moved!");
		}
	}
	
	/**
	 * Actor a enters cell (x,y), replacing whatever was there before.
	 * @param x - Coordinate
	 * @param y - Coordinate
	 * @param a - Actor to enter
	 */
	public void enterCell(int x, int y, Actor a){
		Panel p = getPanel(x,y);
		actorGrid[x][y] = a;
		p.stepOn(a);
		
		//Change panel if necessary
		if (p.enteringChange() != null){
			System.out.println(getPosition(x,y));
			p.enteringChange().setPosition(getPosition(x,y));
			changePanel(x,y,p.enteringChange());
		}
	}
	
	/**
	 * Actor leaves the cell (x,y).
	 * @param x - Coordinate
	 * @param y - Coordinate
	 */
	public void leaveCell(int x, int y){
		Panel p = getPanel(x,y);
		p.stepOff(getActor(x,y));
		actorGrid[x][y] = null;
		
		//Change panel if necessary
		if (p.leavingChange() != null){
			p.leavingChange().setPosition(getPosition(x,y));
			changePanel(x,y,p.leavingChange());
		}
	}
	
	public void changePanel(int x, int y, Panel p){
		panelGrid[x][y] = p;
	}
	
	public List<Actor> getActorList(){
		List<Actor> list = new ArrayList<Actor>();
		
		for (Actor[] aa: actorGrid){
			for (Actor a: aa){
				if (a != null){
					list.add(a);
				}
			}
		}
		
		return list;
	}
	
	public List<Panel> getPanelList(){
		List<Panel> list = new ArrayList<Panel>();
		
		for (Panel[] pp: panelGrid){
			for (Panel p: pp){
				if (p != null){
					list.add(p);
				}
			}
		}
		
		return list;
	}
	
	public int[] findActor(Actor a){
		if (a == null){
			return null;
		}
		
		for (int i = 0; i<actorGrid.length; i++){
			for (int j = 0; j<actorGrid[0].length; j++){
				if (a.equals(actorGrid[i][j])){
					int[] in = {i,j};
					return in;
				}
			}
		}
		return null;
	}

}
