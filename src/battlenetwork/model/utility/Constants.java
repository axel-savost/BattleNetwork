package battlenetwork.model.utility;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;

public class Constants {
	
	//Size and framerate of the game window
	public static final int GAME_WIDTH  = 1280;
	public static final int GAME_HEIGHT = 720;
	public static final int FRAMERATE   = 60;
	
	//Amount of tiles on one side
	public static final int TILES_H     = 3;
	public static final int TILES_V     = 3;
	
	//Panel dimensions
	public static final int PANEL_W     = 128;
	public static final int PANEL_H     = 64;
	
	//Milliseconds it takes from a key press to actual movement
	public static final int MOVE_DELAY  = 100;
	
	//Milliseconds it takes to charge buster
	public static final int CHARGE_TIME = 1000;
	
	//How many times stronger a charge shot is than a normal shot
	public static final int CHARGE_MULTIPLIER  = 10;
	
	//Milliseconds for a MegaBuster shot to travel one panel forward
	public static final int BULLET_SPEED= 50;
	
	//Damage taken by stepping onto a lava panel
	public static final int LAVA_PANEL_DAMAGE = 50;
	//Stun time in milliseconds when stepping onto a water panel
	public static final int WATER_PANEL_STUN  = 400;
	
	//Paths to data folders
	public static final String DATA_FOLDER  = "data/";
	public static final String IMAGE_FOLDER = DATA_FOLDER + "image/";
	public static final String SOUND_FOLDER = DATA_FOLDER + "sound/";
	public static final String MUSIC_FOLDER = DATA_FOLDER + "music/";
	
	//Colors
	public static final Color BACKGROUND_COLOR = new Color(64,96,64);
	public static final Color LEFT_TEAM_COLOR  = new Color(64,64,255);
	public static final Color RIGHT_TEAM_COLOR = new Color(255,64,64);
	
	//Dimensions of the custom gauge
	public static final int CUSTOM_GAUGE_W    = 512;
	public static final int CUSTOM_GAUGE_H    = 32;
	public static final Color CUSTOM_GAUGE_FILL_COLOR = new Color(64,64,255);
	public static final Color CUSTOM_GAUGE_BACKGROUND_COLOR = new Color(255,64,64);
	
	//TODO Anton - Skriv beskrivande text
	public static final int CUSTOM_GAUGE_MAX_FULLNESS    		= 1000;
	public static final int CUSTOM_GAUGE_DEFAULT_FILL_TIME   	= 10000;
	
	//Image of the shadow below actors
	public static final String SHADOW_IMAGE    = IMAGE_FOLDER + "shadows.png";
	
	
	//A Random to reduce unnecessary instancing
	public static final Random RANDOM = new Random();
	
	
	

}
