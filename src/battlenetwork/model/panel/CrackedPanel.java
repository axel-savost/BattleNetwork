package battlenetwork.model.panel;

import battlenetwork.model.Actor;
import battlenetwork.model.utility.Position;
import battlenetwork.model.utility.Side;
import battlenetwork.view.SoundBox;

public class CrackedPanel extends Panel {

	public CrackedPanel(Position p, Side side) {
		super(p, side);
	}

	@Override
	public void stepOn(Actor a) {
		// TODO Auto-generated method stub

	}

	@Override
	public void stepOff(Actor a) {
		// TODO Auto-generated method stub

	}

	@Override
	public Panel enteringChange() {
		return null;
	}

	@Override
	public Panel leavingChange() {
		SoundBox.play("crack.ogg");
		return new HolePanel(getPosition(),getSide());
	}

}
