package battlenetwork.controller;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.command.InputProvider;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import battlenetwork.model.BattleModel;
import battlenetwork.model.utility.Constants;
import battlenetwork.view.BattleView;

public class BattleState extends BasicGameState{
	private BattleController controller;
	private BattleModel model;
	private BattleView view;

	@Override
	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		
	    
	    
		model      = new BattleModel();
		controller = new BattleController(model,gc.getInput());
		view       = new BattleView(model,controller);
		
		//Set Background Colour
		gc.getGraphics().setBackground(Constants.BACKGROUND_COLOR);
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g)
			throws SlickException {
		view.render(gc,game,g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int i)
			throws SlickException {
		model.update(gc,game,i);
		controller.update(gc,game,i);
	}

	@Override
	public int getID() {
		return 5;
	}

	


}
