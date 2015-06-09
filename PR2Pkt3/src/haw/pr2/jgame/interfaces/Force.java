package haw.pr2.jgame.interfaces;

import haw.pr2.jgame.units.ForceUnit;
import haw.pr2.jgame.units.Multiplier;

public interface Force extends AbstractValue<Force> {
	public Acc div(Mass mass);
	public Mass div(Acc acc); 
	public Force mul(Speed speed);
	public Force value(ForceUnit lunit, Multiplier mult);
}
