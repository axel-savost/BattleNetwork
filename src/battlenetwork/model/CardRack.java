package battlenetwork.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Deque;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import battlenetwork.model.card.Card;
import battlenetwork.model.utility.Position;

public class CardRack extends Entity{
	
	private List<Card> cardList;

	
	
	
	public CardRack(Position p) {
		super(p);
		cardList = new LinkedList<Card>();
	}

	
	
	public void insertCard(Card c){
		cardList.add(c);
	}
	
	/**
	 * Removes the card to use and returns it.
	 * @return
	 */
	public Card takeCard(){
		Card c = cardList.get(0);
		cardList.remove(0);
		return c;
	}
	
	/**
	 * Returns the card without removing it.
	 * @return
	 */
	public Card seeCard(){
		return cardList.get(0);
	}
	
	public boolean isEmpty(){
		return cardList.isEmpty();
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int i) {
		// TODO Auto-generated method stub
		
	}

}
