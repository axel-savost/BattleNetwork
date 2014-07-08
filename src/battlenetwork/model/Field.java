package battlenetwork.model;

public class Field {
	private Panel[][] panelGrid = new Panel[Constants.TILES_H*2][Constants.TILES_V];
	
	public Field(){
		
		//Player panels
		for (int i=0;i<Constants.TILES_H;i++){
			for (int j=0;j<Constants.TILES_V;j++){
				panelGrid[i][j] = new Panel(new Position(Constants.PANEL_H*i,Constants.PANEL_W*j));
			}
		}
		//Enemy panels
		for (int i=0;i<Constants.TILES_H;i++){
			for (int j=0;j<Constants.TILES_V;j++){
				panelGrid[i+3][j] = new Panel(new Position(Constants.PANEL_H*(i+3),Constants.PANEL_W*j));
			}
		}
	}
	
	public int getWidth(){
		System.out.println("W: " + panelGrid.length);
		return panelGrid.length;
	}
	
	public int getHeigth(){
		System.out.println("H: " + panelGrid[0].length);
		return panelGrid[0].length;
	}
	
	public Panel getPanel(int x, int y){
		return panelGrid[x][y];
	}

}
