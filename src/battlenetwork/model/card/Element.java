package battlenetwork.model.card;

public enum Element {
	NORMAL, FIRE, AQUA, ELECTRIC, WOOD;
	
	public Element weakness(){
		switch(this){
		case FIRE:
			return AQUA;
		case AQUA:
			return ELECTRIC;
		case ELECTRIC:
			return WOOD;
		case WOOD:
			return FIRE;
		default:
			return null;
		}
	}
}
