package haw.pr2.interfaces.physicValues;

import haw.pr2.interfaces.units.MassUnit;
import haw.pr2.interfaces.units.Multiplier;

public interface Mass extends AbstractValue<Mass> {
	public Force mul(Acc acc);
	public Mass value(MassUnit lunit, Multiplier mult);
}
