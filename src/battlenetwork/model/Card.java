package battlenetwork.model;

public abstract class Card {
	private String name;
	private int power;
	private Element element;
	
	public enum Element{
		NORMAL, FIRE, AQUA, ELECTRIC, WOOD;
	}
}
