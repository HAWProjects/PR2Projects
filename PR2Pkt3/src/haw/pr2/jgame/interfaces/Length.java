package haw.pr2.jgame.interfaces;

import haw.pr2.jgame.units.LengthUnit;
import haw.pr2.jgame.units.Multiplier;



public interface Length extends AbstractValue<Length> {
	
	public Length value(LengthUnit lunit, Multiplier mult);
	
	public TimeDiff div(Speed speed);
	
	public Speed div(TimeDiff timeDiff);
}
