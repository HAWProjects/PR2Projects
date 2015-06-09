package haw.pr2.jgame.interfaces;

import haw.pr2.jgame.units.AccUnit;
import haw.pr2.jgame.units.Multiplier;

public interface Acc extends AbstractValue<Acc> {
	public Force mul(Mass mass);
	public Speed mul(TimeDiff timeDiff);
	public Acc value(AccUnit lunit, Multiplier mult);
}
