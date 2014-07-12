package battlenetwork.model;

public interface IReadField {
	
	public int getWidth();
	
	public int getHeigth();
	
	public boolean accessAllowed(int x, int y, Actor actor);
	
	public int[] findActor(Actor a);
	
	
	
}
