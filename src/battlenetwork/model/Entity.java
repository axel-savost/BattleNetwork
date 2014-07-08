package battlenetwork.model;

public abstract class Entity {
	private Position position;
	
	public Entity(Position p){
		this.position = p;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

}
