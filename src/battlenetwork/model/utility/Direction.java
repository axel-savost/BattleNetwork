package battlenetwork.model.utility;

public enum Direction {
	LEFT(-1,0), UP(0,-1), RIGHT(1,0), DOWN(0,1), NONE(0,0);
	
	private final int dx, dy;
	
	private Direction(int dx, int dy){
		this.dx = dx;
		this.dy = dy;
	}
	
	public Direction opposite(){
		switch(this){
			case LEFT:
				return RIGHT;
			case RIGHT:
				return LEFT;
			case UP:
				return DOWN;
			case DOWN:
				return UP;
			default:
				return this;
		}
	}

	public int getX() {
		return dx;
	}

	public int getY() {
		return dy;
	}
	
}
