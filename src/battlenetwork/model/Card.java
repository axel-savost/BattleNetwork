package battlenetwork.model;

public class Card {
	private String name;
	private int power;
	private Element element;
	
	public enum Element{
		NORMAL, FIRE, AQUA, ELECTRIC, WOOD;
	}
}
