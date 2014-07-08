package battlenetwork.controller;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import battlenetwork.model.Constants;


public class Main {
	public static void main(String[] args) {
		try {
            AppGameContainer container = new AppGameContainer(new BattleNetworkGame("Battle Time!"));
            container.setDisplayMode(Constants.GAME_WIDTH, Constants.GAME_HEIGHT, false);
            container.setTargetFrameRate(Constants.FRAMERATE);
            container.start();
        } catch (SlickException e) { //TODO Proper exception handling. 
            e.printStackTrace();
        }
	}

}
