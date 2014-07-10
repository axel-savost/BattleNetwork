package battlenetwork.controller;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.command.BasicCommand;
import org.newdawn.slick.command.Command;
import org.newdawn.slick.command.InputProvider;
import org.newdawn.slick.command.InputProviderListener;
import org.newdawn.slick.command.KeyControl;
import org.newdawn.slick.state.StateBasedGame;

import battlenetwork.model.BattleModel;
import battlenetwork.model.BattleModel.Key;
import battlenetwork.view.SoundBox;

public class BattleController implements InputProviderListener{
	private BattleModel model;
	private InputProvider provider;

	public BattleController(BattleModel model, Input input) {
		this.model = model;
		
		//Set input keys
		provider = new InputProvider(input);
	    provider.addListener(this);
	    provider.bindCommand(new KeyControl(Input.KEY_W), new BasicCommand("UP"));
	    provider.bindCommand(new KeyControl(Input.KEY_A), new BasicCommand("LEFT"));
	    provider.bindCommand(new KeyControl(Input.KEY_S), new BasicCommand("DOWN"));
	    provider.bindCommand(new KeyControl(Input.KEY_D), new BasicCommand("RIGHT"));
	    provider.bindCommand(new KeyControl(Input.KEY_ENTER), new BasicCommand("CUSTOM"));
	    provider.bindCommand(new KeyControl(Input.KEY_J), new BasicCommand("PRIMARY"));
	    provider.bindCommand(new KeyControl(Input.KEY_K), new BasicCommand("SECONDARY"));
	    provider.bindCommand(new KeyControl(Input.KEY_PAUSE), new BasicCommand("PAUSE"));
	}

	public void update(GameContainer gc, StateBasedGame game, int i) {
		
		
	}

	@Override
	public void controlPressed(Command c) {
		BasicCommand b = (BasicCommand) c;
		switch(b.getName()) {
	    case "UP":
	    	model.keyPressed(0, Key.UP);
	    	break;
	    case "DOWN":
	    	model.keyPressed(0, Key.DOWN);
	    	break;
	    case "LEFT":
	    	model.keyPressed(0, Key.LEFT);
	        break;
	    case "RIGHT":
	    	model.keyPressed(0, Key.RIGHT);
	    	break;
	    case "CUSTOM":
	    	model.keyPressed(0, Key.CUSTOMSCREEN);
	    	break;
	    case "PRIMARY":
	    	model.keyPressed(0, Key.PRIMARY);
	    	break;
	    case "SECONDARY":
	    	model.keyPressed(0, Key.SECONDARY);
	    	break;
	    case "PAUSE":
	    	model.keyPressed(0, Key.PAUSE);
	    	break;
	    default:
	    	break;
	    }
		
	}

	@Override
	public void controlReleased(Command c) {
		BasicCommand b = (BasicCommand) c;
		switch(b.getName()) {
	    case "UP":
	    	model.keyReleased(0, Key.UP);
	    	break;
	    case "DOWN":
	    	model.keyReleased(0, Key.DOWN);
	    	break;
	    case "LEFT":
	    	model.keyReleased(0, Key.LEFT);
	        break;
	    case "RIGHT":
	    	model.keyReleased(0, Key.RIGHT);
	    	break;
	    case "CUSTOM":
	    	model.keyReleased(0, Key.CUSTOMSCREEN);
	    	break;
	    case "PRIMARY":
	    	model.keyReleased(0, Key.PRIMARY);
	    	break;
	    case "SECONDARY":
	    	model.keyReleased(0, Key.SECONDARY);
	    	break;
	    case "PAUSE":
	    	model.keyReleased(0, Key.PAUSE);
	    	break;
	    default:
	    	break;
	    }
		
	}


}
