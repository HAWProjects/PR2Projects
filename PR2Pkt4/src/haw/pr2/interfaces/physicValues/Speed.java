package haw.pr2.interfaces.physicValues;

import haw.pr2.interfaces.units.LengthUnit;
import haw.pr2.interfaces.units.Multiplier;

public interface Speed extends AbstractValue<Speed> {
	public Length mul(TimeDiff timeDiff);
	public Force dragForce(Speed maxSpeed, Power maxPower);
	public Speed mul(Speed speed);
	public Acc curveAcc(Length length);
	
	public Speed value(LengthUnit lunit, Multiplier mult);
	
}
