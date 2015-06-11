package haw.pr2.jgame.interfaces;

import haw.pr2.jgame.units.LengthUnit;
import haw.pr2.jgame.units.Multiplier;
import haw.pr2.jgame.units.SpeedUnit;

public interface Speed extends AbstractValue<Speed> {
	public Length mul(TimeDiff timeDiff);
	public Force dragForce(Speed maxSpeed, Power maxPower);
	public Speed mul(Speed speed);
	public Acc curveAcc(Length length);
	
	public Speed value(LengthUnit lunit, Multiplier mult);
	
}
