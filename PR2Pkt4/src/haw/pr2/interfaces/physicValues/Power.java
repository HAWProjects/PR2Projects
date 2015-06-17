package haw.pr2.interfaces.physicValues;

import haw.pr2.interfaces.units.Multiplier;
import haw.pr2.interfaces.units.PowerUnit;

public interface Power extends AbstractValue<Power> {
	public Speed div(Force force);
	public Force div(Speed speed);
	public Power value(PowerUnit lunit, Multiplier mult);
}
