package haw.pr2.impl.values;

import haw.pr2.interfaces.physicValues.Length;
import haw.pr2.interfaces.physicValues.Speed;
import haw.pr2.interfaces.physicValues.TimeDiff;
import haw.pr2.interfaces.units.LengthUnit;
import haw.pr2.interfaces.units.Multiplier;


class LengthImpl extends AbstractValuesImpl<Length> implements Length {

   public static Length valueOf(double inValue) {
        return new LengthImpl(inValue);
    }
    
	private LengthImpl(double value) {
		super(value);
	}

	@Override
	public Length fromPrototype(double value) {
		return valueOf(value);
	}

	@Override
	public boolean checkInstance(Object obj) {
		return obj instanceof Length;
	}
	
	@Override
	public Length div(double other) {
		return Factory.length(this.value() / other);
	}
	@Override
	public Length div(Length length) {
		return Factory.length(this.value() / length.value());
	}
	

	@Override
	public Length mul(double other) {
		return Factory.length(this.value() * other);
	}

	@Override
	public TimeDiff div(Speed speed) {
		return Factory.time(this.value()/ speed.value());
	}

	@Override
	public Speed div(TimeDiff timeDiff) {
		return	Factory.speed(this.value() / timeDiff.value());
	}

	@Override
	public Length value(LengthUnit lunit, Multiplier mult)
	{
		return Factory.length(value, lunit, mult);
	}
}
