package battlenetwork.model;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public class CustomGauge extends Entity {
	private double fullness=0;
	
	public CustomGauge(Position p) {
		super(p);
	}
	
	public int getFullness() {
		return (int)fullness;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int i) {
		if (fullness<Constants.CUSTOM_GAUGE_MAX_FULLNESS) {
			fullness=fullness+i*(double)Constants.CUSTOM_GAUGE_MAX_FULLNESS/Constants.CUSTOM_GAUGE_DEFAULT_FILL_TIME_MS;
			if (fullness>Constants.CUSTOM_GAUGE_MAX_FULLNESS){
				fullness=Constants.CUSTOM_GAUGE_MAX_FULLNESS;
			}
		}

	}

}
