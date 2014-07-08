package battlenetwork.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.newdawn.slick.Input;
import battlenetwork.model.BattleModel;
import battlenetwork.model.BattleModel.Command;

public class ButtonMap {
	private int playerID;
	private Input input;
	private Map<Integer, BattleModel.Command> map;
	
	public ButtonMap(int playerID,Input input){
		map = new HashMap<Integer, Command>();
		this.playerID = playerID;
		this.input    = input;
	}
	
	public void setButton(int key, BattleModel.Command value){
		map.put(key, value);
	}
	
	public List<BattleModel.Command> getKeyPresses(){
		List<BattleModel.Command> list = new ArrayList<BattleModel.Command>();
		
		if (map.isEmpty()){
			return list;
		}
		
		for (int key: map.keySet()){
			if (input.isKeyPressed(key)){
				if (map.get(key).opposite() != map.get(key)){
					list.remove(map.get(key).opposite());
				}
				list.add(map.get(key));
			}
		}
		return list;
	}

	public int getID() {
		return playerID;
	}

	public void setID(int ID) {
		this.playerID = ID;
	}

}
