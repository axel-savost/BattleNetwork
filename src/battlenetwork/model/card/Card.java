package battlenetwork.model.card;

public abstract class Card {
	private String name;
	private int power;
	private Element element;
	
	public Card(String name, int power, Element element){
		this.setName(name);
		this.setPower(power);
		this.setElement(element);
	}
	
	public Card(String name, int power){
		this(name,power,Element.NORMAL);
	}
	
	public Card(String name){
		this(name,0,Element.NORMAL);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}
	
	
	/**
	 * Called to use the card in question
	 */
	public abstract void use();
	
	
	
}
