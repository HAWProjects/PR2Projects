package haw.pr2.interfaces.physicValues;

import haw.pr2.interfaces.units.LengthUnit;
import haw.pr2.interfaces.units.Multiplier;



public interface Length extends AbstractValue<Length> {
	
	public Length value(LengthUnit lunit, Multiplier mult);
	
	public TimeDiff div(Speed speed);
	
	public Speed div(TimeDiff timeDiff);

	Length div(Length length);
}
