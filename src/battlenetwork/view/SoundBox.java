package battlenetwork.view;

import java.io.File;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

import battlenetwork.model.utility.Constants;

public class SoundBox {

	public static void play(String name){
		if (!name.contains(".ogg")){
			name = name + ".ogg";
		}
		
		try {
			Sound s = new Sound(Constants.SOUND_FOLDER + name);
			s.play();
		} catch (SlickException e) {
			e.printStackTrace();
			System.out.println("No such sound file as " + Constants.SOUND_FOLDER + name);
		}
	}
	
	public static void tune(String name){
		if (!name.contains(".ogg")){
			name = name + ".ogg";
		}
		
		try {
			Music m = new Music(Constants.MUSIC_FOLDER + name);
			m.play(0.5f + Constants.RANDOM.nextFloat(), 1);
		} catch (SlickException e) {
			e.printStackTrace();
			System.out.println("No such sound file as " + Constants.MUSIC_FOLDER + name);
		}
	}
	
	public static void playRandomMusic(){
		File folder = new File(Constants.MUSIC_FOLDER);
		String[] names = folder.list();
		String pick = names[Constants.RANDOM.nextInt(names.length)];
		tune(pick);
	}

}
