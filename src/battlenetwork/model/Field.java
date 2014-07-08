package battlenetwork.model;

public class Field {
	private Panel[][] panelGrid = new Panel[Constants.TILES_H*2][Constants.TILES_V];
	private Actor[][] actorGrid = new Actor[Constants.TILES_H*2][Constants.TILES_V];
	
	//TODO: More customizable constructor
	public Field(Position p){
		
		//Player panels
		for (int i=0;i<Constants.TILES_H;i++){
			for (int j=0;j<Constants.TILES_V;j++){
				panelGrid[i][j] = new Panel(new Position(p,Constants.PANEL_W*i,Constants.PANEL_H*j));
			}
		}
		//Enemy panels
		for (int i=0;i<Constants.TILES_H;i++){
			for (int j=0;j<Constants.TILES_V;j++){
				panelGrid[i+3][j] = new Panel(new Position(p,Constants.PANEL_W*(i+3),Constants.PANEL_H*j));
			}
		}
		
		
		
	}
	
	public int getWidth(){
		return panelGrid.length;
	}
	
	public int getHeigth(){
		return panelGrid[0].length;
	}
	
	public Panel getPanel(int x, int y){
		return panelGrid[x][y];
	}
	
	public Actor getActor(int x, int y){
		return actorGrid[x][y];
	}

}
