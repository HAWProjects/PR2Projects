package haw.pr2.interfaces.physicValues;

import haw.pr2.interfaces.units.AccUnit;
import haw.pr2.interfaces.units.Multiplier;

public interface Acc extends AbstractValue<Acc> {
	public Force mul(Mass mass);
	public Speed mul(TimeDiff timeDiff);
	public Acc value(AccUnit lunit, Multiplier mult);
}
