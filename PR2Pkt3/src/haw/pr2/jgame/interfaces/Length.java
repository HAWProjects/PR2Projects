package haw.pr2.jgame.interfaces;

public interface Length extends AbstractValue<Length> {
	
//	public value(LengthUnit lunit, Multiplier mult);
	
	public TimeDiff div(Speed speed);
	
	public Speed div(TimeDiff timeDiff);
}
