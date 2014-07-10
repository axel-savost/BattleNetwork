package battlenetwork.model.panel;

import battlenetwork.model.Actor;
import battlenetwork.model.utility.Constants;
import battlenetwork.model.utility.Position;
import battlenetwork.model.utility.Side;

public class LavaPanel extends Panel {

	public LavaPanel(Position p, Side side) {
		super(p, side);
	}

	@Override
	public void stepOn(Actor a) {
		a.takeDamage(Constants.LAVA_PANEL_DAMAGE);

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
		return new NormalPanel(getPosition(),getSide());
	}

}
