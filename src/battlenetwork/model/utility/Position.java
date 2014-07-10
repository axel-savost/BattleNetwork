package battlenetwork.model.utility;

public class Position {

	private int x,y;
	
	public Position(int x, int y){
		this.setX(x);
		this.setY(y);
	}
	
	public Position(Position p,int x, int y){
		
		this.setX(x+p.getX());
		this.setY(y+p.getY());
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void move(int dx, int dy){
		this.x += dx;
		this.y += dy;
	}

	@Override
	public String toString(){
		return "(" + x + "," + y + ")";
	}
}
