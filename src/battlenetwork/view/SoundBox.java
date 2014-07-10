package battlenetwork.view;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

import battlenetwork.model.utility.Constants;

public class SoundBox {

	public static void play(String name){
		try {
			Sound s = new Sound(Constants.SOUND_FOLDER + name + ".ogg");
			s.play();
		} catch (SlickException e) {
			e.printStackTrace();
			System.out.println("No such sound file as " + Constants.SOUND_FOLDER + name + ".ogg");
		}
	}

}
