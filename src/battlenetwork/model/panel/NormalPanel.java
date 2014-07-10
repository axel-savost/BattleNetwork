package battlenetwork.model.panel;

import battlenetwork.model.Actor;
import battlenetwork.model.utility.Position;
import battlenetwork.model.utility.Side;

public class NormalPanel extends Panel{

	public NormalPanel(Position p, Side side) {
		super(p, side);
	}

	@Override
	public void stepOn(Actor a) {
		//This method should be empty
	}

	@Override
	public void stepOff(Actor a) {
		//This method should be empty
	}

	@Override
	public Panel enteringChange() {
		return this;
	}

	@Override
	public Panel leavingChange() {
		return this;
	}


}
