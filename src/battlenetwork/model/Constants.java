package battlenetwork.model;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;

public class Constants {
	public static final int GAME_WIDTH  = 1280;
	public static final int GAME_HEIGHT = 720;
	public static final int FRAMERATE   = 60;
	
	public static final int TILES_H     = 3;
	public static final int TILES_V     = 3;
	
	public static final int PANEL_W     = 128;
	public static final int PANEL_H     = 64;
	
	public static final int MOVE_DELAY  = 100;
	
	public static final String DATA_FOLDER  = "data/";
	public static final String IMAGE_FOLDER = DATA_FOLDER + "image/";
	public static final String SOUND_FOLDER = DATA_FOLDER + "sound/";
	public static final String MUSIC_FOLDER = DATA_FOLDER + "music/";
	
	public static final Color BACKGROUND_COLOR = new Color(64,96,64);
	public static final Color LEFT_TEAM_COLOR  = new Color(64,64,255);
	public static final Color RIGHT_TEAM_COLOR = new Color(255,64,64);
	
	public static final int CUSTOM_GAUGE_W    = 512;
	public static final int CUSTOM_GAUGE_H    = 32;
	public static final Color CUSTOM_GAUGE_FILL_COLOR = new Color(64,64,255);
	public static final Color CUSTOM_GAUGE_BACKGROUND_COLOR = new Color(255,64,64);
	
	public static final int CUSTOM_GAUGE_MAX_FULLNESS    = 1000;
	public static final int CUSTOM_GAUGE_DEFAULT_FILL_TIME_MS    = 10000;
	
	public static final String SHADOW_IMAGE    = IMAGE_FOLDER + "shadows.png";
	
	
	

}
