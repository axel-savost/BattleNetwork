package battlenetwork.controller;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

import battlenetwork.model.BattleModel;
import battlenetwork.model.BattleModel.Command;

public class BattleController {
	
	private List<ButtonMap> playerMaps;
	private BattleModel model;

	public BattleController(BattleModel model, Input input) {
		this.model = model;
		playerMaps = new ArrayList<ButtonMap>();
		
		//Controls for player 1
		ButtonMap map = new ButtonMap(1,input);
		map.setButton(Input.KEY_A, Command.LEFT);
		map.setButton(Input.KEY_D, Command.RIGHT);
		map.setButton(Input.KEY_W, Command.UP);
		map.setButton(Input.KEY_S, Command.DOWN);
		map.setButton(Input.KEY_K, Command.PRIMARY);
		map.setButton(Input.KEY_L, Command.SECONDARY);
		map.setButton(Input.KEY_ENTER, Command.CUSTOMSCREEN);
		map.setButton(Input.KEY_PAUSE, Command.PAUSE);
		playerMaps.add(map);
	}

	public void update(GameContainer gc, StateBasedGame game, int i) {
		for (ButtonMap map: playerMaps){
			List<Command> list = map.getKeyPresses();
			if (!list.isEmpty()){
				for (Command c: list){
					model.recieveCommand(map.getID(), c);
				}
			}
		}
		
	}

}
