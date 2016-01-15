package battlenetwork.model.panel;

import battlenetwork.model.Actor;
import battlenetwork.model.utility.Constants;
import battlenetwork.model.utility.Position;
import battlenetwork.model.utility.Side;

public class WaterPanel extends Panel {

	public WaterPanel(Position p, Side side) {
		super(p, side);
	}

	@Override
	public void stepOn(Actor a) {
		a.setMoveDelay(Constants.WATER_PANEL_STUN);

	}

	@Override
	public void stepOff(Actor a) {
		// TODO Auto-generated method stub

	}

	@Override
	public Panel leavingChange() {
		return null;
	}

	@Override
	public Panel enteringChange() {
		return null;
	}

}
