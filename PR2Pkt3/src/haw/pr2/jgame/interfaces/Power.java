package haw.pr2.jgame.interfaces;

import haw.pr2.jgame.units.Multiplier;
import haw.pr2.jgame.units.PowerUnit;

public interface Power extends AbstractValue<Power> {
	public Speed div(Force force);
	public Force div(Speed speed);
	public Power value(PowerUnit lunit, Multiplier mult);
}
