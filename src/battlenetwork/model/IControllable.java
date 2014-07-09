package battlenetwork.model;

import battlenetwork.model.BattleModel.Key;

public interface IControllable {
	
	/**
	 * This method is called when a key has been pressed.
	 * @param key - The key
	 */
	public void pressKey(Key key);
	
	/**
	 * This method is called when a key has been released.
	 * @param key - The key
	 */
	public void releaseKey(Key key);
}
