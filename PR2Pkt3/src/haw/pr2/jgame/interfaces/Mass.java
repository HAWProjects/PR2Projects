package haw.pr2.jgame.interfaces;

import haw.pr2.jgame.units.MassUnit;
import haw.pr2.jgame.units.Multiplier;

public interface Mass extends AbstractValue<Mass> {
	public Force mul(Acc acc);
	public Mass value(MassUnit lunit, Multiplier mult);
}
